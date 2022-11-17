package no.country.clinica.domain.service.impl;

import no.country.clinica.domain.model.Manager;
import no.country.clinica.domain.model.Patient;
import no.country.clinica.domain.repository.ManagerRepository;
import no.country.clinica.domain.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    @Transactional
    public List<Manager> getAll() throws Exception {
        try{
            return managerRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Manager getById(Long id) throws Exception {
        try{
            if(managerRepository.existsById(id)){
                Optional<Manager> managerOptional = managerRepository.findById(id);
                return managerOptional.get();
            }else{
                throw new Exception("The manager doesn't exist in the data base");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Manager save(Manager patient) throws Exception {
        try {
            managerRepository.save(patient);
            return patient;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Manager updateById(Manager manager, Long id) throws Exception {
        try{
            if(managerRepository.existsById(id)){
                Optional<Manager> managerOptional = managerRepository.findById(id);
                Manager managerUpdated = managerOptional.get();
                managerUpdated.setName(manager.getName());
                managerUpdated.setLastName(manager.getLastName());
                managerUpdated.setDni(manager.getDni());
                managerUpdated.setPassword(manager.getPassword());
                managerUpdated.setEmail(manager.getEmail());
                managerRepository.save(managerUpdated);
                return managerUpdated;
            }else {
                throw new Exception("The manager doesn't exist in the data base");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) throws Exception {
        try{
            if(managerRepository.existsById(id)){
                Optional<Manager> managerOptional = managerRepository.findById(id);
                Manager manager = managerOptional.get();
                manager.setDeleted(true);
                managerRepository.save(manager);
            }else{
                throw new Exception("The manager doesn't exist in the data base");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
