package no.country.clinica.domain.service;

import no.country.clinica.domain.model.Patient;

import java.util.List;

public interface IPatientService {

    List<Patient> getAll() throws Exception;
    Patient getById(Long id) throws Exception;
    Patient save(Patient patient) throws Exception;
    Patient updateById(Patient patient, Long id) throws Exception;
    void deleteById(Long id) throws Exception;

}