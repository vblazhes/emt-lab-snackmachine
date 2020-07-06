package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.identifier;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;

public class StudentCardId extends DomainObjectId {

    public StudentCardId(String uuid) {
        super(uuid);
    }

    private StudentCardId(){super(DomainObjectId.randomId(StudentCardId.class).toString());}
}
