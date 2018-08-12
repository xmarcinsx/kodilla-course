package pl.mps.kodilla.rps;

public class RpsGame {

    private String userName;
    private int rounds;
    private int roundNr;
    private int userWins;
    private int computerWins;
    private int draws;
    private boolean end;

    public RpsGame(RpsGameDefinition game) {
        this.userName = game.getName();
        this.rounds = game.getRounds();
    }

    public void play() {
        initGame();

        while (!end && roundNr <= rounds) {

            end = playRound();
        }

        RpsMenu.printGameSummary(userName, computerWins, userWins, draws);
    }

    public boolean playRound() {
        RpsRoundRunner round = new RpsRoundRunner(roundNr);

        RpsRoundResult result = round.play();
        RpsMenu.printResult(result, roundNr, userName, computerWins, userWins, draws);

        switch (result) {
            case END:
                return true;
            case REPLAY:
                return true;
            case DRAW:
                draws++;
                roundNr++;
                return false;
            case COMPUTER:
                computerWins++;
                roundNr++;
                return false;
            case USER:
                userWins++;
                roundNr++;
                return false;
            default:
                return true;
        }
    }

    public void initGame() {
        end = false;
        roundNr = 1;
        userWins = 0;
        computerWins = 0;
        draws = 0;
    }
}
