package pl.mps.kodilla.stream.beautifier;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PoemBeautifier {

    public String beautify(String text, PoemDecorator decorator) {
        return decorator.decorate(text);
    }

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println(poemBeautifier.beautify("Ala ma kota", t -> String.format("*** %s ****", t)));
        System.out.println(poemBeautifier.beautify("Ala ma kota", t -> t != null ? t.toUpperCase() : null));
        System.out.println(poemBeautifier.beautify("Ala ma kota", t -> t != null ? asteriskBeautify(t) : null));
    }

    private static String asteriskBeautify(String t) {
        return Arrays.stream(t.split("")).map(x -> String.format("*%s*", x)).collect(Collectors.joining());
    }
}
