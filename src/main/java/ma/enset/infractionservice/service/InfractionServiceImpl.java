package ma.enset.infractionservice.service;

import lombok.AllArgsConstructor;
import ma.enset.infractionservice.dto.InfractionDTO;
import ma.enset.infractionservice.entities.Infraction;
import ma.enset.infractionservice.mapper.InfractionMapper;
import ma.enset.infractionservice.repositories.InfractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InfractionServiceImpl implements InfractionService<InfractionDTO>{

    InfractionRepository infractionRepository;
    InfractionMapper infractionMapper;

    @Override
    public InfractionDTO findById(Long id) {
        Infraction infraction = infractionRepository.findById(id).get();
        return infractionMapper.from(infraction);
    }

    @Override
    public List<InfractionDTO> findAll() {

        return infractionRepository.findAll().stream().map(infractionMapper::from).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        infractionRepository.deleteById(id);
    }

    @Override
    public InfractionDTO update(Long id, InfractionDTO infractionDTO) {
        Infraction infraction = infractionRepository.findById(id).get();

        if (infractionDTO.getDate() != null) infraction.setDate(infractionDTO.getDate());
        if (infractionDTO.getMontant_infraction() != null) infraction.setMontant_infraction(infractionDTO.getMontant_infraction());
        if (infractionDTO.getMatricule_vehicule() != null) infraction.setMatricule_vehicule(infractionDTO.getMatricule_vehicule());
        if (infractionDTO.getNumero_radar() != null) infraction.setNumero_radar(infractionDTO.getNumero_radar());
        if (infractionDTO.getVitesse_maximale() != null) infraction.setVitesse_maximale(infractionDTO.getVitesse_maximale());

        InfractionDTO infractionDTO1 = infractionMapper.from(infraction);
        save(infractionDTO1);

        return infractionDTO1;
    }

    @Override
    public InfractionDTO save(InfractionDTO infractionDTO) {
        Infraction infraction = infractionMapper.from(infractionDTO);
        Infraction infraction1 = infractionRepository.save(infraction);
        return infractionMapper.from(infraction1);
    }
}
