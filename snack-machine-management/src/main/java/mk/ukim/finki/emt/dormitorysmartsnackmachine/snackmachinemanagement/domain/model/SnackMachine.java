package mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.ConcurrencySafeDomainObject;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.DeletableDomainObject;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.snackmachinemanagement.domain.model.identifier.SnackMachineId;

import javax.persistence.*;
import java.util.List;


/**
 * Aggregate root representing a snack machine in the snack machine management.
 */

@Entity
@Table(name = "snack-machine")
public class SnackMachine extends AbstractAggregateRoot<SnackMachineId> implements DeletableDomainObject,
        ConcurrencySafeDomainObject {

    @Version
    private Long version;

    //Can be changed to Points
    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "amount"))
    @Column(name = "totalBudget", nullable = false)
    private Money totalBudget;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Slot> slots;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Purchase> purchases;

//    @SuppressWarnings("unused") // Used by JPA only
    private SnackMachine(){
        this.totalBudget = new Money(0);
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

    public Money getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Money totalBudget) {
        this.totalBudget = totalBudget;
    }
}
