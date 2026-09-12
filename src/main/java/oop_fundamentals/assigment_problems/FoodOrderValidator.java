package oop_fundamentals.assigment_problems;

public class FoodOrderValidator {
    public static void main(String[] args) {
        String[][] rawOrders = {
                {"Ravi", "Paneer Butter Masala"}, {"", "Chole Bhature"},
                {"Meera", " "}, {"Divya", "Veg Biryani"}
        };
        FoodOrder.processBatch(rawOrders);
    }

    static class FoodOrder {
        private final String studentName;
        private final String dishName;
        private boolean delivered;

        public FoodOrder(String studentName, String dishName) {
            this.studentName = requireText(studentName, "Student name");
            this.dishName = requireText(dishName, "Dish name");
        }

        private static String requireText(String value, String fieldName) {
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException(fieldName + " must not be blank.");
            }
            return value.trim();
        }

        void markDelivered() {
            if (delivered) {
                System.out.println("Order for " + studentName + " was already delivered.");
                return;
            }
            delivered = true;
            System.out.println("Order for " + studentName + " delivered: " + dishName);
        }

        static void processBatch(String[][] rawOrders) {
            int accepted = 0;
            int rejected = 0;

            if (rawOrders != null) {
                for (String[] rawOrder : rawOrders) {
                    try {
                        if (rawOrder == null || rawOrder.length != 2) {
                            throw new IllegalArgumentException("An order needs two fields.");
                        }
                        new FoodOrder(rawOrder[0], rawOrder[1]);
                        accepted++;
                    } catch (IllegalArgumentException exception) {
                        rejected++;
                    }
                }
            }
            System.out.printf("Valid: %d | Rejected: %d%n", accepted, rejected);
        }
    }
}
