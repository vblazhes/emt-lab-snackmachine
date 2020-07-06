package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository.SnackMachineRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.validation.Validator;
import java.util.Optional;

@Service
@Transactional
public class SnackMachineService {
    private final SnackMachineRepository snackMachineRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
//    private final Validator validator;
    private final Snack snack;
    private final StudentCard studentCard;

    public SnackMachineService(SnackMachineRepository snackMachineRepository, ApplicationEventPublisher applicationEventPublisher, Snack snack, StudentCard studentCard) {
        this.snackMachineRepository = snackMachineRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.snack = snack;
        this.studentCard = studentCard;
    }

    public Optional<StudentCardDto> findStudentCardById(StudentCardId studentCardId){
        return studentCard.findById(studentCardId);
    }
}
