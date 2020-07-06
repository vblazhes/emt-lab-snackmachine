package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DeletableDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.identifier.StudentCardId;

import javax.persistence.*;

@Entity
@Table(name = "student_card")
public class StudentCard extends AbstractAggregateRoot<StudentCardId> implements DeletableDomainObject, ConcurrencySafeDomainObject {
    @Version
    private Long version;

    private String name;

    private String surname;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "balance"))
    private Money balance;

    private boolean deleted = false;


    public StudentCard(){

    }

    public StudentCard(StudentCardId studentCardId, String name, String surname, Money balance){
        super(studentCardId);
        this.name = name;
        this.surname = surname;
        this.balance = balance;
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
}
