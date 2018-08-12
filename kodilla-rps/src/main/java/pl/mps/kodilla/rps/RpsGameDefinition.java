package pl.mps.kodilla.rps;

public class RpsGameDefinition {

    private final String name;
    private final int rounds;

    public RpsGameDefinition(String name, int rounds) {
        this.name = name;
        this.rounds = rounds;
    }

    public String getName() {
        return name;
    }

    public int getRounds() {
        return rounds;
    }
}
