package pl.mps.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {
        RpsMenu.printMenu();
        new RpsGame(RpsMenu.getGameDefinition()).play();
    }

}
