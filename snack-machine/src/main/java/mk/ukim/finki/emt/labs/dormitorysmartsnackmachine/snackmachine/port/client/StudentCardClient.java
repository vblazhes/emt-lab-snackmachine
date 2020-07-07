package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.port.client;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.StudentCard;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class StudentCardClient implements StudentCard{
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCardClient.class);

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public StudentCardClient(
            @Value("${app.student-card.url}") String serverUrl,
            @Value("${app.student-card.connect-timeout-ms}") int connectTimeout,
            @Value("${app.student-card.read-timeout-ms}") int readTimeout
    ) {

        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();

        var requestFactory = new SimpleClientHttpRequestFactory();
        // Never ever do a remote call without a finite timeout!
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }


    public Optional<StudentCardDto> findById(StudentCardId id){
        try{
            return restTemplate.exchange(
                    uri().path("/api/studentcards/" + id.getUuid()).build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Optional<StudentCardDto>>() {
                    }).getBody();
        } catch(Exception ex){
            LOGGER.error("Error retrieving product by id", ex);
            return Optional.empty();
        }
    }

//    @Override
//    public boolean canPurchaseBeMade(StudentCardId studentCardId) {
//        try{
//            return restTemplate.exchange(
//                    uri().path("/api/studentcards/purchase/" + studentCardId.getUuid()).build().toUri(),
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<Boolean>() {
//                    }).getBody();
//        } catch(Exception ex){
//            LOGGER.error("Error: ", ex);
//            return false;
//        }
//    }
}
