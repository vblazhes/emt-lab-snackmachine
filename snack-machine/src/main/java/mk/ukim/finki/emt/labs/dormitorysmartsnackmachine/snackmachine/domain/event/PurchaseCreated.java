package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.PurchaseId;
import org.springframework.lang.NonNull;

import java.time.Instant;

public class PurchaseCreated implements DomainEvent {
    @JsonProperty("purchaseId")
    private final PurchaseId purchaseId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    public PurchaseCreated(@NonNull PurchaseId purchaseId,@NonNull Instant occurredOn) {
        this.purchaseId = purchaseId;
        this.occurredOn = occurredOn;
    }

    @Override
    public Instant occurredOn() {
        return occurredOn;
    }
}
