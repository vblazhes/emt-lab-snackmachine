package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Value object representing an amount of money. The amount is stored as a fixed-point integer where the last two digits
 * represent the decimals.
 */
@Embeddable
@Getter
public class Money implements ValueObject {

    private final int amount;

    protected Money() {
        amount = 0;
    }

    public Money(@NonNull int amount) {
        this.amount = amount;
    }


    public static Money valueOf(int amount) {
        return new Money(amount);
    }

    @NonNull
    public Money add(@NonNull Money other) {
        Objects.requireNonNull(other, "other must not be null");

        return new Money(amount + other.amount);
    }

    @NonNull
    public Money subtract(Money other) {
        Objects.requireNonNull(other, "other must not be null");

        return new Money(amount - other.amount);
    }

    @NonNull
    public Money multiply(int multiplicand) {
        return new Money(amount * multiplicand);
    }

    @NonNull
    public boolean isGreaterOrEqualThan(Money money){
        return this.amount >= money.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.format("%d",amount );
    }
}
