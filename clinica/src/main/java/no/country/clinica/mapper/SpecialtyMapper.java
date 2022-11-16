package no.country.clinica.mapper;

import no.country.clinica.domain.model.Specialty;
import no.country.clinica.dto.SpecialtyDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpecialtyMapper {

    public Specialty specialtyDtoToSpecialtyEntity(SpecialtyDTO specialtyDto) {
        Specialty specialtyEntity = new Specialty();
        specialtyEntity.setId(specialtyDto.getId());
        specialtyEntity.setNameSpecialty(specialtyDto.getNameSpecialty());
        specialtyEntity.setDescription(specialtyDto.getDescription());
        setAttributerSpecialtyDto2Entity(specialtyDto,specialtyEntity);
        return specialtyEntity;
    }
    public SpecialtyDTO specialtyEntityToSpecialtyDto(Specialty savedEntity) {
        SpecialtyDTO specialtyDto = new SpecialtyDTO();
        specialtyDto.setId(savedEntity.getId());
        specialtyDto.setNameSpecialty(savedEntity.getNameSpecialty());
        specialtyDto.setDescription(savedEntity.getDescription());
        return specialtyDto;
    }

    public List<SpecialtyDTO> specialtyEntityListToSpecialtyDtoList(List<Specialty> memberList) {
        List<SpecialtyDTO> specialtyDTOList = new ArrayList<>();
        for (Specialty entity : memberList) {
            specialtyDTOList.add(this.specialtyEntityToSpecialtyDto(entity));
        }
        return specialtyDTOList;
    }


    public void specialtyDto2EntityWithId(Specialty specialtyEntity, SpecialtyDTO dto) {
        setAttributerSpecialtyDto2Entity(dto,specialtyEntity);
    }

    private void setAttributerSpecialtyDto2Entity(SpecialtyDTO specialtyDto, Specialty specialtyEntity) {
        specialtyEntity.setNameSpecialty(specialtyDto.getNameSpecialty());
        specialtyEntity.setDescription(specialtyDto.getDescription());
    }
}
