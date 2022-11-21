package no.country.clinica.domain.service.impl;

import no.country.clinica.domain.model.Address;
import no.country.clinica.domain.repository.AddressRepository;
import no.country.clinica.domain.service.IAddressService;
import no.country.clinica.dto.AddressDTO;
import no.country.clinica.exception.NotFoundException;
import no.country.clinica.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {


    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public AddressDTO addAddress(AddressDTO addressDto) {
        Address addressEntity = addressMapper.addressDtoToAddressEntity(addressDto);
        Address savedEntity = addressRepository.save(addressEntity);
        return addressMapper.addressEntityToAddressDto(savedEntity);
    }

    @Override
    public AddressDTO updateById(AddressDTO dto, Long id) {
        Address addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID: " + id));
        addressMapper.addressDto2EntityWithId(addressEntity,dto);
        Address entitySaved = addressRepository.save(addressEntity);
        return addressMapper.addressEntityToAddressDto(entitySaved);
    }

    @Override
    public void deleteById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Address not found with id: " + id));
        address.setDeleted(true);
        addressRepository.save(address);
    }

    @Override
    public List<AddressDTO> getAll() {
        List<Address> addressesList = addressRepository.findAll();
        if(addressesList.isEmpty()){
            throw new NotFoundException("The list is empty");
        }
        return addressMapper.addressEntityListToAddressDtoList(addressesList);
    }
}
