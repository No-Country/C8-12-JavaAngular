package no.country.clinica.mapper;

import no.country.clinica.domain.model.Patient;
import no.country.clinica.dto.PatientDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper {

    public Patient patientDtoToPatientEntity(PatientDTO patientDto) {
        Patient patientEntity = new Patient();
        patientEntity.setId(patientDto.getId());
        patientEntity.setName(patientDto.getName());
        patientEntity.setLastName(patientDto.getLastName());
        patientEntity.setDni(patientDto.getDni());
        return patientEntity;
    }
    public PatientDTO patientEntityToPatientDto(Patient entity) {
        PatientDTO patientDto = new PatientDTO();
        patientDto.setId(entity.getId());
        patientDto.setName(entity.getName());
        patientDto.setLastName(entity.getLastName());
        patientDto.setDni(entity.getDni());
        return patientDto;
    }

    public List<PatientDTO> patientEntityListToPatientDtoList(List<Patient> patientList) {
        List<PatientDTO> dtoArrayList = new ArrayList<>();
        for (Patient entity : patientList) {
            dtoArrayList.add(this.patientEntityToPatientDto(entity));
        }
        return dtoArrayList;
    }
}
