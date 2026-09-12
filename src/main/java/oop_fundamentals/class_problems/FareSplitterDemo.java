package oop_fundamentals.class_problems;

import java.util.Arrays;

public class FareSplitterDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FareSplitter("TRIP001", 100000, 3).fareBreakdown()));
        System.out.println(Arrays.toString(new FareSplitter("TRIP003").fareBreakdown()));
    }

    static class FareSplitter {
        private final String tripId;
        private final double totalFare;
        private final int passengerCount;

        public FareSplitter(String tripId, double totalFare, int passengerCount) {
            if (totalFare < 0 || passengerCount <= 0) {
                throw new IllegalArgumentException("Fare must be non-negative and passenger count must be positive.");
            }
            this.tripId = tripId;
            this.totalFare = totalFare;
            this.passengerCount = passengerCount;
        }

        public FareSplitter(String tripId, double totalFare) {
            this(tripId, totalFare, 2);
        }

        public FareSplitter(String tripId) {
            this(tripId, 0, 2);
        }

        double[] fareBreakdown() {
            long totalPaise = Math.round(totalFare * 100);
            long baseShare = totalPaise / passengerCount;
            long remainder = totalPaise % passengerCount;
            double[] shares = new double[passengerCount];
            for (int i = 0; i < passengerCount; i++) {
                shares[i] = (baseShare + (i >= passengerCount - remainder ? 1 : 0)) / 100.0;
            }
            return shares;
        }

        boolean isConfirmationOverdue(int confirmed, int expected) {
            if (confirmed < 0 || expected < 0) {
                throw new IllegalArgumentException("Confirmation counts cannot be negative.");
            }
            return confirmed < expected;
        }
    }
}
