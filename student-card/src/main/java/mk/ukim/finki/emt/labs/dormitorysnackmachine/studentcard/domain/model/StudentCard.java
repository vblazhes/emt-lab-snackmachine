package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DeletableDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.identifier.StudentCardId;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_card")
public class StudentCard extends AbstractAggregateRoot<StudentCardId> implements DeletableDomainObject, ConcurrencySafeDomainObject {
    @Version
    private Long version;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false)),
            @AttributeOverride(name = "surname", column = @Column(name = "surname", nullable = false)),
    })
    private FullName fullName;

    @Embedded
    @AttributeOverride(name = "numberOfPurchases", column = @Column(name = "number_of_purchases", nullable = false))
    private PurchaseNumber purchaseNumber;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "balance"))
    private Money balance;

    private boolean deleted = false;


    public StudentCard(){

    }

    public StudentCard(StudentCardId studentCardId, String name, String surname, Money balance){
        super(studentCardId);
        this.fullName = new FullName(name, surname);
        this.balance = Objects.requireNonNull(balance, "balance cannot be null");
        purchaseNumber = new PurchaseNumber(0);
    }

    @Override
    public Long version() {
        return null;
    }

    @Override
    public boolean isDeleted() {
        return false;
    }

    @Override
    public void delete() {

    }

    public Money getBalance() {
        return balance;
    }

    public void addBalance(Money money){
        balance.add(money);
    }

    public void subtractBalance(Money money){
        if(purchaseNumber.getNumberOfPurchases() != 10){
            balance = balance.subtract(money);
        }
    }

    public void addPurchasesPerOne(){
        purchaseNumber = purchaseNumber.addOne();
    }

    public PurchaseNumber getPurchaseNumber() {
        return purchaseNumber;
    }
}
