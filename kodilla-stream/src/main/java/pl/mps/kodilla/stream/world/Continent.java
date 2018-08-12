package pl.mps.kodilla.stream.world;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Continent {

    private final String name;
    private final List<Country> countries;

    public Continent(String name) {
        this.name = name;
        countries = new LinkedList<>();
    }

    public void add(Country country) {
        countries.add(country);
    }

    public List<Country> getCountries() {
        return countries;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(name, continent.name) &&
                Objects.equals(countries, continent.countries);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, countries);
    }

    @Override
    public String toString() {
        return name + "[" + countries.stream().map(Country::toString).collect(Collectors.joining(",")) + "]";
    }
}
