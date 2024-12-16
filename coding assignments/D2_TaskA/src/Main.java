import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Schedule schedule = new Schedule();


        schedule.addFlight(new Flight("AB123"));
        schedule.addFlight(new Flight("CD456"));

        System.out.println("Welcome to the Flight Passenger Management System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register a Passenger");
            System.out.println("2. Print Passengers for a Flight");
            System.out.println("3. View All Scheduled Flights");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.nextLine();
                    Flight flight = schedule.findFlight(flightNumber);

                    if (flight != null) {
                        String passengerName;
                        while (true) {
                            System.out.print("Enter passenger name (letters only): ");
                            passengerName = scanner.nextLine();
                            if (passengerName.matches("^[a-zA-Z ]+$")) {
                                break;
                            }
                            System.out.println("Invalid input! Name must contain only letters and spaces.");
                        }

                        Passenger newPassenger = new Passenger(passengerName);
                        flight.addPassenger(newPassenger);
                        System.out.println("Passenger registered successfully!");
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;

                case 2:

                    System.out.print("Enter flight number: ");
                    String searchFlightNumber = scanner.nextLine();
                    Flight searchFlight = schedule.findFlight(searchFlightNumber);

                    if (searchFlight != null) {
                        searchFlight.printPassengers();
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;

                case 3:

                    schedule.printAllFlights();
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
