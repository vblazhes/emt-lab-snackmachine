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
 * Entity representing a purchase in the snack machine.
 */

@Entity
@Table(name = "purchase")
public class Purchase extends AbstractEntity<PurchaseId> implements ConcurrencySafeDomainObject {

    @Version
    private Long version;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "amount"))
    private Money amount;

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

    public Purchase(Instant purchasedOn, Money amount, StudentCardId studentCardId, SnackId snackId, SnackMachineId snackMachineId) {
        super(DomainObjectId.randomId(PurchaseId.class));
        this.amount = amount;
        this.occurredOn = purchasedOn;
        this.studentCardId = studentCardId;
        this.snackId = snackId;
        this.snackMachineId = snackMachineId;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(Instant occurredOn) {
        this.occurredOn = occurredOn;
    }

    public StudentCardId getStudentCardId() {
        return studentCardId;
    }

    public void setStudentCardId(StudentCardId studentCardId) {
        this.studentCardId = studentCardId;
    }

    public SnackId getSnackId() {
        return snackId;
    }

    public void setSnackId(SnackId snackId) {
        this.snackId = snackId;
    }

    @Override
    public Long version() {
        return version;
    }

    public SnackMachineId getSnackMachineId() {
        return snackMachineId;
    }

    public void setSnackMachineId(SnackMachineId snackMachineId) {
        this.snackMachineId = snackMachineId;
    }
}
