package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.infra.eventlog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedRemoteEventRepository extends JpaRepository<ProcessedRemoteEvent, String> {
}
