import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static VehicleRentalManager manager = new VehicleRentalManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Rent Vehicle");
            System.out.println("2. Show Denied List");
            System.out.println("3. Exit");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    rentVehicle();
                    break;
                case "2":
                    showDeniedList();
                    break;
                case "3":
                    System.out.println("You left the Garage");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeData() {
        // Create vehicles using factories for water vehicles
        // Air Vehicles
        Airplane airplane = new Airplane(1982, 200000, 100, 22, 176, "Airplane", "White", "Fys-1", "Swiss", "Steering-Wheel", "Cameras", "Screen", "good", 250);
        Helicopter helicopter = new Helicopter(2019, 30000, 90, 25, 4, "Helicopter", "White", "3x-fje", "Helicopter", "Steering Wheel", "no", "Navi", "good", 8);
        Rocket rocket = new Rocket(2017, 40000, 394, 25, 2, "Rocket", "Red", "Fast", "Nasa", "Steering Wheel", "Camera", "Navi", "Launch Pad");

        // Water Vehicles created through factories
        WaterVehicleFactory boatFactory = new BoatFactory(2017, 1000000, 100, 18, 26, "Boat", "Golden", "Yacht", "Wally", 30, "No fishing Equipment", "Pasta, Bread, Fruits");
        WaterVehicleFactory submarineFactory = new SubmarineFactory(2020, 35000, 40, 21, 5, "Submarine", "White", "Sub", "Submarine", 100, 5000, 2);

        Boat boat = (Boat) boatFactory.createWaterVehicle();
        Submarine submarine = (Submarine) submarineFactory.createWaterVehicle();

        // Land Vehicles
        Bicycle bicycle = new Bicycle(2021, 89, 32, 10, 2, "Bicycle", "Blue", "Sport", "Canyon", "no", "Road");
        Bus bus = new Bus(2015, 30000, 75, 25, 50, "Bus", "Black", "052", "Mercedes", "no", 3, 3);
        Car car = new Car(2023, 150000, 80, 18, 2, "Car", "Green", "394", "Porsche", "yes", 0, 1);
        ElectroScooter electroScooter = new ElectroScooter(2023, 382, 45, 14, 0, "ElectroScooter", "Black", "234", "Ele", "no", 123, 3);
        Motorcycle motorcycle = new Motorcycle(2019, 2000, 125, 16, 1, "Motorcycle", "Black", "J39he", "Yamaha", "yes", "Sport");
        Sled sled = new Sled(2010, 10, 10, 3, 2, "Sled", "Brown", "39-kl", "Ottos", "no", "Snow");
        Tank tank = new Tank(2023, 300000, 70, 23, 5, "Tank", "Green", "HFRJ", "Military Swiss", "no", 5);
        Tractor tractor = new Tractor(2019, 7000, 90, 18, 2, "Tractor", "Green", "Trac", "Trac", "no", 150);
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
        System.out.println("\nDenied List:");
        List<Person> denylist = manager.getDenylist();
        if (denylist.isEmpty()) {
            System.out.println("The denylist is empty.");
        } else {
            for (Person deniedPerson : denylist) {
                System.out.println(deniedPerson.getName());
            }
        }
    }

    private static void rentVehicle() {
        System.out.print("\nEnter full name (first and last name): ");
        String fullName = scanner.nextLine();
        System.out.print("Enter birth date (yyyy-MM-dd): ");
        String birthDateInput = scanner.nextLine();
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }
        System.out.print("Enter phone number: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());

        Person customer = new Person(fullName, birthDate, phoneNumber);

        if (manager.isCustomerDenied(customer)) {
            System.out.println("Access Denied. You are on the deny list.");
            return;
        }

        System.out.println("\nSelect vehicle type to rent:");
        System.out.println("1. Land Vehicle");
        System.out.println("2. Water Vehicle");
        System.out.println("3. Air Vehicle");
        String vehicleTypeOption = scanner.nextLine();

        List<? extends Vehicle> availableVehicles;
        switch (vehicleTypeOption) {
            case "1":
                availableVehicles = manager.getVehiclesByType(LandVehicle.class);
                break;
            case "2":
                availableVehicles = manager.getVehiclesByType(WaterVehicle.class);
                break;
            case "3":
                availableVehicles = manager.getVehiclesByType(AirVehicle.class);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                return;
        }

        System.out.println("\nAvailable Vehicles:");
        for (int i = 0; i < availableVehicles.size(); i++) {
            System.out.println((i + 1) + ". " + availableVehicles.get(i).getVehicleInfo());
        }

        System.out.print("Select a vehicle: ");
        int vehicleIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (vehicleIndex < 0 || vehicleIndex >= availableVehicles.size()) {
            System.out.println("Invalid selection. Please try again.");
            return;
        }

        Vehicle selectedVehicle = availableVehicles.get(vehicleIndex);

        try {
            if (customer.getAge() < selectedVehicle.getAgeApproval()) {
                throw new minorAgeException("Access Denied. You are not old enough to rent this vehicle.");
            }

            System.out.print("Are you sure you want to rent this vehicle? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (!confirmation.equalsIgnoreCase("yes")) {
                return;
            }

            System.out.print("\nEnter start date (yyyy-MM-dd): ");
            String startDateInput = scanner.nextLine();
            LocalDate startDate;
            try {
                startDate = LocalDate.parse(startDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
                return;
            }

            System.out.print("Enter end date (yyyy-MM-dd): ");
            String endDateInput = scanner.nextLine();
            LocalDate endDate;
            try {
                endDate = LocalDate.parse(endDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
                return;
            }

            // Create a contract using the type of the selected vehicle
            Contract<? extends Vehicle> contract = new Contract<>(customer, selectedVehicle, startDate, endDate, "Standard terms");

            for (Contract<? extends Vehicle> existingContract : manager.getContracts()) {
                if (existingContract.getVehicle().equals(selectedVehicle) &&
                        !(endDate.isBefore(existingContract.getStartDate()) || startDate.isAfter(existingContract.getEndDate()))) {
                    throw new leaseLengthCollisionException("The vehicle is already rented in the specified period.");
                }
            }

            manager.createContract(customer, selectedVehicle, startDate, endDate, "Standard terms");
            System.out.println("\nContract created successfully!");

        } catch (minorAgeException | leaseLengthCollisionException e) {
            System.out.println(e.getMessage());
            System.out.print("Would you like to rent another vehicle? (yes/no): ");
            String anotherVehicle = scanner.nextLine();
            if (anotherVehicle.equalsIgnoreCase("yes")) {
                rentVehicle();
            }
        }
    }
}