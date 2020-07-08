package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SlotId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackMachineId;

import javax.persistence.*;

/**
 * Entity representing a slot in the snack machine.
 */

@Entity
@Table(name = "slot")
public class Slot extends AbstractAggregateRoot<SlotId> implements ConcurrencySafeDomainObject {

    @Version
    private Long version;

    @Embedded
    @AttributeOverride(name = "uuid", column = @Column(name="snack_id",nullable = false))
    private SnackId snackId;

    private int position;

    @Embedded
    @AttributeOverride(name = "amount",column = @Column(name = "price", nullable = false))
    private Money price;

    @Embedded
    @AttributeOverride(name = "uuid",column = @Column(name = "snack_machine_id", nullable = false))
    private SnackMachineId snackMachineId;


    protected Slot(){

    }

    public Slot(SlotId slotId, SnackId snackId, int position, Money price, SnackMachineId snackMachineId) {
        super(slotId);
        this.snackId = snackId;
        this.position = position;
        this.price = price;
        this.snackMachineId = snackMachineId;
    }

    public SnackId getSnackId() {
        return snackId;
    }

    public int getPosition() {
        return position;
    }

    public Money getPrice() {
        return price;
    }

    public Long getVersion() {
        return version;
    }

    public SnackMachineId getSnackMachineId() {
        return snackMachineId;
    }

    public void setSnackMachineId(SnackMachineId snackMachineId) {
        this.snackMachineId = snackMachineId;
    }

    @Override
    public Long version() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setSnackId(SnackId snackId) {
        this.snackId = snackId;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
