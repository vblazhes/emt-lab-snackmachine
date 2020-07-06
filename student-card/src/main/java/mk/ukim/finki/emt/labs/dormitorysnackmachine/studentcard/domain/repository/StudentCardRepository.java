package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.repository;

import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.StudentCard;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.identifier.StudentCardId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardRepository extends JpaRepository<StudentCard, StudentCardId> {
}
