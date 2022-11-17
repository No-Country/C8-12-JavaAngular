package no.country.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyDTO {

    private Long id;

    @NotNull(message = "Name cannot be null")
    @Column(name = "namespecialty")
    private String nameSpecialty;

    @Nullable
    @Column(name = "description")
    private String description;

}
