package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.infra.eventlog;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}
