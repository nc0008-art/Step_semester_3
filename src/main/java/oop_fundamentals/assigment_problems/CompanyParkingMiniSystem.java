package oop_fundamentals.assigment_problems;

/** F5: combines employee inheritance, composition, parking, null safety, and a static counter. */
public class CompanyParkingMiniSystem {
    public static void main(String[] args) {
        ParkingSlotAllocation.ParkingSlot[] slots = {
            new ParkingSlotAllocation.ParkingSlot("A1", 1, 0),
            new ParkingSlotAllocation.ParkingSlot("A2", 1, 0)
        };

        // The existing null-safe method mutates the selected slot only when one exists.
        ParkingSlotAllocation.safeAllot(slots, "TN09AB1234");
        ParkingSlotAllocation.safeAllot(slots, "TN09CD5678");

        CompanyEmployeeRecord[] records = {
            new CompanyEmployeeRecord("Divya", "E01",
                new EmployeeInheritanceDemo.ManagerEmployee("E01", "Divya", 70000, 8000), slots[0]),
            new CompanyEmployeeRecord("Karan", "E02",
                new EmployeeInheritanceDemo.Employee("E02", "Karan", 40000), slots[1]),
            new CompanyEmployeeRecord("Meera", "E03",
                new EmployeeInheritanceDemo.InternEmployee("E03", "Meera", 12000, 10000), null)
        };

        for (CompanyEmployeeRecord record : records) {
            System.out.println(record.fullProfile());
        }
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }

    static class CompanyEmployeeRecord {
        private final String name;
        private final String empId;
        private final EmployeeInheritanceDemo.Employee employee;
        private final ParkingSlotAllocation.ParkingSlot slot;
        static int totalRecords;

        CompanyEmployeeRecord(String name, String empId,
                              EmployeeInheritanceDemo.Employee employee,
                              ParkingSlotAllocation.ParkingSlot slot) {
            this.name = name;
            this.empId = empId;
            this.employee = employee;
            this.slot = slot;
            totalRecords++;
        }

        String fullProfile() {
            double pay = employee.getSalary();
            if (employee instanceof EmployeeInheritanceDemo.ManagerEmployee manager) {
                pay = manager.effectiveSalary();
            } else if (employee instanceof EmployeeInheritanceDemo.InternEmployee intern) {
                pay = intern.effectiveSalary();
            }

            String assignedSlot = slot == null ? "no parking assigned" : slot.getSlotNo();
            return String.format("%s | Pay: Rs %.1f | Slot: %s", name, pay, assignedSlot);
        }
    }
}
