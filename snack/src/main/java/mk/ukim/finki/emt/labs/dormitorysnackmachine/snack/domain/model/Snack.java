package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.identifier.SnackId;

import javax.persistence.*;

@Entity
@Table(name = "snack")
public class Snack extends AbstractAggregateRoot<SnackId> {

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Quantity quantity;

    public Snack(){

    }

    public Snack(String name, int quantity){
        this.name = name;
        this.quantity = new Quantity(quantity);
    }

    public Snack(SnackId snackId, String name, int quantity){
        super(snackId);
        this.name = name;
        this.quantity = new Quantity(quantity);
    }


    public String getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void subtractQuantityPerOne(){
        this.quantity = this.quantity.subtractQuantityPerOne();
    }

    public void addQuantity(int qnt){
        this.quantity = this.quantity.addQuantity(qnt);
    }
}
