package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Purchase;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Slot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.SnackMachine;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackMachineId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.Optional;

public interface SnackMachineRepository extends JpaRepository<SnackMachine, SnackMachineId> {
    @Query(value = "select * from slot s " +
            "where s.position = :position", nativeQuery = true)
    Slot getSlotByPosition(@Param("position") int position);
//
//
    @Query(value = "select * from purchase" +
            "where p.occurred_on = :occurredOn", nativeQuery = true)
    Purchase getPurchaseByOccurredOn(@Param("occurredOn") Instant occurredOn);
}
