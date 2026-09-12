package oop_fundamentals.class_problems;

import java.util.HashSet;
import java.util.Set;

public class BusTicketBookingValidator {
    public static void main(String[] args) {
        String[][] rawBookings = {
                {"Divya", "Chennai"}, {"", "Bangalore"}, {"Ravi123", "Pune"},
                {"Divya", "Chennai"}, {" ", " "}
        };
        BusTicket.processBatch(rawBookings);
    }

    static class BusTicket {
        private final String passengerName;
        private final String destination;
        private boolean checkedIn;

        public BusTicket(String passengerName, String destination) {
            this.passengerName = validateName(passengerName);
            this.destination = validateDestination(destination);
        }

        private static String validateName(String name) {
            if (name == null || !name.trim().matches("[A-Za-z]+( [A-Za-z]+)*")) {
                throw new IllegalArgumentException("Passenger name must contain letters and spaces only.");
            }
            return name.trim();
        }

        private static String validateDestination(String destination) {
            if (destination == null || !destination.trim().matches("[A-Za-z]+( [A-Za-z]+)*")) {
                throw new IllegalArgumentException("Destination must contain letters and spaces only.");
            }
            return destination.trim();
        }

        void markCheckedIn() {
            if (checkedIn) {
                System.out.println("Ticket already checked in.");
                return;
            }
            checkedIn = true;
            System.out.println(passengerName + " checked in for " + destination + ".");
        }

        static void processBatch(String[][] rawBookings) {
            int valid = 0;
            int rejected = 0;
            int duplicates = 0;
            Set<String> acceptedPairs = new HashSet<>();

            if (rawBookings != null) {
                for (String[] rawBooking : rawBookings) {
                    try {
                        if (rawBooking == null || rawBooking.length != 2) {
                            throw new IllegalArgumentException("A booking needs two fields.");
                        }
                        BusTicket ticket = new BusTicket(rawBooking[0], rawBooking[1]);
                        String key = ticket.passengerName.toLowerCase() + "|" + ticket.destination.toLowerCase();
                        if (acceptedPairs.add(key)) valid++;
                        else duplicates++;
                    } catch (IllegalArgumentException exception) {
                        rejected++;
                    }
                }
            }
            System.out.printf("Valid: %d | Rejected: %d | Duplicates skipped: %d%n", valid, rejected, duplicates);
        }
    }
}
