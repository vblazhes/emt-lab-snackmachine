package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.SharedConfiguration;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.infra.eventlog.RemoteEventLogService;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.port.client.RemoteEventLogServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@Import(SharedConfiguration.class)
public class SnackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnackApplication.class, args);
    }

    @Bean
    public RemoteEventLogService snackMachineEvents(
            @Value("${app.snack-machine.url}") String serverUrl,
            @Value("${app.snack-machine.connect-timeout-ms}") int connectTimeout,
            @Value("${app.snack-machine.read-timeout-ms}") int readTimeout) {
        return new RemoteEventLogServiceClient(serverUrl, connectTimeout, readTimeout);
    }
}
