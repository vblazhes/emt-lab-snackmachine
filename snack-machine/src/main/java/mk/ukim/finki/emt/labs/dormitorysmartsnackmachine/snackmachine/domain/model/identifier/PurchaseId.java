package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

public class PurchaseId extends DomainObjectId {

    @JsonCreator
    protected PurchaseId(String uuid) {
        super(uuid);
    }

    private PurchaseId(){super(DomainObjectId.randomId(PurchaseId.class).toString());}
}
