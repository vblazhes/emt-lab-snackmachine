package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.repository;

import mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.SnackMachine;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier.SnackMachineId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackMachineRepository extends JpaRepository<SnackMachine, SnackMachineId> {
}
