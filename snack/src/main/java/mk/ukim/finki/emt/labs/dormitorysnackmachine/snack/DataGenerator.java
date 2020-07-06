package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack;

import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.Snack;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.identifier.SnackId;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.repository.SnackRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
public class DataGenerator {
    private final SnackRepository snackRepository;

    public DataGenerator(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    @PostConstruct
    @Transactional
    public void generateSnackData(){
        if(snackRepository.findAll().size() == 0){
            var snacks = new ArrayList<Snack>();
            snacks.add(createSnack(new SnackId("1"), "Chocolate", 10));
            snacks.add(createSnack(new SnackId("2"), "Water", 10));
            snacks.add(createSnack(new SnackId("3"), "Fanta", 10));
            snacks.add(createSnack(new SnackId("4"), "Coca-Cola", 10));
            snacks.add(createSnack(new SnackId("5"), "Sprite", 10));

            snackRepository.saveAll(snacks);
        }
    }

    private Snack createSnack(SnackId snackId, String name, int quantity){
        var snack = new Snack(snackId, name, quantity);
        return snack;
    }
}
