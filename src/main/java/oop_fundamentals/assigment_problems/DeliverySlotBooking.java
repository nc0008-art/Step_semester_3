package oop_fundamentals.assigment_problems;

public class DeliverySlotBooking {
    public static void main(String[] args) {
        System.out.println(new DeliverySlot("ORD101", "13:00-14:00").isPeakHour());
        System.out.println(new DeliverySlot("ORD102").isPeakHour());
    }

    static class DeliverySlot {
        private final String orderId;
        private final String timeSlot;

        public DeliverySlot(String orderId, String timeSlot) {
            this.orderId = orderId;
            this.timeSlot = timeSlot;
        }

        public DeliverySlot(String orderId) {
            this(orderId, "ASAP");
        }

        boolean isPeakHour() {
            return "12:00-13:00".equals(timeSlot)
                    || "13:00-14:00".equals(timeSlot)
                    || "19:00-20:00".equals(timeSlot)
                    || "20:00-21:00".equals(timeSlot);
        }
    }
}
