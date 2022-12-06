package no.country.clinica.domain.service.impl;

import no.country.clinica.domain.model.Patient;
import no.country.clinica.domain.repository.PatientRepository;
import no.country.clinica.domain.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional
    public List<Patient> getAll() throws Exception {
        try{
            return patientRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Patient getById(Long id) throws Exception {
        try{
            if(patientRepository.existsById(id)){
                Optional<Patient> patientOptional = patientRepository.findById(id);
                return patientOptional.get();
            }else{
                throw new Exception("The patient doesn't exist in the data base");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Patient save(Patient patient) throws Exception {
        try {
            patientRepository.save(patient);
            return patient;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Patient updateById(Patient patient, Long id) throws Exception {
        try{
            if(patientRepository.existsById(id)){
                Optional<Patient> patientOptional = patientRepository.findById(id);
                Patient patientUpdated = patientOptional.get();
                patientUpdated.setName(patient.getName());
                patientUpdated.setLastName(patient.getLastName());
                patientUpdated.setDni(patient.getDni());
                patientUpdated.setPassword(patient.getPassword());
                patientUpdated.setEmail(patient.getEmail());
                patientRepository.save(patientUpdated);
                return patientUpdated;
            }else {
                throw new Exception("The patient doesn't exist in the data base");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) throws Exception {
        try{
            if(patientRepository.existsById(id)){
                Optional<Patient> patientOptional = patientRepository.findById(id);
                Patient patient = patientOptional.get();
                patient.setDeleted(true);
                patientRepository.save(patient);
            }else{
                throw new Exception("The patient doesn't exist in the data base");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
