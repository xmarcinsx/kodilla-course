package pl.mps.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        // Given
        World world = prepareTestData();
        // Then
        Assert.assertEquals(world.getPeopleQuantity(), new BigDecimal("4385774290"));
    }

    private World prepareTestData() {
        World world = new World();

        Continent europe = new Continent("Europe");
        europe.add(new Country("Poland", new BigDecimal("38536869")));
        europe.add(new Country("Germany", new BigDecimal("82422299")));
        europe.add(new Country("England", new BigDecimal("606091539")));
        europe.add(new Country("Italy", new BigDecimal("58133509")));
        europe.add(new Country("Spain", new BigDecimal("40397842")));
        world.add(europe);

        Continent northAmerica = new Continent("North America");
        northAmerica.add(new Country("USA", new BigDecimal("298444215")));
        northAmerica.add(new Country("Canada", new BigDecimal("33098932")));
        northAmerica.add(new Country("Mexico", new BigDecimal("107449525")));
        world.add(northAmerica);

        Continent asia = new Continent("Asia");
        asia.add(new Country("China", new BigDecimal("1314480000")));
        asia.add(new Country("India", new BigDecimal("1095351995")));
        asia.add(new Country("Indonesia", new BigDecimal("245452739")));
        asia.add(new Country("Russia", new BigDecimal("142893540")));
        world.add(asia);

        Continent southAmerica = new Continent("South America");
        southAmerica.add(new Country("Brasilia", new BigDecimal("188078227")));
        southAmerica.add(new Country("Argentin", new BigDecimal("39921833")));
        southAmerica.add(new Country("Chile", new BigDecimal("16134219")));
        world.add(southAmerica);

        Continent africa = new Continent("Africa");
        africa.add(new Country("Egipt", new BigDecimal("78887007")));
        world.add(africa);

        return world;
    }

}