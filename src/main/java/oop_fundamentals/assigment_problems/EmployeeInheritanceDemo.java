package oop_fundamentals.assigment_problems;

public class EmployeeInheritanceDemo {
    public static void main(String[] args) {
        Employee[] employees = {new Employee("E01", "Priya", 40000), new ManagerEmployee("E02", "Sam", 70000, 8000), new InternEmployee("E03", "Tara", 12000, 10000)};
        for (Employee employee : employees) {
            if (employee instanceof ManagerEmployee manager) System.out.printf("Manager effective pay: Rs %.1f%n", manager.effectiveSalary());
            else if (employee instanceof InternEmployee intern) System.out.printf("Intern effective pay: Rs %.1f%n", intern.effectiveSalary());
            else System.out.printf("Plain employee pay: Rs %.1f%n", employee.getSalary());
        }
    }
    static class Employee { private final String empId, empName; private final double salary; Employee(String id, String name, double salary) { empId = id; empName = name; this.salary = salary; } double getSalary() { return salary; } }
    static class ManagerEmployee extends Employee { private final double teamBonus; ManagerEmployee(String id, String name, double salary, double bonus) { super(id, name, salary); teamBonus = bonus; } double effectiveSalary() { return getSalary() + teamBonus; } }
    static class InternEmployee extends Employee { private final double stipendCap; InternEmployee(String id, String name, double salary, double cap) { super(id, name, salary); stipendCap = cap; } double effectiveSalary() { return Math.min(getSalary(), stipendCap); } }
}
