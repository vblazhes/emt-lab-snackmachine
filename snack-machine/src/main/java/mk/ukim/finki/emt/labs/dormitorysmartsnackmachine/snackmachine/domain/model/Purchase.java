package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.PurchaseId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackMachineId;
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
    private Money price;

    @Column(name = "occurred_on", nullable = false)
    private Instant occurredOn;

    @Embedded
    @AttributeOverride(name = "uuid", column = @Column(name="student_card_id",nullable = false))
    private StudentCardId studentCardId;

    @Embedded
    @AttributeOverride(name = "uuid", column = @Column(name="snack_id",nullable = false))
    private SnackId snackId;

    @Embedded
    @AttributeOverride(name = "uuid",column = @Column(name = "snack_machine_id", nullable = false))
    private SnackMachineId snackMachineId;


    public Purchase(){

    }

    public Purchase(Instant purchasedOn, Money price, StudentCardId studentCardId, SnackId snackId, SnackMachineId snackMachineId) {
        super(DomainObjectId.randomId(PurchaseId.class));
        this.price = price;
        this.occurredOn = purchasedOn;
        this.studentCardId = studentCardId;
        this.snackId = snackId;
        this.snackMachineId = snackMachineId;
    }

    public Money getPrice() {
        return price;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    public StudentCardId getStudentCardId() {
        return studentCardId;
    }

    public SnackId getSnackId() {
        return snackId;
    }

    @Override
    public Long version() {
        return version;
    }
}
