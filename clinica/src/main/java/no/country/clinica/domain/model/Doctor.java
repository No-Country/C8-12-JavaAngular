package no.country.clinica.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstname")
    private String nameDoctor;
    @Column(name="lastname")
    private String lastname;
    @Column(name="dni")
    private String dni;
    @Column(name="license")
    private String license;
    @Column(name="gender")
    private String gender;
    @Column(name="email")
    private String email;
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Specialty specialty;

    public Doctor() {
    }

    public Doctor(String nameDoctor, String lastname, String dni, String license, String gender, String email) {
        this.nameDoctor = nameDoctor;
        this.lastname = lastname;
        this.dni = dni;
        this.license = license;
        this.gender = gender;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
    
    
}