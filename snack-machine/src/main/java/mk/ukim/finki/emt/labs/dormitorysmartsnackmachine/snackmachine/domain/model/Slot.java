package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SlotId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackId;

import javax.persistence.*;

/**
 * Entity representing a slot in the snack machine management.
 */

@Entity
@Table(name = "slot")
public class Slot extends AbstractAggregateRoot<SlotId> implements ConcurrencySafeDomainObject {

    @Version
    private Long version;

    @Column(name="snack_id",nullable = false)
    private SnackId snackId;

    private int position;

    @Embedded
    @AttributeOverride(name = "amount",column = @Column(name = "price", nullable = false))
    private Money price;

    @ManyToOne
    @JoinColumn(name = "snack_machine_id", referencedColumnName = "uuid")
    private SnackMachine snackMachine;


    protected Slot(){

    }

    public Slot(SlotId slotId, SnackId snackId, int position, Money price) {
        super(slotId);
        this.snackId = snackId;
        this.position = position;
        this.price = price;
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

    @Override
    public Long version() {
        return version;
    }
}
