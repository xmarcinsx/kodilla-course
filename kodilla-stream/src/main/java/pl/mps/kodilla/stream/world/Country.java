package pl.mps.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public class Country {

    private final String name;
    private final BigDecimal peopleQuantity;

    public Country(String name, BigDecimal peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(peopleQuantity, country.peopleQuantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, peopleQuantity);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, peopleQuantity.toString());
    }
}
