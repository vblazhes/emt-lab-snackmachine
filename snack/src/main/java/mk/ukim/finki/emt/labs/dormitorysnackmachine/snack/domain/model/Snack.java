package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.AbstractAggregateRoot;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model.identifier.SnackId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "snack")
public class Snack extends AbstractAggregateRoot<SnackId> {

    @Column(name = "name", nullable = false)
    private String name;

    private int quantity;

    public Snack(){

    }

    public Snack(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public Snack(SnackId snackId, String name, int quantity){
        super(snackId);
        this.name = name;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void subtractQuantityPerOne(){
        this.quantity--;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }
}
