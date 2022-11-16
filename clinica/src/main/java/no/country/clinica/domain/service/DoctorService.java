package no.country.clinica.domain.service;

import java.util.List;

import no.country.clinica.domain.model.Doctor;

public interface DoctorService {
    public List<Doctor> list();
    
    public Doctor create(Doctor doctor);
    
    public void delete(Doctor doctor);
    
    public Doctor findDoctorById(Long id);
}
