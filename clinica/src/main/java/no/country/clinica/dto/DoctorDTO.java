package no.country.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private Long id;

    @Column(name="firstname")

    private String nameDoctor;
    @Column(name="lastname")

    private String lastname;

    private SpecialtyDTO specialty;
}
