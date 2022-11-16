package no.country.clinica.domain.repository;

import no.country.clinica.domain.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository <Specialty,Long>{
}
