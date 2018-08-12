package pl.mps.kodilla.rps;

import java.util.Scanner;

import static pl.mps.kodilla.rps.RpsTurn.getMove;

public class RpsMenu {

    private static final String MENU = "RPS -- Rock, Paper, Scissors -- Menu:";
    private static final String ROCK_MENU = "1 - Rock";
    private static final String PAPER_MENU = "2 - Paper";
    private static final String SCISSORS_MENU = "3 - Scissors";
    private static final String END_MENU = "x - end";
    private static final String REPLAY_MENU = "n - replay";
    private static final String GET_NAME = "Type your name: ";
    private static final String GET_ROUNDS = "Type number of rounds: ";
    public static final String GET_MOVE = "Type your move: ";
    public static final String COMPUTER_MOVE = "Computer's move: %s.";
    private static final String BAD_MOVE = "Bad move! Type again.";
    public static final String ROUND = "\nRound number: %d";

    private static final String RESULT_DRAW = "Round %d: Draw!";
    private static final String RESULT_COMPUTER = "Round %d: Computer wins!";
    private static final String RESULT_USER = "Round %d: %s wins!";

    private static final String GAME_OVER = "\nGame over! Result: ";
    private static final String STATISTICS = "Computer wins: %d, %s wins: %d, draws: %d";

    private static final Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("=============================================");
        System.out.println(MENU);
        System.out.println(ROCK_MENU);
        System.out.println(PAPER_MENU);
        System.out.println(SCISSORS_MENU);
        System.out.println(END_MENU);
        System.out.println(REPLAY_MENU);
        System.out.println("=============================================");
    }

    public static void printShortMenu() {
        System.out.println(String.format("Select move: %s, %s, %s, %s, %s", ROCK_MENU, PAPER_MENU, SCISSORS_MENU, END_MENU, REPLAY_MENU));
    }


    public static RpsGameDefinition getGameDefinition() {
        System.out.print(GET_NAME);
        String name = scanner.nextLine();
        System.out.print(GET_ROUNDS);
        int rounds = scanner.nextInt();
        return new RpsGameDefinition(name, rounds);
    }

    public static void printResult(RpsRoundResult result, int round, String userName, int computerWins, int userWins, int draws) {

        if (result == RpsRoundResult.BAD) {
            System.out.println(BAD_MOVE);
        }

        if (result == RpsRoundResult.DRAW) {
            System.out.println(String.format(RESULT_DRAW, round));
        }

        if (result == RpsRoundResult.COMPUTER) {
            System.out.println(String.format(RESULT_COMPUTER, round));
        }

        if (result == RpsRoundResult.USER) {
            System.out.println(String.format(RESULT_USER, round, userName));
        }

        if (result == RpsRoundResult.END || result == RpsRoundResult.REPLAY) {
            System.out.println(String.format(STATISTICS, computerWins, userName, userWins, draws));
        }
    }

    public static void printGameSummary(String userName, int computerWins, int userWins, int draws) {
        System.out.print(GAME_OVER);
        System.out.println(String.format(STATISTICS, computerWins, userName, userWins, draws));
    }

    public static void printRoundInfo(int roundNumer) {
        System.out.println(String.format(ROUND, roundNumer));
    }

    public static RpsTurn getUserTurn() {
        printShortMenu();
        System.out.print(GET_MOVE);
        return getMove(scanner.next());
    }

    public static void printComputerMoveInfo(RpsTurn move) {
        System.out.println(String.format(COMPUTER_MOVE, move));
    }
}
