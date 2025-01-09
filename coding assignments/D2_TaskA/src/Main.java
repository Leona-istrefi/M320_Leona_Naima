import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Main class to run the Flight Passenger Management System.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Schedule schedule = new Schedule();

        // Adding some flights with date and time
        schedule.addFlight(new Flight("AB123", LocalDateTime.parse("2025-01-10T10:30")));
        schedule.addFlight(new Flight("CD456", LocalDateTime.parse("2025-01-10T15:45")));

        System.out.println("Welcome to the Flight Passenger Management System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register a Passenger");
            System.out.println("2. Print Passengers for a Flight");
            System.out.println("3. View All Scheduled Flights");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    registerPassenger(scanner, schedule);
                    break;
                case 2:
                    printPassengersForFlight(scanner, schedule);
                    break;
                case 3:
                    schedule.printAllFlights();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Wrong input, try again.");
            }
        }
    }

    /**
     * Handles the registration of a passenger for a specific flight.
     *
     * @param scanner  the scanner object to read user input
     * @param schedule the schedule containing all flights
     */
    private static void registerPassenger(Scanner scanner, Schedule schedule) {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        Flight flight = schedule.findFlight(flightNumber);

        if (flight != null) {
            System.out.print("Enter passenger name: ");
            String passengerName = scanner.nextLine();

            String passportNumber;
            while (true) {
                System.out.print("Enter passport number (letters not allowed): ");
                passportNumber = scanner.nextLine();
                if (passportNumber.matches("^[A-Z0-9]+$")) {
                    break;
                }
                System.out.println("Invalid input! Passport number must contain only letters and numbers. Try again.");
            }

            Passenger newPassenger = new Passenger(passengerName, passportNumber);
            flight.addPassenger(newPassenger);
        } else {
            System.out.println("Flight not found.");
        }
    }

    /**
     * Prints all passengers for a specified flight.
     *
     * @param scanner  the scanner object to read user input
     * @param schedule the schedule containing all flights
     */
    private static void printPassengersForFlight(Scanner scanner, Schedule schedule) {
        System.out.print("Enter flight number: ");
        String searchFlightNumber = scanner.nextLine();
        Flight searchFlight = schedule.findFlight(searchFlightNumber);

        if (searchFlight != null) {
            searchFlight.printPassengers();
        } else {
            System.out.println("Flight not found.");
        }
    }
}
