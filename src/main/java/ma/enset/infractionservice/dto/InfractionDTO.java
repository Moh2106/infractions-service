package ma.enset.infractionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfractionDTO {
    private Long id;
    private String date;
    private Integer numero_radar;
    private String matricule_vehicule;
    private Double vitesse_maximale;
    private Double montant_infraction;
}
