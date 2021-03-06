package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.PurchaseId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackId;
import org.springframework.lang.NonNull;

import java.time.Instant;

@Getter
public class PurchaseForSnackCreated implements DomainEvent {
    @JsonProperty("purchaseId")
    private final PurchaseId purchaseId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonProperty("snackId")
    private final SnackId snackId;

    public PurchaseForSnackCreated(@NonNull PurchaseId purchaseId, @NonNull Instant occurredOn, @NonNull SnackId snackId) {
        this.purchaseId = purchaseId;
        this.occurredOn = occurredOn;
        this.snackId = snackId;
    }

    @Override
    public Instant occurredOn() {
        return occurredOn;
    }
}
