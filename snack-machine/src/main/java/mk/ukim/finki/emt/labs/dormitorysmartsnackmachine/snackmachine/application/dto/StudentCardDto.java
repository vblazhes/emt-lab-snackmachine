package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;

public class StudentCardDto {
    public StudentCardId studentCardId;
    public Money balance;
}
