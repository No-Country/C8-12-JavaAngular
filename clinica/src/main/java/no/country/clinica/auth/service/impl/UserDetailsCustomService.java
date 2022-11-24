package no.country.clinica.auth.service.impl;

import no.country.clinica.auth.config.SecurityConfiguration;
import no.country.clinica.auth.dto.AuthenticationRequest;
import no.country.clinica.auth.dto.AuthenticationResponse;
import no.country.clinica.auth.dto.UserRequestDto;
import no.country.clinica.auth.dto.UserResponseDto;
import no.country.clinica.auth.repository.UserRepository;
import no.country.clinica.auth.service.JwtUtils;
import no.country.clinica.domain.model.Role;
import no.country.clinica.domain.model.UserEntity;
import no.country.clinica.domain.repository.RoleRepository;
import no.country.clinica.domain.service.IEmailService;
import no.country.clinica.enums.RolName;
import no.country.clinica.exception.ConflictException;
import no.country.clinica.exception.ForbiddenException;
import no.country.clinica.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IEmailService emailService;

    @Autowired
    private JwtUtils jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByEmail(userName);
        if (!userEntity.isPresent()) {
            throw new UsernameNotFoundException("The username or password is incorrect");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        for (Role role : userEntity.get().getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        UserEntity user = userEntity.get();
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), roles);
    }


    @Transactional()
    public boolean save(UserRequestDto userRequestDto) throws Exception {
        String encrypted = securityConfiguration.passwordEncoder().encode(userRequestDto.getPassword());
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequestDto.getEmail());
        userEntity.setPassword(encrypted);
        UserEntity userEntityResult;
        userEntityResult = this.userRepository.save(userEntity);
        return userEntityResult != null;
    }

    @Transactional()
    public UserResponseDto register(UserRequestDto userRequestDto) throws Exception {

        Optional<UserEntity> userEntity = userRepository.findByEmail(userRequestDto.getEmail());
        if (userEntity.isPresent()) {
            throw new ConflictException("There is already an account with this email " + userRequestDto.getEmail());
        }
        UserEntity user;
        user = userMapper.userDto2Entity(userRequestDto);
        user.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
        Role role = roleRepository.findByName(RolName.ROLE_USER.toString()).get();
        user.setRoles(Arrays.asList(role));
        UserEntity result = userRepository.save(user);
        UserResponseDto userResponseDto = userMapper.userEntity2ResponseDto(result);

        emailService.sendWelcomeEmail(userRequestDto.getEmail());

        return userResponseDto;
    }

    public UserResponseDto getProfile(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String jwt = authorizationHeader.substring(7);
        String username = jwtTokenUtil.extractUsername(jwt);
        UserEntity entity = userRepository.findByEmail(username).get();
        UserResponseDto responseDto = userMapper.userEntity2ResponseDto(entity);
        return responseDto;
    }

     public AuthenticationResponse login(AuthenticationRequest authRequest){
        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new ForbiddenException("Incorrect username or password");
        }
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return new AuthenticationResponse(jwt);

     }
}
