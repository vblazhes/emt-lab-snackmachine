package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class SlotId extends DomainObjectId {
    @JsonCreator
    public SlotId(String uuid) {
        super(uuid);
    }

    public SlotId(){super(DomainObjectId.randomId(SlotId.class).toString());}
}
