package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class SnackId extends DomainObjectId {
    public SnackId(String uuid) {
        super(uuid);
    }

    public SnackId(){super(DomainObjectId.randomId(SnackId.class).toString());}

}
