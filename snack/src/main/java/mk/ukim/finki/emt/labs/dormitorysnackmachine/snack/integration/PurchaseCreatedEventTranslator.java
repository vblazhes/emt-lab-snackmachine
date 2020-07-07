package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseCreatedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    public PurchaseCreatedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.event.PurchaseForSnackCreated");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        var purchaseForSnackCreated = remoteEvent.toDomainEvent(objectMapper, PurchaseCreatedEvent.class);
        return Optional.of(new PurchaseCreatedEvent(purchaseForSnackCreated.getPurchaseId(), purchaseForSnackCreated.getOccurredOn(), purchaseForSnackCreated.getSnackId()));
    }
}
