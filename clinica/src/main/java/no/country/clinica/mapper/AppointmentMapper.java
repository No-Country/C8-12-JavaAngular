package no.country.clinica.mapper;

import no.country.clinica.domain.model.Appointment;
import no.country.clinica.dto.AppointmentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper {

    public Appointment appointmentDtoToAppointmentEntity(AppointmentDTO appointmentDto) {
        Appointment appointmentEntity = new Appointment();
        appointmentEntity.setId(appointmentDto.getId());
        appointmentEntity.setDateTimeAppointment(appointmentDto.getDateTimeAppointment());
        appointmentEntity.setDoctor(appointmentDto.getDoctor());
        appointmentEntity.setPatient(appointmentDto.getPatient());
        return appointmentEntity;
    }
    public AppointmentDTO appointmentEntityToAppointmentDto(Appointment savedEntity) {
        AppointmentDTO appointmentDto = new AppointmentDTO();
        appointmentDto.setId(savedEntity.getId());
        appointmentDto.setDateTimeAppointment(savedEntity.getDateTimeAppointment());
        appointmentDto.setDoctor(savedEntity.getDoctor());
        appointmentDto.setPatient(savedEntity.getPatient());
        return appointmentDto;
    }

    public List<AppointmentDTO> appointmentEntityListToAppointmentDtoList(List<Appointment> memberList) {
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        for (Appointment entity : memberList) {
            appointmentDTOList.add(this.appointmentEntityToAppointmentDto(entity));
        }
        return appointmentDTOList;
    }


    public void appointmentDto2EntityWithId(Appointment appointmentEntity, AppointmentDTO dto) {
        setAttributerSpecialtyDto2Entity(dto,appointmentEntity);
    }

    private void setAttributerSpecialtyDto2Entity(AppointmentDTO appointmentdto, Appointment appointmentEntity) {
        appointmentEntity.setDateTimeAppointment(appointmentdto.getDateTimeAppointment());
        appointmentEntity.setDoctor(appointmentdto.getDoctor());
        appointmentEntity.setPatient(appointmentdto.getPatient());
    }
}
