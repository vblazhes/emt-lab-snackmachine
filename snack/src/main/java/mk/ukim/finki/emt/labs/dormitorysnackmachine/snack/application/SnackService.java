package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.application;

import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.Snack;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.identifier.SnackId;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.repository.SnackRepository;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.integration.PurchaseCreatedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SnackService {
    private final SnackRepository snackRepository;

    public SnackService(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    @NonNull
    public List<Snack> findAll(){return snackRepository.findAll();}

    @NonNull
    public Optional<Snack> findById(@NonNull SnackId snackId){
        Objects.requireNonNull(snackId, "snackId must be non null");
        return snackRepository.findById(snackId);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onPurchaseCreatedEvent(PurchaseCreatedEvent event){
        Snack snack = snackRepository.findById(event.getSnackId()).orElseThrow(RuntimeException::new);
        snack.subtractQuantityPerOne();
        snackRepository.save(snack);
    }
}
