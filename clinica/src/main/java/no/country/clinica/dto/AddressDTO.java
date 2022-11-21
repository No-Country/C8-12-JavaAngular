package no.country.clinica.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class AddressDTO {

    private Long id;

    @NotNull
    private String street;

    @NotNull
    @Column(name = "street_number")
    private Integer streetNumber;

    @NotNull
    private String location;

    private String province;

}
