package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class PurchaseId extends DomainObjectId {

    public PurchaseId(@NonNull String uuid) {
        super(uuid);
    }

    public PurchaseId(){super(DomainObjectId.randomId(PurchaseId.class).toString());}
}
