package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FullName implements ValueObject {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @SuppressWarnings("unused") // Used by JPA only.
    protected FullName() {
    }

    public FullName(@NonNull String name, @NonNull String surname){
        this.name = name;
        this.surname = surname;
    }

    @NonNull
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FullName)) return false;
        FullName fullName = (FullName) o;
        return getName().equals(fullName.getName()) &&
                getSurname().equals(fullName.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
