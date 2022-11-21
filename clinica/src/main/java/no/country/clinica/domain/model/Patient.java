package no.country.clinica.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE patients SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Patient implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(unique = true)
    private Integer dni;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @OneToOne
    @JoinColumn(name = "id_address" , referencedColumnName = "id")
    private Address address;

    /*@OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Appointment> appointments;*/

    @JsonIgnore
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<Appointment> appointments = new HashSet<>();

    private boolean deleted = Boolean.FALSE;

}

