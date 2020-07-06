package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.infra.eventlog;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}
