package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;

public interface StudentCard {
    StudentCardDto findById(StudentCardId studentCardId);
}
