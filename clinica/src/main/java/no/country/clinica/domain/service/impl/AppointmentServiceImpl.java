package no.country.clinica.domain.service.impl;

import no.country.clinica.domain.model.Appointment;
import no.country.clinica.domain.repository.AppointmentRepository;
import no.country.clinica.domain.service.IAppointmentService;
import no.country.clinica.dto.AppointmentDTO;
import no.country.clinica.exception.NotFoundException;
import no.country.clinica.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService  {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentDTO addAppointment(AppointmentDTO appointmentDto) {
        Appointment appointmentEntity = appointmentMapper.appointmentDtoToAppointmentEntity(appointmentDto);
        Appointment saveEntity = appointmentRepository.save(appointmentEntity);
        return appointmentMapper.appointmentEntityToAppointmentDto(saveEntity);
    }

    @Override
    public AppointmentDTO updateById(AppointmentDTO dto, Long id) {
        Appointment appointmentEntity = appointmentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("ID: "+id));
        appointmentMapper.appointmentDto2EntityWithId(appointmentEntity,dto);
        Appointment entitySaved = appointmentRepository.save(appointmentEntity);
        return appointmentMapper.appointmentEntityToAppointmentDto(entitySaved);
    }

    @Override
    public void deleteById(Long id) {
            Appointment appointment = appointmentRepository.findById(id).orElseThrow(()
                    -> new NotFoundException("Appointment not found with id: " + id));
            appointment.setDeleted(true);
            appointmentRepository.save(appointment);
    }

    @Override
    public List<AppointmentDTO> getAll() {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        if(appointmentList.isEmpty()){
            throw new NotFoundException("The list is empty");
        }
        return appointmentMapper.appointmentEntityListToAppointmentDtoList(appointmentList);
    }
}
