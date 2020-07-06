package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.repository;

import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.Snack;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.identifier.SnackId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackRepository extends JpaRepository<Snack, SnackId> {
}
