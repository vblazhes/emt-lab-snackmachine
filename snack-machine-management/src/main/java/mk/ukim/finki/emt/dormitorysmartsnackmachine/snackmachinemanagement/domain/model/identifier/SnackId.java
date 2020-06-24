package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier;

import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

public class SnackId extends DomainObjectId {
    protected SnackId(String uuid) {
        super(uuid);
    }

    private SnackId(){super(DomainObjectId.randomId(SnackId.class).toString());}

}
