package oop_fundamentals.assigment_problems;

public class ParkingSlotAllocation {
    public static void main(String[] args) {
        ParkingSlot[] slots = {new ParkingSlot("A1", 4, 3), new ParkingSlot("A2", 5, 5)};
        safeAllot(slots, "TN09AB1234");
        safeAllot(slots, "TN09AB1234");
    }
    static ParkingSlot findAvailableSlot(ParkingSlot[] slots) { for (ParkingSlot slot : slots) if (slot.occupiedCount < slot.capacity) return slot; return null; }
    static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        // The reference is copied, but the slots it points to remain the same mutable objects.
        ParkingSlot slot = findAvailableSlot(slots);
        if (slot == null) System.out.println("No slots available for " + vehicleNo);
        else { slot.allot(vehicleNo); System.out.println(vehicleNo + " allotted to slot " + slot.slotNo); }
    }
    static class ParkingSlot { final String slotNo; final int capacity; int occupiedCount; ParkingSlot(String no, int capacity, int occupiedCount) { slotNo = no; this.capacity = capacity; this.occupiedCount = occupiedCount; } boolean allot(String vehicleNo) { if (occupiedCount >= capacity) return false; occupiedCount++; return true; } }
}
