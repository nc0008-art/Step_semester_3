package oop_fundamentals.assigment_problems;

public class ExamWeekSurgeFeeCalculator {
    public static void main(String[] args) {
        SurgeFeeCalculator calculator = new SurgeFeeCalculator(1);
        System.out.printf("Rs %.1f%n", calculator.calculateSurgeFee(500, 0));
        System.out.printf("Rs %.1f%n", calculator.calculateSurgeFee(500, 1));
        System.out.printf("Rs %.1f%n", calculator.calculateSurgeFee(500, 16));
    }

    static final class SurgeFeeCalculator {
        private final double minimumSurgePercent;

        public SurgeFeeCalculator(double minimumSurgePercent) {
            if (minimumSurgePercent < 0) {
                throw new IllegalArgumentException("Minimum surge percent cannot be negative.");
            }
            this.minimumSurgePercent = minimumSurgePercent;
        }

        final double calculateSurgeFee(double orderValue, int delayMinutes) {
            if (orderValue < 0 || delayMinutes < 0) {
                throw new IllegalArgumentException("Order value and delay minutes cannot be negative.");
            }
            if (delayMinutes == 0) return 0;

            int firstTierMinutes = Math.min(delayMinutes, 5);
            int secondTierMinutes = Math.min(Math.max(delayMinutes - 5, 0), 10);
            int thirdTierMinutes = Math.max(delayMinutes - 15, 0);
            double tieredFee = orderValue * (firstTierMinutes * 0.005
                    + secondTierMinutes * 0.01 + thirdTierMinutes * 0.02);
            double minimumFee = orderValue * minimumSurgePercent / 100;
            return Math.max(tieredFee, minimumFee);
        }
    }
}
