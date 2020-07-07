package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.event;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;

public class PurchaseForStudentCardCreated implements DomainEvent {
    @Override
    public Instant occurredOn() {
        return null;
    }
}
