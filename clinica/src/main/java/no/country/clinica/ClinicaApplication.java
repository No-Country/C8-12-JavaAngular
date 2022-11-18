package no.country.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import no.country.clinica.dao.DoctorDao;
import no.country.clinica.domain.model.Doctor;

@SpringBootApplication
public class ClinicaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ClinicaApplication.class, args);

    }

}
