package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

public class PurchaseId extends DomainObjectId {

    public PurchaseId(String uuid) {
        super(uuid);
    }

    public PurchaseId(){super(DomainObjectId.randomId(PurchaseId.class).toString());}
}
