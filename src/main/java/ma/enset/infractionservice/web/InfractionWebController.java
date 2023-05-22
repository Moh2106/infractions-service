package ma.enset.infractionservice.web;

import lombok.AllArgsConstructor;
import ma.enset.infractionservice.dto.InfractionDTO;
import ma.enset.infractionservice.service.InfractionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class InfractionWebController {
    InfractionServiceImpl infractionService;

    @GetMapping("/infractions/{id}")
    public InfractionDTO findById(@PathVariable Long id){
        return infractionService.findById(id);
    }

    @GetMapping("/infractions")
    public List<InfractionDTO> findAll(){
        return infractionService.findAll();
    }

    @PostMapping("/infractions")
    public InfractionDTO save(@RequestBody InfractionDTO infractionDTO){
        return infractionService.save(infractionDTO);
    }

    @PutMapping("/infractions/{id}")
    public InfractionDTO update(@PathVariable Long id, @RequestBody InfractionDTO infractionDTO){
        return infractionService.update(id, infractionDTO);
    }

    @DeleteMapping("/infractions/{id}")
    public void delete(@PathVariable Long id){
        infractionService.deleteById(id);
    }
}
