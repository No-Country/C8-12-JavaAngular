package no.country.clinica.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.country.clinica.domain.model.Address;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private Integer dni;

    private AddressDTO address;
}
