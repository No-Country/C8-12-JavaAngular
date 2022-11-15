package no.country.clinica.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstname")
    private String nameDoctor;
    @Column(name="lastname")
    private String lastname;
    
    private int idSpecialty;
    
    private Boolean deleted = Boolean.FALSE;

    public Doctor(String nameDoctor, String lastname, int idSpecialty) {
        this.nameDoctor = nameDoctor;
        this.lastname = lastname;
        this.idSpecialty = idSpecialty;
    }

    public Doctor(){
        
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

    public int getIdSpecialty() {
        return idSpecialty;
    }

    public void setIdSpecialty(int idSpecialty) {
        this.idSpecialty = idSpecialty;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    
    
}