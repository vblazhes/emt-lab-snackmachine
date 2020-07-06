package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.SnackMachine;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackMachineId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackMachineRepository extends JpaRepository<SnackMachine, SnackMachineId> {
}
