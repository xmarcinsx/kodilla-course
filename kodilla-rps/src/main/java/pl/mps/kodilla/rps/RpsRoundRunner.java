package pl.mps.kodilla.rps;

import java.util.Random;

import static pl.mps.kodilla.rps.RpsMenu.printComputerMoveInfo;
import static pl.mps.kodilla.rps.RpsMenu.printRoundInfo;

public class RpsRoundRunner {

    private static final Random random = new Random();

    private final int roundNumber;

    public RpsRoundRunner(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public RpsRoundResult play() {

        printRoundInfo(roundNumber);
        RpsTurn userTurn = getUserTurn();
        RpsTurn computerTurn = getComputerTurn();

        if (userTurn == RpsTurn.BAD) {
            return RpsRoundResult.BAD;
        }

        if (userTurn == RpsTurn.END) {
            return RpsRoundResult.END;
        }

        if (userTurn == RpsTurn.REPLAY) {
            return RpsRoundResult.REPLAY;
        }

        printComputerMoveInfo(computerTurn);

        return RpsMoveComparator.comapre(userTurn, computerTurn);
    }

    private RpsTurn getComputerTurn() {
        int move = random.nextInt(3) + 1;
        return RpsTurn.getMove(move);
    }

    private RpsTurn getUserTurn() {
        return RpsMenu.getUserTurn();
    }

}
