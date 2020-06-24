package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DeletableDomainObject;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier.SnackMachineId;

import javax.persistence.*;
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

    //Can be changed to Points
    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "total_budget"))
    private Money totalBudget;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Slot> slots;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Purchase> purchases;

//    @SuppressWarnings("unused") // Used by JPA only
    private SnackMachine(){

    }

    public SnackMachine(Money totalBudget, Set<Slot> slots, Set<Purchase> purchases) {
        super(DomainObjectId.randomId(SnackMachineId.class));
//        this.totalBudget = totalBudget;
        this.slots = slots;
        this.purchases = purchases;
    }

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

//    public Money getTotalBudget() {
//        return totalBudget;
//    }
//
//    public void setTotalBudget(Money totalBudget) {
//        this.totalBudget = totalBudget;
//    }
}
