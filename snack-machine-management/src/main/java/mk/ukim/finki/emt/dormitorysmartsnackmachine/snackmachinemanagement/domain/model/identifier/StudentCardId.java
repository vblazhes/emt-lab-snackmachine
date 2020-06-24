package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

public class StudentCardId extends DomainObjectId {
    @JsonCreator
    protected StudentCardId(String uuid) {
        super(uuid);
    }

    private StudentCardId(){super(DomainObjectId.randomId(StudentCardId.class).toString());}

}
