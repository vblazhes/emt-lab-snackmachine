package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Slot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SlotId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, SlotId> {
    Slot findByPosition(int position);
}
