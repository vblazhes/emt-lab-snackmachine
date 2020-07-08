package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PurchaseNumber implements ValueObject {
    @Column(name = "number_of_purchases", nullable = false)
    private int numberOfPurchases;

    @SuppressWarnings("unused") // Used by JPA only.
    public PurchaseNumber() {
    }

    public PurchaseNumber(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public PurchaseNumber addOne(){
        return new PurchaseNumber((this.numberOfPurchases + 1)%11);
    }
}
