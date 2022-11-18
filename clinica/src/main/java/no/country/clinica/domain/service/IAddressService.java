package no.country.clinica.domain.service;

import no.country.clinica.domain.model.Address;

import java.util.List;

public interface IAddressService {

    List<Address> getAll() throws Exception;

    Address getById(Long id) throws Exception;

    Address save(Address patient) throws Exception;

    Address updateById(Address patient, Long id) throws Exception;

    void deleteById(Long id) throws Exception;

}
