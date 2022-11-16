package no.country.clinica.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import no.country.clinica.domain.model.Doctor;
import no.country.clinica.domain.model.Specialty;
import no.country.clinica.domain.repository.SpecialtyRepository;
import no.country.clinica.domain.service.DoctorService;

@RestController
@RequestMapping({"/doctors"})
public class DoctorController {

    private final Logger log = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("")
    public List<Doctor> allDoctors() {
        return doctorService.list();
    }

    @PostMapping("")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        if (doctor.getId() != null) {
            log.warn("trying to create a doctor with id");
            System.out.println("trying to create a doctor with id");
            return ResponseEntity.badRequest().build();
        }
        Doctor _doctor = doctorService.create(new Doctor(doctor.getNameDoctor(), 
                doctor.getLastname(), doctor.getDni(),  doctor.getLicense(), 
                doctor.getGender(), doctor.getEmail()));
        return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Doctor> addSpecialty(@PathVariable(value = "id") Long id) {
        Doctor doctor = doctorService.findDoctorById(id);
        
        Optional<Specialty> optionalSpecialty = specialtyRepository.findById(id);
        Specialty specialty = optionalSpecialty.get();
        
        if (doctor == null) {
            log.warn("Trying to update a non existent doctor");
            return ResponseEntity.notFound().build();
        }
        doctor.setSpecialty(specialty);
        doctorService.create(doctor);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<Doctor> update(@PathVariable(value = "doctorId") Long doctorId, @RequestBody Doctor newDoctor) {
        Doctor doctor = doctorService.findDoctorById(doctorId);
        if (doctor == null) {
            log.warn("Trying to update a non existent doctor");
            return ResponseEntity.badRequest().build();
        }
        doctorService.create(newDoctor);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delete(@PathVariable Long id) {
        Doctor doctor = doctorService.findDoctorById(id);
        if (doctor == null) {
            log.warn("Trying to delete a non existent doctor");
            return ResponseEntity.notFound().build();
        }
        doctorService.delete(doctor);
        return ResponseEntity.noContent().build();
    }
}
