package no.country.clinica.domain.service;

import no.country.clinica.dto.AppointmentDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAppointmentService {
    @Transactional
    AppointmentDTO addAppointment(AppointmentDTO appointmentDto);

    AppointmentDTO updateById(AppointmentDTO dto, Long id);

    void deleteById(Long id);

    List<AppointmentDTO> getAll();
}
