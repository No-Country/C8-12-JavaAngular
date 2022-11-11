package no.country.clinica.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
@ToString @EqualsAndHashCode
public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nameDoctor")
    private String nombre;

    @Getter @Setter @Column(name = "lastname")
    private String apellido;

    @Getter @Setter @Column(name = "idSpecialty")
    private int idSpecialty;
}
