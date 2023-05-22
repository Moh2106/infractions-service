package ma.enset.infractionservice.web;

import lombok.AllArgsConstructor;
import ma.enset.infractionservice.dto.InfractionDTO;
import ma.enset.infractionservice.service.InfractionServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class InfractionGraphQLController {
    private InfractionServiceImpl infractionService;

    @QueryMapping
    public List<InfractionDTO> listInfractions(){
        return infractionService.findAll();
    }

    @QueryMapping
    public InfractionDTO getInfractionById(@Argument Long id){
        return infractionService.findById(id);
    }

    @MutationMapping
    public InfractionDTO saveInfraction(InfractionDTO infractionDTO){
        return infractionService.save(infractionDTO);
    }

    @MutationMapping
    public InfractionDTO updateInfraction(Long id,InfractionDTO infractionDTO){
        return infractionService.update(id, infractionDTO);
    }

    @MutationMapping
    public void deleteInfraction(Long id){
        infractionService.deleteById(id);
    }
}
