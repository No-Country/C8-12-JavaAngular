package no.country.clinica.domain.service;

import no.country.clinica.domain.model.Manager;

import java.util.List;

public interface IManagerService {

    List<Manager> getAll() throws Exception;

    Manager getById(Long id) throws Exception;

    Manager save(Manager patient) throws Exception;

    Manager updateById(Manager patient, Long id) throws Exception;

    void deleteById(Long id) throws Exception;
}
