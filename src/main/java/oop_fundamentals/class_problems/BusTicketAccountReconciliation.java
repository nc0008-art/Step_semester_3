package oop_fundamentals.class_problems;

public class BusTicketAccountReconciliation {
    public static void main(String[] args) {
        BusTicketAccount[] accounts = {
                new SleeperBusTicketAccount("BK001", 2000), null,
                new BusTicketAccount("BK002", 1200)
        };
        BusTicketAccount.processBatch(accounts, new double[]{1200, 900, 700}, new int[]{10, 5, 0});
    }

    static class BusTicketAccount {
        private static final String SYSTEM_NAME;
        private final String bookingId;
        private final double ticketFare;

        static {
            SYSTEM_NAME = "Fleet reconciliation";
        }

        public BusTicketAccount(String bookingId, double ticketFare) {
            if (bookingId == null || bookingId.trim().isEmpty() || ticketFare < 0) {
                throw new IllegalArgumentException("Booking ID must be present and fare cannot be negative.");
            }
            this.bookingId = bookingId.trim();
            this.ticketFare = ticketFare;
        }

        public BusTicketAccount(String bookingId) {
            this(bookingId, 0);
        }

        final double calculatePenalty(int minutesLate) {
            if (minutesLate < 0) throw new IllegalArgumentException("Late minutes cannot be negative.");
            if (minutesLate == 0) return 0;
            return ticketFare * (Math.min(minutesLate, 5) * 0.005
                    + Math.min(Math.max(minutesLate - 5, 0), 10) * 0.01
                    + Math.max(minutesLate - 15, 0) * 0.02);
        }

        void processAccount(BusTicketAccount account, double amount, int minutesLate) {
            System.out.printf("%s: Rs %.2f penalty (settled amount: Rs %.2f)%n", account.bookingId,
                    account.calculatePenalty(minutesLate), amount);
        }

        static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
            if (accounts == null || amounts == null || minutesLateArray == null
                    || accounts.length != amounts.length || accounts.length != minutesLateArray.length) {
                throw new IllegalArgumentException("Parallel arrays must have matching lengths.");
            }

            int processed = 0;
            int nullSkipped = 0;
            int sleeper = 0;
            double total = 0;
            for (int i = 0; i < accounts.length; i++) {
                BusTicketAccount account = accounts[i];
                if (account == null) {
                    nullSkipped++;
                    continue;
                }
                account.processAccount(account, amounts[i], minutesLateArray[i]);
                total += account.calculatePenalty(minutesLateArray[i]);
                processed++;
                if (account instanceof SleeperBusTicketAccount) sleeper++;
            }
            System.out.printf("%s: %d processed | %d null skipped | %d sleeper | %d regular | grand total penalties = Rs %.2f%n",
                    SYSTEM_NAME, processed, nullSkipped, sleeper, processed - sleeper, total);
        }
    }

    static class SleeperBusTicketAccount extends BusTicketAccount {
        SleeperBusTicketAccount(String bookingId, double ticketFare) {
            super(bookingId, ticketFare);
        }
    }
}
