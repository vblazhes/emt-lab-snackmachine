package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto;

import com.sun.istack.NotNull;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;

public class PurchaseDto {
    @NotNull
    public String studentCardId;
    @NotNull
    public int slotPosition;
}
