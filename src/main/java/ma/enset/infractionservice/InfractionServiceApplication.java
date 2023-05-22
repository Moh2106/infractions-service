package ma.enset.infractionservice;

import lombok.AllArgsConstructor;
import ma.enset.infractionservice.dto.InfractionDTO;
import ma.enset.infractionservice.entities.Infraction;
import ma.enset.infractionservice.repositories.InfractionRepository;
import ma.enset.infractionservice.service.InfractionService;
import ma.enset.infractionservice.service.InfractionServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class InfractionServiceApplication implements CommandLineRunner {

    InfractionServiceImpl infractionService;
    InfractionRepository infractionRepository;

    public static void main(String[] args) {
        SpringApplication.run(InfractionServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i<10 ; i++){
            Infraction infraction = Infraction.builder()
                    .date(Math.random() + "-2023")
                    .matricule_vehicule("MA-"+ Math.random()*1020)
                    .montant_infraction(Math.random()*2000)
                    .numero_radar((int) Math.random()*100)
                    .vitesse_maximale((Double) Math.random()*200)
                    .build();

            infractionRepository.save(infraction);
            //infractionService.save(infractionDTO);
        }

    }
}
