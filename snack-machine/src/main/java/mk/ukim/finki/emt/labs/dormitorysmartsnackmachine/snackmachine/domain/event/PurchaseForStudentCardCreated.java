package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.PurchaseId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;

import java.time.Instant;

@Getter
public class PurchaseForStudentCardCreated implements DomainEvent {
    @JsonProperty("purchaseId")
    private final PurchaseId purchaseId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonProperty("studentCardId")
    private final StudentCardId studentCardId;

    @JsonProperty("studentCard")
    private final Money amount;

    public PurchaseForStudentCardCreated(PurchaseId purchaseId, Instant occurredOn, StudentCardId studentCardId, Money amount) {
        this.studentCardId = studentCardId;
        this.purchaseId = purchaseId;
        this.occurredOn = occurredOn;
        this.amount = amount;
    }

    @Override
    public Instant occurredOn() {
        return occurredOn;
    }
}
