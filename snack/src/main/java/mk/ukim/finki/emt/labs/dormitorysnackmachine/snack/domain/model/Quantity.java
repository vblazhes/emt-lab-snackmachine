package mk.ukim.finki.emt.labs.dormitorysnackmachine.snack.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Quantity implements ValueObject {

    @Column(name="quantity", nullable = false)
    private int quantity;

    public Quantity() {
        quantity = 0;
    }

    public Quantity(int quantity){
        this.quantity = quantity;
    }

    public Quantity subtractQuantityPerOne(){
        return new Quantity(this.quantity - 1);
    }

    public Quantity addQuantity(int quantity){
        return new Quantity(this.quantity + quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}
