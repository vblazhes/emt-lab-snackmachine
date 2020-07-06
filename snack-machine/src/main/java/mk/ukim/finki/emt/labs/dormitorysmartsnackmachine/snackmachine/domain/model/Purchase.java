package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.PurchaseId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SlotId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;

import javax.persistence.*;
import java.time.Instant;

/**
 * Entity representing a purchase in the snack machine management.
 */

@Entity
@Table(name = "purchase")
public class Purchase extends AbstractEntity<PurchaseId> implements ConcurrencySafeDomainObject {

    @Version
    private Long version;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "amount"))
    private Money amount;

    @Column(name = "purchased_on", nullable = false)
    private Instant purchasedOn;

    @Embedded
    @AttributeOverride(name = "uuid", column = @Column(name="student_card_id",nullable = false))
    private StudentCardId studentCardId;

    @Embedded
    @AttributeOverride(name = "uuid", column = @Column(name="slot_id",nullable = false))
    private SlotId slotId;

//    @ManyToOne(
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(
//            name="snack_machine_id"
//    )
//    private SnackMachine snackMachine;


    public Purchase(){

    }

    public Purchase(PurchaseId id, Money amount, Instant purchasedOn, StudentCardId studentCardId, SlotId slotId) {
        super(DomainObjectId.randomId(PurchaseId.class));
        this.amount = amount;
        this.purchasedOn = purchasedOn;
        this.studentCardId = studentCardId;
        this.slotId = slotId;
    }

    public Money getAmount() {
        return amount;
    }

    public Instant getPurchasedOn() {
        return purchasedOn;
    }

    public StudentCardId getStudentCardId() {
        return studentCardId;
    }

    public SlotId getSlotId() {
        return slotId;
    }

    @Override
    public Long version() {
        return version;
    }
}
