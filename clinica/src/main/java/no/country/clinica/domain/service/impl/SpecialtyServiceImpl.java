package no.country.clinica.domain.service.impl;

import no.country.clinica.domain.model.Specialty;
import no.country.clinica.domain.repository.SpecialtyRepository;
import no.country.clinica.domain.service.ISpecialtyService;
import no.country.clinica.dto.SpecialtyDTO;
import no.country.clinica.exception.NotFoundException;
import no.country.clinica.mapper.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements ISpecialtyService {

    @Autowired
    private SpecialtyMapper specialtyMapper;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public SpecialtyDTO addSpecialty(SpecialtyDTO specialtyDto) {
        Specialty SpecialityEntity = specialtyMapper.specialtyDtoToSpecialtyEntity(specialtyDto);
        Specialty savedEntity = specialtyRepository.save(SpecialityEntity);
        return specialtyMapper.specialtyEntityToSpecialtyDto(savedEntity);
    }

    @Override
    public SpecialtyDTO updateById(SpecialtyDTO dto, Long id) {
        Specialty specialtyEntity = specialtyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID: " + id));
        specialtyMapper.specialtyDto2EntityWithId(specialtyEntity,dto);
        Specialty entitySaved = specialtyRepository.save(specialtyEntity);
        return specialtyMapper.specialtyEntityToSpecialtyDto(entitySaved);
    }

    @Override
    public void deleteById(Long id) {
        Specialty specialty = specialtyRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Specialty not found with id: " + id));
        specialty.setDeleted(true);
        specialtyRepository.save(specialty);
    }

    @Override
    public List<SpecialtyDTO> getAll() {
        List<Specialty> specialtyList = specialtyRepository.findAll();
        if(specialtyList.isEmpty()){
            throw new NotFoundException("The list is empty");
        }
        return specialtyMapper.specialtyEntityListToSpecialtyDtoList(specialtyList);
    }
}
