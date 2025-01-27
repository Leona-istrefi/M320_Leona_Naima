package VehicleRental;

/**
 * Represents a boat in a vehicle rental system.
 * This class extends the WaterVehicle class and adds specific attributes
 * related to boating, such as fishing equipment and food provisions.
 */
public class Boat extends WaterVehicle {
    String fishingEquipment; // Equipment available for fishing
    String food; // Food provisions available on the boat

    /**
     * Retrieves the fishing equipment available on the boat.
     *
     * @return A string representing the fishing equipment.
     */
    public String getFishingEquipment() {
        return fishingEquipment;
    }

    /**
     * Sets the fishing equipment for the boat.
     *
     * @param fishingEquipment A string representing the fishing equipment to be set.
     */
    public void setFishingEquipment(String fishingEquipment) {
        this.fishingEquipment = fishingEquipment;
    }

    /**
     * Retrieves the food provisions available on the boat.
     *
     * @return A string representing the food provisions.
     */
    public String getFood() {
        return food;
    }

    /**
     * Sets the food provisions for the boat.
     *
     * @param food A string representing the food provisions to be set.
     */
    public void setFood(String food) {
        this.food = food;
    }

    /**
     * Constructs a Boat object with specified parameters.
     *
     * @param year          The manufacturing year of the boat.
     * @param price         The rental price of the boat.
     * @param speed         The maximum speed of the boat.
     * @param ageApproval   The minimum age required to rent the boat.
     * @param seats         The number of seats in the boat.
     * @param name          The name of the boat.
     * @param color         The color of the boat.
     * @param model         The model of the boat.
     * @param brand         The brand of the boat.
     * @param chanceOfSinking The probability of the boat sinking.
     * @param fishingEquipment The fishing equipment available on the boat.
     * @param food          The food provisions available on the boat.
     */
    public Boat(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, int chanceOfSinking, String fishingEquipment, String food) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, chanceOfSinking);
        this.fishingEquipment = fishingEquipment;
        this.food = food;
    }

    /**
     * Retrieves detailed information about the boat, including fishing equipment and food provisions.
     *
     * @return A string containing the vehicle information along with fishing equipment and food details.
     */
    @Override
    public String getVehicleInfo() {
        return super.getVehicleInfo() + " | Fishing Equipment: " + fishingEquipment + " | Food: " + food;
    }
}