package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DeletableDomainObject;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackMachineId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Aggregate root representing a snack machine in the snack machine management.
 */

@Entity
@Table(name = "snack_machine")
public class SnackMachine extends AbstractAggregateRoot<SnackMachineId> implements DeletableDomainObject,
        ConcurrencySafeDomainObject {

    @Version
    private Long version;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "profit"))
    private Money profit;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

//    @OneToMany(
////            mappedBy = "snackMachine",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private Set<Slot> slots = new HashSet<>();
//
//    @OneToMany(
////            mappedBy = "snackMachine",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private Set<Purchase> purchases = new HashSet<>();

    @SuppressWarnings("unused") // Used by JPA only
    public SnackMachine(){
        super(DomainObjectId.randomId(SnackMachineId.class));
    }

    public SnackMachine(SnackMachineId snackMachineId){
        super(snackMachineId);
        this.profit = new Money(0);
    }

    public SnackMachine(Set<Slot> slots) {
        super(DomainObjectId.randomId(SnackMachineId.class));
        this.profit = new Money(0);
    }

//    public void setSlots(Set<Slot> slots) {
//        this.slots = slots;
//    }
//
//    public void addPurchase(Purchase newPurchase){
//        this.purchases.add(newPurchase);
//    }

    @Override
    public Long version() {
        return version;
    }

    @Override
    @JsonProperty("isDeleted")
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void delete() {
        this.deleted = true;
    }

    public Money getProfit() {
        return profit;
    }
//
    public void addProfit(Money amount) {
        profit = profit.add(amount);
    }
}
