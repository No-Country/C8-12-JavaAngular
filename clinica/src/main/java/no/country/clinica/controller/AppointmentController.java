package no.country.clinica.controller;

import no.country.clinica.domain.service.IAddressService;
import no.country.clinica.domain.service.IAppointmentService;
import no.country.clinica.domain.util.Url;
import no.country.clinica.dto.AddressDTO;
import no.country.clinica.dto.AppointmentDTO;
import no.country.clinica.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Url.APPOINTMENTS_URI)
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> addAppointment(@Valid @RequestBody AppointmentDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result);
        }
        AppointmentDTO savedAppointment = appointmentService.addAppointment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@Valid @RequestBody AppointmentDTO dto,
                                                    @PathVariable Long id,
                                                    BindingResult result){
        if (result.hasErrors()) {throw new BadRequestException(result);}
        return new ResponseEntity<>(appointmentService.updateById(dto,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable(name = "id") Long id){
        appointmentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        List<AppointmentDTO> result = this.appointmentService.getAll();
        return ResponseEntity.ok().body(result);
    }
}
