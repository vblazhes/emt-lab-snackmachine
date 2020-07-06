package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.StudentCard;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.identifier.StudentCardId;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.repository.StudentCardRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
public class DataGenerator {
    private final StudentCardRepository studentCardRepository;

    public DataGenerator(StudentCardRepository studentCardRepository) {
        this.studentCardRepository = studentCardRepository;
    }

    @PostConstruct
    @Transactional
    public void generateSnackData(){
        if(studentCardRepository.findAll().size() == 0){
            var studentCards = new ArrayList<StudentCard>();

            for(int i = 1; i <= 10; ++i){
                studentCards.add(createStudentCard(new StudentCardId(i + ""), "Name" + i, "Surname" + i, new Money(1000)));
            }

            studentCardRepository.saveAll(studentCards);
        }
    }

    private StudentCard createStudentCard(StudentCardId snackId, String name, String surname, Money balance){
        var studentCard = new StudentCard(snackId, name, surname, balance);
        return studentCard;
    }
}
