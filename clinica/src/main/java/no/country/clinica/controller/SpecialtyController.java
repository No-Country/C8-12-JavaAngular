package no.country.clinica.controller;

import no.country.clinica.domain.service.ISpecialtyService;
import no.country.clinica.domain.service.impl.SpecialtyServiceImpl;
import no.country.clinica.domain.util.Url;
import no.country.clinica.dto.SpecialtyDTO;
import no.country.clinica.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Url.SPECIALTIES_URI)
@CrossOrigin
public class SpecialtyController {

    @Autowired
    private ISpecialtyService specialtyService;

    @PostMapping
    public ResponseEntity<SpecialtyDTO> addSpecialty(@Valid @RequestBody SpecialtyDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
        SpecialtyDTO savedSpecialty = specialtyService.addSpecialty(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSpecialty);
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyDTO>> getAllSpecialities(){
        List<SpecialtyDTO> result = this.specialtyService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> updateSpecialty(@Valid @RequestBody SpecialtyDTO dto,
                                                  @PathVariable Long id,
                                                  BindingResult result){
        if (result.hasErrors()) {throw new BadRequestException(result);}
        return new ResponseEntity<>(specialtyService.updateById(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable(name = "id") Long id){
        specialtyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
