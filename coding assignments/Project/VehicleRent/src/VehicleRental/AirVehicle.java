package VehicleRental;

/**
 * Represents an air vehicle in a vehicle rental system.
 * This class extends the Vehicle class, adding specific attributes related
 * to air vehicles, such as drive systems, security systems, navigation systems,
 * and seat configurations.
 */
public class AirVehicle extends Vehicle {
    private String driveSystem; // The drive system of the air vehicle
    private String securitySystem; // The security system of the air vehicle
    private String navigationSystem; // The navigation system of the air vehicle
    private int seats; // The number of seats in the air vehicle
    private TerrestrialAndAerialBehavior behavior; // Behavior specific to air vehicles

    /**
     * Constructs an AirVehicle object with specified parameters.
     *
     * @param year          The manufacturing year of the air vehicle.
     * @param price         The rental price of the air vehicle.
     * @param speed         The maximum speed of the air vehicle.
     * @param ageApproval   The minimum age required to rent the air vehicle.
     * @param seats         The number of seats in the air vehicle.
     * @param name          The name of the air vehicle.
     * @param color         The color of the air vehicle.
     * @param model         The model of the air vehicle.
     * @param brand         The brand of the air vehicle.
     * @param driveSystem   The drive system used by the air vehicle.
     * @param securitySystem The security system installed in the air vehicle.
     * @param navigationSystem The navigation system installed in the air vehicle.
     * @param terrainType   The type of terrain the air vehicle can operate on.
     */
    public AirVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String driveSystem, String securitySystem, String navigationSystem, String terrainType) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.driveSystem = driveSystem;
        this.securitySystem = securitySystem;
        this.navigationSystem = navigationSystem;
        this.seats = seats;
        this.behavior = new AirVehicleBehavior(); // Initialize the behavior class
        this.behavior.setTerrainType(terrainType); // Set the terrain type for the vehicle's behavior
    }

    /**
     * Retrieves the drive system of the air vehicle.
     *
     * @return A string representing the drive system.
     */
    public String getDriveSystem() {
        return driveSystem;
    }

    /**
     * Sets the drive system for the air vehicle.
     *
     * @param driveSystem A string representing the drive system to be set.
     */
    public void setDriveSystem(String driveSystem) {
        this.driveSystem = driveSystem;
    }

    /**
     * Retrieves the security system of the air vehicle.
     *
     * @return A string representing the security system.
     */
    public String getSecuritySystem() {
        return securitySystem;
    }

    /**
     * Sets the security system for the air vehicle.
     *
     * @param securitySystem A string representing the security system to be set.
     */
    public void setSecuritySystem(String securitySystem) {
        this.securitySystem = securitySystem;
    }

    /**
     * Retrieves the navigation system of the air vehicle.
     *
     * @return A string representing the navigation system.
     */
    public String getNavigationSystem() {
        return navigationSystem;
    }

    /**
     * Sets the navigation system for the air vehicle.
     *
     * @param navigationSystem A string representing the navigation system to be set.
     */
    public void setNavigationSystem(String navigationSystem) {
        this.navigationSystem = navigationSystem;
    }

    /**
     * Retrieves the terrain type that the air vehicle can operate on.
     *
     * @return A string representing the terrain type.
     */
    public String getTerrainType() {
        return behavior.getTerrainType();
    }

    /**
     * Sets the terrain type for the air vehicle's behavior.
     *
     * @param terrainType A string representing the terrain type to be set.
     */
    public void setTerrainType(String terrainType) {
        behavior.setTerrainType(terrainType);
    }

    /**
     * Retrieves the number of seats in the air vehicle.
     *
     * @return An integer representing the number of seats.
     */
    @Override
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the number of seats for the air vehicle.
     *
     * @param seats An integer representing the number of seats to be set.
     */
    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }
}