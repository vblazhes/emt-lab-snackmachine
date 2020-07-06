package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class StudentCardId extends DomainObjectId {
    @JsonCreator
    public StudentCardId(String uuid) {
        super(uuid);
    }

    public StudentCardId(){super(DomainObjectId.randomId(StudentCardId.class).toString());}

}
