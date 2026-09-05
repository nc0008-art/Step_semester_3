package string_array_basics.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        boolean playerWins = (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;
        System.out.printf("%-7s %-12s %-14s %s%n", "Round", "Player", "Computer", "Result");
        for (int i = 0; i < playerMoves.length; i++) {
            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMoves[i], computerMove);
            if (result.equals("Player Wins")) wins++; else if (result.equals("Computer Wins")) losses++; else draws++;
            System.out.printf("%-7d %-12s %-14s %s%n", i + 1, playerMoves[i], computerMove, result);
        }
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws,
                wins * 100.0 / playerMoves.length);
    }
}
