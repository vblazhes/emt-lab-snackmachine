package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.application.dto;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.identifier.StudentCardId;

public class StudentCardDto {
    public StudentCardId studentCardId;
    public Money balance;
}
