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
    @Transactional(readOnly = true)
    public List<Doctor> list() {
        return (List<Doctor>) doctorDao.findAll();
    }

    @Override
    @Transactional
    public void create(Doctor doctor) {
        doctorDao.save(doctor);
    }

    @Override
    @Transactional
    public void delete(Doctor doctor) {
        doctorDao.delete(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public Doctor findDoctor(Doctor doctor) {
        return doctorDao.findById(doctor.getId()).orElse(null);
    }
    
}
