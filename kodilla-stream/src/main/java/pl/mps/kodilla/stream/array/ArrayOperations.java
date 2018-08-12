package pl.mps.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        if (numbers == null) {
            return 0;
        }
        print(numbers);
        return avg(numbers);
    }

    static double avg(int[] numbers) {
        OptionalDouble average = IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }

    static void print(int[] numbers) {
        System.out.print("Numbers: ");
        IntStream.range(0, numbers.length)
                .forEach(i -> System.out.print(String.format("%s ", numbers[i])));
        System.out.println();
    }
}
