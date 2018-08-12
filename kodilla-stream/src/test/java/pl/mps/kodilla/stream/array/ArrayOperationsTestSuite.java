package pl.mps.kodilla.stream.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {

        int[] numbers0 = new int[1];
        int[] numbers1 = {1};
        int[] numbers2 = {1, 2, 3};

        assertEquals(ArrayOperations.getAverage(null), 0.0, 0.0);
        assertEquals(ArrayOperations.getAverage(numbers0), 0.0, 0.0);
        assertEquals(ArrayOperations.getAverage(numbers1), 1.0, 0.0);
        assertEquals(ArrayOperations.getAverage(numbers2), 2.0, 0.0);
    }

}