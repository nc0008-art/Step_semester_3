package oop_fundamentals.class_problems;

public class FeeAccountInheritanceDemo {
    public static void main(String[] args) {
        FeeAccount[] accounts = {
                new FeeAccount("RA001", 150000),
                new HostelFeeAccount("RA002", 200000),
                new ScholarshipFeeAccount("RA003", 180000, 20)
        };
        accounts[0].pay(150000);
        ((HostelFeeAccount) accounts[1]).payInTwoInstallments(60000);

        for (FeeAccount account : accounts) {
            if (account instanceof ScholarshipFeeAccount scholarship) {
                System.out.printf("Scholarship account effective due: Rs %.1f%n", scholarship.effectiveDue());
            } else if (account instanceof HostelFeeAccount) {
                System.out.printf("Hostel account due: Rs %.1f%n", account.getDue());
            } else {
                System.out.printf("Plain account due: Rs %.1f%n", account.getDue());
            }
        }
    }

    static class FeeAccount {
        private final String regNo;
        private final double totalFee;
        private double amountPaid;

        FeeAccount(String regNo, double totalFee) { this.regNo = regNo; this.totalFee = totalFee; }
        void pay(double amount) {
            if (amount <= 0) { System.out.println("Payment rejected: amount must be positive."); return; }
            amountPaid += amount;
        }
        double getDue() { return Math.max(0, totalFee - amountPaid); }
    }

    static class HostelFeeAccount extends FeeAccount {
        HostelFeeAccount(String regNo, double totalFee) { super(regNo, totalFee); }
        void payInTwoInstallments(double amount) { pay(amount / 2); pay(amount / 2); }
    }

    static class ScholarshipFeeAccount extends FeeAccount {
        private final double scholarshipPercent;
        ScholarshipFeeAccount(String regNo, double totalFee, double scholarshipPercent) {
            super(regNo, totalFee);
            if (scholarshipPercent < 0 || scholarshipPercent > 100) throw new IllegalArgumentException("Percentage must be 0-100");
            this.scholarshipPercent = scholarshipPercent;
        }
        double effectiveDue() { return getDue() * (100 - scholarshipPercent) / 100; }
    }
}
