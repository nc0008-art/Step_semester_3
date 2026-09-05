package oop_fundamentals.class_problems;

public class AttendanceSystem {
    public static void main(String[] args) {
        SrmStudent[] students = {
                new SrmStudent("Ravi", "RA231100301001", 82),
                new SrmStudent("Anitha", "RA231100301002", 68),
                new SrmStudent("Karthik", "RA231100301003", 91),
                new SrmStudent("Meera", "RA231100301004", 74),
                new SrmStudent("Suresh", "RA231100301005", 60)
        };

        for (SrmStudent student : students) {
            String status = student.isEligible() ? "Eligible" : "Detained";
            System.out.printf("%s - %d%% - %s%n", student.name, student.attendance, status);
        }
        System.out.printf("Class average: %.1f%%%n", SrmStudent.classAverage(students));
    }

    static class SrmStudent {
        private final String name;
        private final String regNo;
        private int attendance;

        SrmStudent(String name, String regNo, int attendance) {
            this.name = name;
            this.regNo = regNo;
            this.attendance = attendance;
        }

        void addAttendanceUpdate(int newAttendance) {
            attendance = newAttendance;
        }

        boolean isEligible() {
            return attendance >= 75;
        }

        // Static because this calculation concerns an array of students, not one student.
        static double classAverage(SrmStudent[] students) {
            int total = 0;
            for (SrmStudent student : students) total += student.attendance;
            return students.length == 0 ? 0 : (double) total / students.length;
        }
    }
}
