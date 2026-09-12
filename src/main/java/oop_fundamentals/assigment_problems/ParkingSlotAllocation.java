package oop_fundamentals.assigment_problems;

public class ParkingSlotAllocation {
    public static void main(String[] args) {
        ParkingSlot[] slots = {new ParkingSlot("A1", 4, 3), new ParkingSlot("A2", 5, 5)};
        safeAllot(slots, "TN09AB1234");
        safeAllot(slots, "TN09AB1234");
    }

    static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        // The array reference is passed by value, but it still refers to the same
        // ParkingSlot objects; no individual slots are copied by this method call.
        for (ParkingSlot slot : slots) {
            if (slot.occupiedCount < slot.capacity) return slot;
        }
        return null;
    }

    static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot slot = findAvailableSlot(slots);
        if (slot == null) {
            System.out.println("No slots available for " + vehicleNo);
            return;
        }
        slot.allot(vehicleNo);
        System.out.println(vehicleNo + " allotted to slot " + slot.slotNo);
    }

    static class ParkingSlot {
        private final String slotNo;
        private final int capacity;
        private int occupiedCount;

        ParkingSlot(String slotNo, int capacity, int occupiedCount) {
            this.slotNo = slotNo;
            this.capacity = capacity;
            this.occupiedCount = occupiedCount;
        }

        boolean allot(String vehicleNo) {
            if (occupiedCount >= capacity) return false;
            occupiedCount++;
            return true;
        }

        String getSlotNo() {
            return slotNo;
        }
    }
}
