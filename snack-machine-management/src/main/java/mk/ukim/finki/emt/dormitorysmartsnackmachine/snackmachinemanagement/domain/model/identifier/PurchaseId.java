package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

public class PurchaseId extends DomainObjectId {

    @JsonCreator
    protected PurchaseId(String uuid) {
        super(uuid);
    }

    private PurchaseId(){super(DomainObjectId.randomId(PurchaseId.class).toString());}
}
