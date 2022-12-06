package no.country.clinica.mapper;

import no.country.clinica.domain.model.Address;
import no.country.clinica.domain.model.Specialty;
import no.country.clinica.dto.AddressDTO;
import no.country.clinica.dto.SpecialtyDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper {

    public Address addressDtoToAddressEntity(AddressDTO addressDto) {
        Address addressEntity = new Address();
        addressEntity.setId(addressDto.getId());
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setStreetNumber(addressDto.getStreetNumber());
        addressEntity.setLocation(addressDto.getLocation());
        addressEntity.setProvince(addressDto.getProvince());
        return addressEntity;
    }
    public AddressDTO addressEntityToAddressDto(Address savedEntity) {
        AddressDTO addressDto = new AddressDTO();
        addressDto.setId(savedEntity.getId());
        addressDto.setStreet(savedEntity.getStreet());
        addressDto.setStreetNumber(savedEntity.getStreetNumber());
        addressDto.setLocation(savedEntity.getLocation());
        addressDto.setProvince(savedEntity.getProvince());
        return addressDto;
    }

    public List<AddressDTO> addressEntityListToAddressDtoList(List<Address> memberList) {
        List<AddressDTO> addressDTOList = new ArrayList<>();
        for (Address entity : memberList) {
            addressDTOList.add(this.addressEntityToAddressDto(entity));
        }
        return addressDTOList;
    }


    public void addressDto2EntityWithId(Address addressEntity, AddressDTO dto) {
        setAttributerSpecialtyDto2Entity(dto,addressEntity);
    }

    private void setAttributerSpecialtyDto2Entity(AddressDTO addressDto, Address addressEntity) {
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setStreetNumber(addressDto.getStreetNumber());
        addressEntity.setLocation(addressDto.getLocation());
        addressEntity.setProvince(addressDto.getProvince());
    }
}
