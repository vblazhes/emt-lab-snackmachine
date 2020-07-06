package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.infra.eventlog;


public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}
