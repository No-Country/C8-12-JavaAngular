package no.country.clinica.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import no.country.clinica.model.Doctor;
import no.country.clinica.repository.DoctorRepository;

@RestController
@RequestMapping({"/doctors"})
public class DoctorController {
    
    private final Logger log = LoggerFactory.getLogger(DoctorController.class);
    
    private DoctorRepository doctorRepository;
    
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    
    @GetMapping("")
    public List<Doctor> doctors() {
        return doctorRepository.findAll();
    }
    
    @PostMapping("")
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor){
        if(doctor.getId() != null){
            log.warn("trying to create a doctor with id");
            System.out.println("trying to create a doctor with id");
            return ResponseEntity.badRequest().build();
        }
        Doctor result = doctorRepository.save(doctor);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }

    @PutMapping("")
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor){
        if(doctor.getId() != null ){
            log.warn("Trying to update a non existent doctor");
            return ResponseEntity.badRequest().build();
        }
        if(!doctorRepository.existsById(doctor.getId())){
            log.warn("Trying to update a non existent doctor");
            return ResponseEntity.notFound().build();
        }
        Doctor result = doctorRepository.save(doctor);
        return ResponseEntity.ok(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delete(@PathVariable Long id){

        if(!doctorRepository.existsById(id)){
            log.warn("Trying to delete a non existent doctor");
            return ResponseEntity.notFound().build();
        }

        doctorRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
