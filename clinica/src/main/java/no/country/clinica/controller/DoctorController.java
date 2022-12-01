package no.country.clinica.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.country.clinica.domain.model.Doctor;
import no.country.clinica.domain.service.DoctorService;

@RestController
@RequestMapping({"/doctors"})
@CrossOrigin
public class DoctorController {
    
    private final Logger log = LoggerFactory.getLogger(DoctorController.class);
    
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping("")
    public List<Doctor> allDoctors() {
        return doctorService.list();
    }
    
    @PostMapping("")
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor){
        if(doctor.getId() != null){
            log.warn("trying to create a doctor with id");
            System.out.println("trying to create a doctor with id");
            return ResponseEntity.badRequest().build();
        }
        doctorService.create(doctor);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("")
    public ResponseEntity<Doctor> update(Doctor doctor){
        if(doctor.getId() != null ){
            log.warn("Trying to update a non existent doctor");
            return ResponseEntity.badRequest().build();
        }
        doctor = doctorService.findDoctor(doctor); 
        if(doctor==null){
            log.warn("Trying to update a non existent doctor");
            return ResponseEntity.notFound().build();
        }
        doctorService.create(doctor);
        return ResponseEntity.accepted().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delete(@PathVariable Long id, Doctor doctor){
        doctor = doctorService.findDoctor(doctor); 
        if(doctor==null){
            log.warn("Trying to update a non existent doctor");
            return ResponseEntity.notFound().build();
        }

        doctorService.delete(doctor);

        return ResponseEntity.noContent().build();
    }
}
