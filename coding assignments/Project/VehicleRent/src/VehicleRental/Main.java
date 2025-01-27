package VehicleRental;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class Main {
    private static VehicleRentalManager manager = new VehicleRentalManager();
    private static Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

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
                break;  // Explicit end condition
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


    private static void initializeData() {
        final String WHITE = "white";
        final String BLACK = "black";
        final String GREEN = "green";

        // Air Vehicles
        Airplane airplane = new Airplane(1982, 200000, 100, 22, 176, "Airplane", WHITE, "Fys-1", "Swiss", "Steering-Wheel", "Cameras", "Screen", "good", 250);
        Helicopter helicopter = new Helicopter(2019, 30000, 90, 25, 4, "Helicopter", WHITE, "3x-fje", "Helicopter", "Steering Wheel", "no", "Navi", "good", 8);

        // Space Vehicles
        Rocket rocket = new Rocket(2017, 40000, 394, 25, 2, "Rocket", "Red", "Fast", "Nasa", "High", "good");
        SpaceShuttles spaceShuttles = new SpaceShuttles(1999, 20000, 596, 25, 4, "Shuttle 45", "White", "Model 457", "NASA", "very high", 1);

        // Water Vehicles created through factories
        WaterVehicleFactory boatFactory = new BoatFactory(2017, 1000000, 100, 18, 26, "Boat", "Golden", "Yacht", "Wally", 30, "No fishing Equipment", "Pasta, Bread, Fruits");
        WaterVehicleFactory submarineFactory = new SubmarineFactory(2020, 35000, 40, 21, 5, "Submarine", "White", "Sub", "Submarine", 100, 5000, 2);

        Boat boat = (Boat) boatFactory.createWaterVehicle();
        Submarine submarine = (Submarine) submarineFactory.createWaterVehicle();

        // Land Vehicles
        Bicycle bicycle = new Bicycle(2021, 89, 32, 10, 2, "Bicycle", "Blue", "Sport", "Canyon", "no", "Road");
        Bus bus = new Bus(2015, 30000, 75, 25, 50, "Bus", BLACK, "052", "Mercedes", "no", 3, 3);
        Car car = new Car(2023, 150000, 80, 18, 2, "Car", GREEN, "394", "Porsche", "yes", 0, 1);
        ElectroScooter electroScooter = new ElectroScooter(2023, 382, 45, 14, 0, "ElectroScooter", BLACK, "234", "Ele", "no", 123, 3);
        Motorcycle motorcycle = new Motorcycle(2019, 2000, 125, 16, 1, "Motorcycle", BLACK, "J39he", "Yamaha", "yes", "Sport");
        Sled sled = new Sled(2010, 10, 10, 3, 2, "Sled", "Brown", "39-kl", "Ottos", "no", "Snow");
        Tank tank = new Tank(2023, 300000, 70, 23, 5, "Tank", GREEN, "HFRJ", "Military Swiss", "no", 5);
        Tractor tractor = new Tractor(2019, 7000, 90, 18, 2, "Tractor", GREEN, "Trac", "Trac", "no", 150);
        Train train = new Train(2023, 40000, 80, 21, 300, "Train", "Red", "K9E", "SBB", "no", 0, 5);
        Truck truck = new Truck(2000, 7000, 90, 22, 2, "Truck", "White", "8JP", "HDME", "yes", 3, 50, 6);

        // Add Vehicles to Manager
        manager.addVehicle(airplane);
        manager.addVehicle(helicopter);
        manager.addVehicle(boat);
        manager.addVehicle(submarine);
        manager.addVehicle(bicycle);
        manager.addVehicle(bus);
        manager.addVehicle(car);
        manager.addVehicle(electroScooter);
        manager.addVehicle(motorcycle);
        manager.addVehicle(rocket);
        manager.addVehicle(sled);
        manager.addVehicle(tank);
        manager.addVehicle(tractor);
        manager.addVehicle(train);
        manager.addVehicle(truck);
        manager.addVehicle(spaceShuttles);

        // Adding Customers
        LocalDate leonaistrefiBirthDate = LocalDate.of(2005, 3, 1);
        Person leonaistrefi = new Person("Leona Istrefi", leonaistrefiBirthDate, 799042051);
        LocalDate naimaCavegnBirthDate = LocalDate.of(2001, 5, 10);
        Person naimaCavegn = new Person("Naima Cavegn", naimaCavegnBirthDate, 18984640);
        LocalDate florianloewBirthDate = LocalDate.of(2000, 9, 11);
        Person florianloew = new Person("Florian Loew", florianloewBirthDate, 41236985);

        manager.addCustomer(leonaistrefi);
        manager.addCustomer(naimaCavegn);
        manager.addCustomer(florianloew);

        manager.addPersonToDenylist(leonaistrefi);
        manager.addPersonToDenylist(naimaCavegn);
        manager.addPersonToDenylist(florianloew);
    }

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

    private static LocalDate parseDate(String dateInput) {
        try {
            return LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            LOGGER.info("Invalid date");
            return null;
        }
    }

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

    private static LocalDate[] getRentalDates() {
        LOGGER.info("\nEnter start date (yyyy-MM-dd): ");
        LocalDate startDate = parseDate(scanner.nextLine());
        if (startDate == null) return new LocalDate[0];

        LOGGER.info("Enter end date (yyyy-MM-dd): ");
        LocalDate endDate = parseDate(scanner.nextLine());
        if (endDate == null) return new LocalDate[0];

        return new LocalDate[]{startDate, endDate};
    }

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

    private static boolean askRetry() {
        LOGGER.info("Would you like to rent another vehicle? (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes") && rentVehicleRetry();
    }

    private static boolean rentVehicleRetry() {
        rentVehicle();
        return false;
    }

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