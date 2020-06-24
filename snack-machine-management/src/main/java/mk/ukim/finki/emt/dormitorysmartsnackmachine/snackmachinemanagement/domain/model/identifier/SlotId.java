package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

public class SlotId extends DomainObjectId {
    @JsonCreator
    protected SlotId(String uuid) {
        super(uuid);
    }

    private SlotId(){super(DomainObjectId.randomId(SlotId.class).toString());}
}
