package VehicleRental;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * The Main class serves as the entry point for the Vehicle Rental application.
 * It provides an interactive console-based menu for managing vehicles, rentals,
 * and deny list functionalities.
 */
public class Main {

    /**
     * Manages the list of vehicles, customers, and rental operations.
     */
    private static VehicleRentalManager manager = new VehicleRentalManager();

    /**
     * Scanner for reading user input.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Logger for application-wide logging.
     */
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * The main method initializes the application, sets up logging, and presents the main menu.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Remove default handlers
        for (var handler : LOGGER.getHandlers()) {
            LOGGER.removeHandler(handler);
        }

        // Set up the custom formatter
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(consoleHandler);

        initializeData();

        while (true) {
            LOGGER.info("\nWhat would you like to do?");
            LOGGER.info("1. Rent vehicle");
            LOGGER.info("2. Show Denied List");
            LOGGER.info("3. Add Person to Denied List");
            LOGGER.info("4. Exit");
            String option = scanner.nextLine();

            if ("4".equals(option)) {
                LOGGER.info("You left the Garage");
                break; // Explicit end condition
            }

            switch (option) {
                case "1":
                    rentVehicle();
                    break;
                case "2":
                    showDeniedList();
                    break;
                case "3":
                    addPersonToDenylist();
                    break;
                default:
                    LOGGER.info("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * Initializes vehicles and customers for the rental system.
     * Populates the deny list with sample data.
     */
    private static void initializeData() {
        final String WHITE = "white";
        final String BLACK = "black";
        final String GREEN = "green";

        // Initialize and add vehicles
        Airplane airplane = new Airplane(1982, 200000, 100, 22, 176, "Airplane", WHITE, "Fys-1", "Swiss", "Steering-Wheel", "Cameras", "Screen", "good", 250);
        Helicopter helicopter = new Helicopter(2019, 30000, 90, 25, 4, "Helicopter", WHITE, "3x-fje", "Helicopter", "Steering Wheel", "no", "Navi", "good", 8);

        Rocket rocket = new Rocket(2017, 40000, 394, 25, 2, "Rocket", "Red", "Fast", "Nasa", "High", "good");
        SpaceShuttles spaceShuttles = new SpaceShuttles(1999, 20000, 596, 25, 4, "Shuttle 45", "White", "Model 457", "NASA", "very high", 1);

        WaterVehicleFactory boatFactory = new BoatFactory(2017, 1000000, 100, 18, 26, "Boat", "Golden", "Yacht", "Wally", 30, "No fishing Equipment", "Pasta, Bread, Fruits");
        WaterVehicleFactory submarineFactory = new SubmarineFactory(2020, 35000, 40, 21, 5, "Submarine", "White", "Sub", "Submarine", 100, 5000, 2);

        Boat boat = (Boat) boatFactory.createWaterVehicle();
        Submarine submarine = (Submarine) submarineFactory.createWaterVehicle();

        Bicycle bicycle = new Bicycle(2021, 89, 32, 10, 2, "Bicycle", "Blue", "Sport", "Canyon", "no", "Road");
        Bus bus = new Bus(2015, 30000, 75, 25, 50, "Bus", BLACK, "052", "Mercedes", "no", 3, 3);
        Car car = new Car(2023, 150000, 80, 18, 2, "Car", GREEN, "394", "Porsche", "yes", 0, 1);

        // Add vehicles to the manager
        manager.addVehicle(airplane);
        manager.addVehicle(helicopter);
        manager.addVehicle(rocket);
        manager.addVehicle(spaceShuttles);
        manager.addVehicle(boat);
        manager.addVehicle(submarine);
        manager.addVehicle(bicycle);
        manager.addVehicle(bus);
        manager.addVehicle(car);

        // Add sample customers
        LocalDate leonaistrefiBirthDate = LocalDate.of(2005, 3, 1);
        Person leonaistrefi = new Person("Leona Istrefi", leonaistrefiBirthDate, 799042051);

        manager.addPersonToDenylist(leonaistrefi);
    }

    /**
     * Displays the denied list (people prohibited from renting vehicles).
     */
    private static void showDeniedList() {
        LOGGER.info("\nDenied List:");
        List<Person> denylist = manager.getDenylist();
        if (denylist.isEmpty()) {
            LOGGER.info("The denylist is empty.");
        } else {
            for (Person deniedPerson : denylist) {
                LOGGER.info(deniedPerson.getName());
            }
        }
    }

    /**
     * Handles the vehicle rental process, including customer validation,
     * vehicle selection, and rental confirmation.
     */
    private static void rentVehicle() {
        Person customer = getCustomerDetails();
        if (customer == null || manager.isCustomerDenied(customer)) {
            LOGGER.info("Access Denied. You are on the deny list.");
            return;
        }

        List<? extends Vehicle> availableVehicles = getAvailableVehicles();
        if (availableVehicles == null) return;

        Vehicle selectedVehicle = selectVehicle(availableVehicles);
        if (selectedVehicle == null) return;

        if (!confirmRental(customer, selectedVehicle)) return;

        LocalDate[] rentalDates = getRentalDates();
        if (rentalDates == null) return;

        createRentalContract(customer, selectedVehicle, rentalDates[0], rentalDates[1]);
    }

    /**
     * Retrieves customer details by prompting the user to input their full name, birth date, and phone number.
     *
     * @return A new {@link Person} object containing the customer's details, or null if the input is invalid.
     */
    private static Person getCustomerDetails() {
        LOGGER.info("\nEnter full name (first and last name): ");
        String fullName = scanner.nextLine();

        LOGGER.info("Enter birth date (yyyy-MM-dd): ");
        LocalDate birthDate = parseDate(scanner.nextLine());
        if (birthDate == null) return null;

        LOGGER.info("Enter phone number: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());

        return new Person(fullName, birthDate, phoneNumber);
    }

    /**
     * Parses a date string in the format "yyyy-MM-dd" into a {@link LocalDate} object.
     *
     * @param dateInput The date string to parse.
     * @return A {@link LocalDate} object representing the parsed date, or null if the input is invalid.
     */
    private static LocalDate parseDate(String dateInput) {
        try {
            return LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            LOGGER.info("Invalid date");
            return null;
        }
    }

    /**
     * Prompts the user to select a type of vehicle to rent and retrieves a list of available vehicles of that type.
     *
     * @return A list of vehicles of the selected type, or null if the selection is invalid.
     */
    private static List<? extends Vehicle> getAvailableVehicles() {
        LOGGER.info("\nSelect vehicle type to rent:");
        LOGGER.info("1. Land Vehicle");
        LOGGER.info("2. Water Vehicle");
        LOGGER.info("3. Air Vehicle");
        String vehicleTypeOption = scanner.nextLine();

        switch (vehicleTypeOption) {
            case "1":
                return manager.getVehiclesByType(LandVehicle.class);
            case "2":
                return manager.getVehiclesByType(WaterVehicle.class);
            case "3":
                return manager.getVehiclesByType(AirVehicle.class);
            default:
                LOGGER.info("Invalid option. Please try again.");
                return null;
        }
    }

    /**
     * Allows the user to select a specific vehicle from a list of available vehicles.
     *
     * @param availableVehicles The list of vehicles available for selection.
     * @return The selected {@link Vehicle}, or null if the selection is invalid.
     */
    private static Vehicle selectVehicle(List<? extends Vehicle> availableVehicles) {
        LOGGER.info("\nAvailable Vehicles:");
        for (int i = 0; i < availableVehicles.size(); i++) {
            LOGGER.info((i + 1) + ". " + availableVehicles.get(i).getVehicleInfo());
        }

        LOGGER.info("Select a vehicle: ");
        int vehicleIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (vehicleIndex < 0 || vehicleIndex >= availableVehicles.size()) {
            LOGGER.info("Invalid selection. Please try again.");
            return null;
        }

        return availableVehicles.get(vehicleIndex);
    }

    /**
     * Confirms the rental of a vehicle for a customer by checking age approval and seeking user confirmation.
     *
     * @param customer        The {@link Person} attempting to rent a vehicle.
     * @param selectedVehicle The {@link Vehicle} the customer wishes to rent.
     * @return True if the rental is confirmed, false otherwise.
     */
    private static boolean confirmRental(Person customer, Vehicle selectedVehicle) {
        try {
            if (customer.getAge() < selectedVehicle.getAgeApproval()) {
                throw new MinorAgeException("Access Denied. You are not old enough to rent this vehicle.");
            }
            LOGGER.info("Are you sure you want to rent this vehicle? (yes/no): ");
            return scanner.nextLine().equalsIgnoreCase("yes");
        } catch (MinorAgeException e) {
            LOGGER.info(e.getMessage());
            return askRetry();
        }
    }

    /**
     * Prompts the user to input the rental start and end dates.
     *
     * @return An array of two {@link LocalDate} objects representing the start and end dates, or null if the input is invalid.
     */
    private static LocalDate[] getRentalDates() {
        LOGGER.info("\nEnter start date (yyyy-MM-dd): ");
        LocalDate startDate = parseDate(scanner.nextLine());
        if (startDate == null) return new LocalDate[0];

        LOGGER.info("Enter end date (yyyy-MM-dd): ");
        LocalDate endDate = parseDate(scanner.nextLine());
        if (endDate == null) return new LocalDate[0];

        return new LocalDate[]{startDate, endDate};
    }

    /**
     * Creates a rental contract for a customer and a selected vehicle within the specified rental period.
     *
     * @param customer        The {@link Person} renting the vehicle.
     * @param selectedVehicle The {@link Vehicle} being rented.
     * @param startDate       The start date of the rental period.
     * @param endDate         The end date of the rental period.
     */
    private static void createRentalContract(Person customer, Vehicle selectedVehicle, LocalDate startDate, LocalDate endDate) {
        try {
            for (Contract<? extends Vehicle> existingContract : manager.getContracts()) {
                if (existingContract.getVehicle().equals(selectedVehicle) &&
                        !(endDate.isBefore(existingContract.getStartDate()) || startDate.isAfter(existingContract.getEndDate()))) {
                    throw new LeaseLengthCollisionException("The vehicle is already rented in the specified period.");
                }
            }

            manager.createContract(customer, selectedVehicle, startDate, endDate, "Standard terms");
            LOGGER.info("\nContract created successfully!");
        } catch (LeaseLengthCollisionException e) {
            LOGGER.info(e.getMessage());
            askRetry();
        }
    }

    /**
     * Prompts the user to decide whether to retry renting a vehicle.
     *
     * @return True if the user chooses to retry, false otherwise.
     */
    private static boolean askRetry() {
        LOGGER.info("Would you like to rent another vehicle? (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes") && rentVehicleRetry();
    }

    /**
     * Retries the vehicle rental process.
     *
     * @return False as this method does not return success of rental.
     */
    private static boolean rentVehicleRetry() {
        rentVehicle();
        return false;
    }

    /**
     * Adds a person to the denylist by prompting the user for their full name, birth date, and phone number.
     */
    private static void addPersonToDenylist() {
        LOGGER.info("\nEnter full name of the person to deny: ");
        String fullName = scanner.nextLine();

        LOGGER.info("Enter birth date (yyyy-MM-dd): ");
        LocalDate birthDate = parseDate(scanner.nextLine());
        if (birthDate == null) return;

        LOGGER.info("Enter phone number: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());

        Person personToDeny = new Person(fullName, birthDate, phoneNumber);
        manager.addPersonToDenylist(personToDeny);
        LOGGER.info(fullName + " has been added to the deny list.");
    }
}