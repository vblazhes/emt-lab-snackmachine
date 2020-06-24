package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier;

import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

public class StudentCardId extends DomainObjectId {
    protected StudentCardId(String uuid) {
        super(uuid);
    }

    private StudentCardId(){super(DomainObjectId.randomId(StudentCardId.class).toString());}


}
