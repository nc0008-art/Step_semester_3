package oop_fundamentals.class_problems;

public class FeeHostelManagementSystem {
    public static void main(String[] args) {
        HostelRoom c214 = new HostelRoom("C-214", 1);
        HostelRoom c507 = new HostelRoom("C-507", 1);
        SrmStudent ravi = new SrmStudent("Ravi", "RA001", new HostelFeeAccount(200000));
        SrmStudent anitha = new SrmStudent("Anitha", "RA002", new HostelFeeAccount(200000));
        SrmStudent karthik = new SrmStudent("Karthik", "RA003", new HostelFeeAccount(200000));
        ravi.feeAccount.pay(60000); anitha.feeAccount.pay(20000); ravi.feeAccount.pay(-10);
        ravi.room = c214; c214.allot(); anitha.room = c507; c507.allot();
        System.out.println(ravi.fullStatus()); System.out.println(anitha.fullStatus()); System.out.println(karthik.fullStatus());
        System.out.println("Total students: " + SrmStudent.totalStudents);
    }
    static class FeeAccount { private final double totalFee; private double paid; FeeAccount(double totalFee) { this.totalFee = totalFee; }
        void pay(double amount) { if (amount <= 0) { System.out.println("Payment rejected: amount must be positive."); return; } paid += amount; }
        double getDue() { return totalFee - paid; } }
    static class HostelFeeAccount extends FeeAccount { HostelFeeAccount(double fee) { super(fee); } }
    static class HostelRoom { final String roomNo; boolean occupied; HostelRoom(String roomNo, int beds) { this.roomNo = roomNo; }
        void allot() { occupied = true; } }
    static class SrmStudent { final String name, regNo; final HostelFeeAccount feeAccount; HostelRoom room; static int totalStudents;
        SrmStudent(String name, String regNo, HostelFeeAccount feeAccount) { this.name = name; this.regNo = regNo; this.feeAccount = feeAccount; totalStudents++; }
        String fullStatus() { return name + " | Due: Rs " + feeAccount.getDue() + " | Room: " + (room == null ? "unallotted" : room.roomNo); } }
}
