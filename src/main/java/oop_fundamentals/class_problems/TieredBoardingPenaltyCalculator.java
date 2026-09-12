package oop_fundamentals.class_problems;

public class TieredBoardingPenaltyCalculator {
    public static void main(String[] args) {
        BoardingPenaltyCalculator calculator = new BoardingPenaltyCalculator(1);
        System.out.printf("Rs %.1f%n", calculator.calculatePenalty(1000, 0));
        System.out.printf("Rs %.1f%n", calculator.calculatePenalty(1000, 1));
        System.out.printf("Rs %.1f%n", calculator.calculatePenalty(1000, 16));
    }

    static final class BoardingPenaltyCalculator {
        private final double minimumPenaltyPercent;

        public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
            if (minimumPenaltyPercent < 0) {
                throw new IllegalArgumentException("Minimum penalty percent cannot be negative.");
            }
            this.minimumPenaltyPercent = minimumPenaltyPercent;
        }

        final double calculatePenalty(double ticketFare, int minutesLate) {
            if (ticketFare < 0 || minutesLate < 0) {
                throw new IllegalArgumentException("Ticket fare and late minutes cannot be negative.");
            }
            if (minutesLate == 0) return 0;

            int firstTierMinutes = Math.min(minutesLate, 5);
            int secondTierMinutes = Math.min(Math.max(minutesLate - 5, 0), 10);
            int thirdTierMinutes = Math.max(minutesLate - 15, 0);
            double tieredPenalty = ticketFare * (firstTierMinutes * 0.005
                    + secondTierMinutes * 0.01 + thirdTierMinutes * 0.02);
            return Math.max(tieredPenalty, ticketFare * minimumPenaltyPercent / 100);
        }
    }
}
