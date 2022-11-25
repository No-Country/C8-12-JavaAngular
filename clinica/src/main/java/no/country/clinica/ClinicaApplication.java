package no.country.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ClinicaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ClinicaApplication.class, args);

         /*
        DoctorDao repository = context.getBean(DoctorDao.class);

        Doctor doctor1 = new Doctor("Hester", "Leverentz", 1);
        Doctor doctor2 = new Doctor("Nanete", "Greber", 2);
        Doctor doctor3 = new Doctor("Vania", "Arnull", 3);
        Doctor doctor4 = new Doctor("Marco", "Reynoldson", 4);
        Doctor doctor5 = new Doctor("Antonino", "Crocetto", 5);
        Doctor doctor6 = new Doctor("Carissa", "Dunthorn", 5);
        Doctor doctor7 = new Doctor("Gayelord", "Blackburn", 4);
        Doctor doctor8 = new Doctor("Sean", "Handy", 3);
        Doctor doctor9 = new Doctor("Harp", "Pentin", 2);
        Doctor doctor10 = new Doctor("Parsifal", "Lagneaux", 1);

        repository.save(doctor1);
	repository.save(doctor2);
        repository.save(doctor3);
	repository.save(doctor4);
        repository.save(doctor5);
	repository.save(doctor6);
        repository.save(doctor7);
	repository.save(doctor8);
        repository.save(doctor9);
	repository.save(doctor10);
         */
    }

}
