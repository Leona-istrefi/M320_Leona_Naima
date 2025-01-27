package VehicleRental;

/**
 * Represents a bicycle in a vehicle rental system.
 * This class extends the LandVehicle class and adds specific attributes
 * related to bicycle functionalities, such as a baby mode.
 */
public class Bicycle extends LandVehicle {
    String babyMode; // Indicates if the bicycle has a baby mode feature

    /**
     * Retrieves the baby mode setting for the bicycle.
     *
     * @return A string representing the baby mode.
     */
    public String getBabyMode() {
        return babyMode;
    }

    /**
     * Sets the baby mode for the bicycle.
     *
     * @param babyMode A string representing the baby mode to be set.
     */
    public void setBabyMode(String babyMode) {
        this.babyMode = babyMode;
    }

    /**
     * Constructs a Bicycle object with specified parameters.
     *
     * @param year          The manufacturing year of the bicycle.
     * @param price         The rental price of the bicycle.
     * @param speed         The maximum speed of the bicycle.
     * @param ageApproval   The minimum age required to rent the bicycle.
     * @param seats         The number of seats on the bicycle.
     * @param name          The name of the bicycle.
     * @param color         The color of the bicycle.
     * @param model         The model of the bicycle.
     * @param brand         The brand of the bicycle.
     * @param highWayApproval The highway approval status of the bicycle.
     * @param babyMode      The baby mode setting for the bicycle.
     */
    public Bicycle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, String babyMode) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.babyMode = babyMode;
    }
}