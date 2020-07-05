package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model;

import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier.SlotId;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier.SnackId;

import javax.persistence.*;

/**
 * Entity representing a slot in the snack machine management.
 */

@Entity
@Table(name = "slots")
public class Slot extends AbstractAggregateRoot<SlotId> implements ConcurrencySafeDomainObject {

    @Version
    private Long version;

    @Column(name="snack_id",nullable = false)
    private SnackId snackId;

    private int position;

    @Embedded
    @AttributeOverride(name = "amount",column = @Column(name = "price", nullable = false))
    private Money price;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "snack_machine_id")
    private SnackMachine snackMachine;


    private Slot(){

    }

    public Slot(AbstractAggregateRoot<SlotId> source, SnackId snackId, int position, Money price) {
        super(DomainObjectId.randomId(SlotId.class));
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
