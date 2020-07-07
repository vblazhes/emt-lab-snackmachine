package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.application;

import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.StudentCard;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.identifier.StudentCardId;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.repository.StudentCardRepository;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.integration.PurchaseCreatedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Objects;
import java.util.Optional;

@Service
public class StudentCardService {
    private StudentCardRepository studentCardRepository;

    public StudentCardService(StudentCardRepository studentCardRepository) {
        this.studentCardRepository = studentCardRepository;
    }

    public Optional<StudentCardDto> findStudentCardById(@NonNull StudentCardId studentCardId){
        Objects.requireNonNull(studentCardId, "productId must be non null");
        return studentCardRepository
                .findById(studentCardId)
                .map(studentCard -> {
                    StudentCardDto studentCardDto = new StudentCardDto();
                    studentCardDto.balance = studentCard.getBalance();
                    studentCardDto.studentCardId = studentCard.id();
                    return studentCardDto;
                });
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onPurchaseCreatedEvent(PurchaseCreatedEvent event){
        StudentCard studentCard = studentCardRepository.findById(event.getStudentCardId()).orElseThrow(RuntimeException::new);
        studentCard.subtractBalance(event.getAmount());
        studentCardRepository.save(studentCard);
    }
}
