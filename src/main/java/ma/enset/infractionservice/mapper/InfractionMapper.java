package ma.enset.infractionservice.mapper;

import ma.enset.infractionservice.dto.InfractionDTO;
import ma.enset.infractionservice.entities.Infraction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class InfractionMapper {
    //ModelMapper modelMapper = new ModelMapper();
    ModelMapper modelMapper = new ModelMapper();

    public Infraction from(InfractionDTO infractionDTO){
        return modelMapper.map(infractionDTO, Infraction.class);
    }

    public InfractionDTO from(Infraction infraction){
        return modelMapper.map(infraction, InfractionDTO.class);
    }
}
