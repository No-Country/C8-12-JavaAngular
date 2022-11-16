package no.country.clinica.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import no.country.clinica.dao.DoctorDao;
import no.country.clinica.domain.service.DoctorService;
import no.country.clinica.domain.model.Doctor;

@Service
public class DoctorServiceImp implements DoctorService {
    
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public List<Doctor> list() {
        return (List<Doctor>) doctorDao.findAll();
    }

    @Override
    public Doctor create(Doctor doctor) {
        return (Doctor) doctorDao.save(doctor);
    }

    @Override
    public void delete(Doctor doctor) {
        doctorDao.delete(doctor);
    }
    
    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findById(id).orElse(null);
    }
}
