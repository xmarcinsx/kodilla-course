package pl.mps.kodilla.rps;

import static pl.mps.kodilla.rps.RpsTurn.PAPER;
import static pl.mps.kodilla.rps.RpsTurn.ROCK;
import static pl.mps.kodilla.rps.RpsTurn.SCISSORS;

public class RpsMoveComparator {

    public static RpsRoundResult comapre(RpsTurn userTurn, RpsTurn computerTurn) {

        if (userTurn == ROCK && computerTurn == PAPER) {
            return RpsRoundResult.COMPUTER;
        }

        if (userTurn == ROCK && computerTurn == SCISSORS) {
            return RpsRoundResult.USER;
        }

        if (userTurn == PAPER && computerTurn == ROCK) {
            return RpsRoundResult.USER;
        }

        if (userTurn == PAPER && computerTurn == SCISSORS) {
            return RpsRoundResult.COMPUTER;
        }

        if (userTurn == SCISSORS && computerTurn == ROCK) {
            return RpsRoundResult.COMPUTER;
        }

        if (userTurn == SCISSORS && computerTurn == PAPER) {
            return RpsRoundResult.USER;
        }

        return RpsRoundResult.DRAW;
    }
}
