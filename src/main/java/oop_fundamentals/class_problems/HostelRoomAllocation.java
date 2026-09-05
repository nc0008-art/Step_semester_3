package oop_fundamentals.class_problems;

public class HostelRoomAllocation {
    public static void main(String[] args) {
        HostelRoom[] rooms = {new HostelRoom("C-214", 3, 2), new HostelRoom("C-507", 2, 2)};
        safeAllot(rooms, "Divya");
        safeAllot(rooms, "Divya");
    }

    static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        for (HostelRoom room : rooms) if (room.occupied < room.beds) return room;
        return null;
    }

    static void safeAllot(HostelRoom[] rooms, String studentName) {
        // The array reference is passed by value, but its room objects are shared and not copied.
        HostelRoom room = findAvailableRoom(rooms);
        if (room == null) System.out.println("No rooms available for " + studentName);
        else { room.allot(studentName); System.out.println(studentName + " allotted to room " + room.roomNo); }
    }

    static class HostelRoom {
        private final String roomNo;
        private final int beds;
        private int occupied;
        HostelRoom(String roomNo, int beds, int occupied) { this.roomNo = roomNo; this.beds = beds; this.occupied = occupied; }
        boolean allot(String name) { if (occupied >= beds) return false; occupied++; return true; }
    }
}
