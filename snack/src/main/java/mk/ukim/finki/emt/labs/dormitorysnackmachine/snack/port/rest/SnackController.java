package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.port.rest;

import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.Snack;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.identifier.SnackId;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.repository.SnackRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/snacks")
public class SnackController {
    SnackRepository snackRepository;

    public SnackController(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    @GetMapping
    public List<Snack> getAllSnacks(){
        return snackRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Snack> getSnackById(@PathVariable("id") String snackId){
        return snackRepository.findById(new SnackId(snackId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
