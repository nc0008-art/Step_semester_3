package oop_fundamentals.class_problems;

public class StaticVsInstanceStudents {
    public static void main(String[] args) {
        BrokenStudent firstBroken = new BrokenStudent("Ravi", 82);
        BrokenStudent secondBroken = new BrokenStudent("Meera", 74);
        System.out.println("Broken version:");
        System.out.println(firstBroken.name);
        System.out.println(secondBroken.name);

        SrmStudent ravi = new SrmStudent("Ravi", 82);
        SrmStudent meera = new SrmStudent("Meera", 74);
        System.out.println("Fixed version:");
        ravi.printIdCard();
        meera.printIdCard();
        SrmStudent.printTotalAdmissions();
    }

    static class BrokenStudent {
        // These should not be static: each student's name, registration number, and attendance differ.
        static String name; static String regNo; static int attendance;
        BrokenStudent(String name, int attendance) { BrokenStudent.name = name; BrokenStudent.attendance = attendance; regNo = "shared"; }
    }

    static class SrmStudent {
        private final String name, regNo;
        private final int attendance;
        private static final String university = "SRM";
        private static int admissionCount;
        SrmStudent(String name, int attendance) {
            this.name = name; this.attendance = attendance;
            this.regNo = "RA231100301" + String.format("%03d", ++admissionCount + 10);
        }
        void printIdCard() { System.out.println(name + " | " + regNo); }
        static void printTotalAdmissions() { System.out.println("Students admitted so far: " + admissionCount); }
    }
}
