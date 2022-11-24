package no.country.clinica.auth.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import no.country.clinica.domain.model.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Getter
@Setter
public class UserRequestDto {

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    private String password;

    private List<Role> roles;
}
