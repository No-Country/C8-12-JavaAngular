package no.country.clinica.domain.service;

import no.country.clinica.dto.SpecialtyDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISpecialtyService {

    @Transactional
    SpecialtyDTO addSpecialty(SpecialtyDTO specialtyDto);

    SpecialtyDTO updateById(SpecialtyDTO dto, Long id);

    void deleteById(Long id);

    List<SpecialtyDTO> getAll();

}
