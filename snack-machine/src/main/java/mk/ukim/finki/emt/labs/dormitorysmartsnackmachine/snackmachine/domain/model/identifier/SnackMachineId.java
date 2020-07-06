package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier;


import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.SnackMachine;

import javax.persistence.Embeddable;

/**
 * Value object representing a {@link SnackMachine} ID.
 */
@Embeddable
public class SnackMachineId extends DomainObjectId {
    @JsonCreator
    public SnackMachineId(String uuid) {
        super(uuid);
    }

    public SnackMachineId(){super(DomainObjectId.randomId(SnackMachineId.class).toString());}

}
