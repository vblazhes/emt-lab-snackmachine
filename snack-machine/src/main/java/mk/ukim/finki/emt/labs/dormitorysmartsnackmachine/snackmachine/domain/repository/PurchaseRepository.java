package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Purchase;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.PurchaseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, PurchaseId> {
}
