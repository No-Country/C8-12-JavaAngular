package no.country.clinica.dao;

import org.springframework.data.repository.CrudRepository;

import no.country.clinica.domain.model.Doctor;

public interface DoctorDao extends CrudRepository<Doctor, Long>{
    
}
