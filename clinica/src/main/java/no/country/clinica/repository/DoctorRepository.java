package no.country.clinica.repository;

import no.country.clinica.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
}
