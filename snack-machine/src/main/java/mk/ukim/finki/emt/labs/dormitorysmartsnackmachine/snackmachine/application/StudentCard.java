package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;

import java.util.Optional;

public interface StudentCard {
    Optional<StudentCardDto> findById(StudentCardId studentCardId);
//    boolean canPurchaseBeMade(StudentCardId studentCardId);
}
