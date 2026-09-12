package oop_fundamentals.assigment_problems;

public class DeliveryAccountReconciliation {
    public static void main(String[] args) {
        DeliveryAccount[] accounts = {
                new PremiumDeliveryAccount("STU001", 500), null,
                new DeliveryAccount("STU002", 300)
        };
        double[] amounts = {500, 400, 300};
        int[] delays = {10, 5, 0};
        DeliveryAccount.processBatch(accounts, amounts, delays);
    }

    static class DeliveryAccount {
        private static final String SYSTEM_NAME;
        private final String studentId;
        private final double orderValue;

        static {
            SYSTEM_NAME = "Campus delivery reconciliation";
        }

        public DeliveryAccount(String studentId, double orderValue) {
            if (studentId == null || studentId.trim().isEmpty() || orderValue < 0) {
                throw new IllegalArgumentException("Student ID must be present and order value cannot be negative.");
            }
            this.studentId = studentId.trim();
            this.orderValue = orderValue;
        }

        public DeliveryAccount(String studentId) {
            this(studentId, 0);
        }

        final double calculateSurgeFee(int delayMinutes) {
            if (delayMinutes < 0) throw new IllegalArgumentException("Delay cannot be negative.");
            if (delayMinutes == 0) return 0;
            return orderValue * (Math.min(delayMinutes, 5) * 0.005
                    + Math.min(Math.max(delayMinutes - 5, 0), 10) * 0.01
                    + Math.max(delayMinutes - 15, 0) * 0.02);
        }

        void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
            System.out.printf("%s: Rs %.2f surge fee%n", account.studentId,
                    account.calculateSurgeFee(delayMinutes));
        }

        static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
            if (accounts == null || amounts == null || delayMinutesArray == null
                    || accounts.length != amounts.length || accounts.length != delayMinutesArray.length) {
                throw new IllegalArgumentException("Parallel arrays must have matching lengths.");
            }

            int processed = 0;
            int nullSkipped = 0;
            int premium = 0;
            double total = 0;
            for (int i = 0; i < accounts.length; i++) {
                DeliveryAccount account = accounts[i];
                if (account == null) {
                    nullSkipped++;
                    continue;
                }
                account.processAccount(account, amounts[i], delayMinutesArray[i]);
                total += account.calculateSurgeFee(delayMinutesArray[i]);
                processed++;
                if (account instanceof PremiumDeliveryAccount) premium++;
            }
            System.out.printf("%s: %d processed | %d null skipped | %d premium | %d regular | grand total surge fees = Rs %.2f%n",
                    SYSTEM_NAME, processed, nullSkipped, premium, processed - premium, total);
        }
    }

    static class PremiumDeliveryAccount extends DeliveryAccount {
        PremiumDeliveryAccount(String studentId, double orderValue) {
            super(studentId, orderValue);
        }
    }
}
