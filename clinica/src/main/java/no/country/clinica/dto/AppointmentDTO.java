package no.country.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.country.clinica.domain.model.Doctor;
import no.country.clinica.domain.model.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;
    private LocalDateTime dateTimeAppointment;
    private Doctor doctor;
    private Patient patient;

}
