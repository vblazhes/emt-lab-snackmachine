package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier;


import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.SnackMachine;

import javax.persistence.Embeddable;

/**
 * Value object representing a {@link SnackMachine} ID.
 */
@Embeddable
public class SnackMachineId extends DomainObjectId {

    private String id;

    @JsonCreator
    protected SnackMachineId(String uuid) {
        super(uuid);
    }

    private SnackMachineId(){super(DomainObjectId.randomId(SnackMachineId.class).toString());}

}
