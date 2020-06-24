package mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.financial;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.dormitorysmartsnackmachine.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

/**
 * Value object representing an amount of money. The amount is stored as a fixed-point integer where the last two digits
 * represent the decimals.
 */
@Embeddable
@Getter
public class Money implements ValueObject {

    // It could have PaymentMethod enum (Points/Bills) and amount

//    @JsonProperty("amount")
    private final int amount;


    /**
     * Creates a new {@code Money} object.
     *
     * @param amount   fixed-point integer that represents the amount.
     */
    public Money(@NonNull int amount) {
        this.amount = amount;
    }

    /**
     * Creates a new {@code Money} object if both of the parameters are non-{@code null}.
     *
     * @param amount    fixed-point integer that represents the amount.
     * @return a new {@code Money} object or {@code null} if any of the parameters are {@code null}.
     */
    public static Money valueOf(int amount) {
        return new Money(amount);
    }


    /**
     * Returns a new {@code Money} object whose amount is the sum of this amount and {@code augend}'s amount.
     *
     * @param other the {@code Money} object to add to this object.
     * @return {@code this} + {@code augend}
     * @throws IllegalArgumentException if this object and {@code augend} have different currencies.
     */
    @NonNull
    Money add(@NonNull Money other) {
        Objects.requireNonNull(other, "other must not be null");

        return new Money(amount + other.amount);
    }

    /**
     * Returns a new {@code Money} object whose amount is the difference between this amount and {@code subtrahend}'s amount.
     *
     * @param other the {@code Money} object to remove from this object.
     * @return {@code this} - {@code augend}
     * @throws IllegalArgumentException if this object and {@code subtrahend} have different currencies.
     */
    @NonNull
    Money subtract(Money other) {
        Objects.requireNonNull(other, "other must not be null");

        return new Money(amount - other.amount);
    }


    /**
     * Returns a new {@code Money} object whose amount is this amount multiplied by {@code multiplicand}.
     *
     * @param multiplicand the value to multiply the amount by.
     * @return {@code this} * {@code multiplicand}
     */
    @NonNull
    Money multiply(int multiplicand) {
        return new Money(amount * multiplicand);
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
