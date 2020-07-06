package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.identifier;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

public class SnackId extends DomainObjectId {
    public SnackId(String uuid) {
        super(uuid);
    }

    private SnackId(){
        super(DomainObjectId.randomId(SnackId.class).toString());
    }
}
