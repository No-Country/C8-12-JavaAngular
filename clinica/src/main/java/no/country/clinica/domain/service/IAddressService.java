package no.country.clinica.domain.service;

import no.country.clinica.domain.model.Address;
import no.country.clinica.dto.AddressDTO;
import no.country.clinica.dto.SpecialtyDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAddressService {

    @Transactional
    AddressDTO addAddress(AddressDTO addressDTO);

    AddressDTO updateById(AddressDTO dto, Long id);

    void deleteById(Long id);

    List<AddressDTO> getAll();

}
