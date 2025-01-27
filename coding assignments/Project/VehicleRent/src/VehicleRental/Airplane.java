package VehicleRental;

/**
 * Represents an airplane in a vehicle rental system.
 * This class extends the capabilities of the AirVehicle class, adding specific attributes
 * related to airplane functionalities such as food service and oxygen masks.
 */
public class Airplane extends AirVehicle {
    String foodService; // The type of food service provided on the airplane
    int oxygenMask; // The number of oxygen masks available on the airplane

    /**
     * Retrieves the food service provided on the airplane.
     *
     * @return A string representing the food service.
     */
    public String getFoodService() {
        return foodService;
    }

    /**
     * Sets the food service for the airplane.
     *
     * @param foodService A string representing the food service to be set.
     */
    public void setFoodService(String foodService) {
        this.foodService = foodService;
    }

    /**
     * Retrieves the number of oxygen masks available on the airplane.
     *
     * @return An integer representing the number of oxygen masks.
     */
    public int getOxygenMask() {
        return oxygenMask;
    }

    /**
     * Sets the number of oxygen masks for the airplane.
     *
     * @param oxygenMask An integer representing the number of oxygen masks to be set.
     */
    public void setOxygenMask(int oxygenMask) {
        this.oxygenMask = oxygenMask;
    }

    /**
     * Constructs an Airplane object with specified parameters.
     *
     * @param year          The manufacturing year of the airplane.
     * @param price         The rental price of the airplane.
     * @param speed         The maximum speed of the airplane.
     * @param ageApproval   The minimum age required to rent the airplane.
     * @param seats         The number of seats in the airplane.
     * @param name          The name of the airplane.
     * @param color         The color of the airplane.
     * @param model         The model of the airplane.
     * @param brand         The brand of the airplane.
     * @param driveSystem   The drive system used by the airplane.
     * @param securitySystem The security system installed in the airplane.
     * @param navigationSystem The navigation system installed in the airplane.
     * @param foodService   The type of food service offered on the airplane.
     * @param oxygenMask    The number of oxygen masks available on the airplane.
     */
    public Airplane(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String driveSystem, String securitySystem, String navigationSystem, String foodService, int oxygenMask) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, driveSystem, securitySystem, navigationSystem, foodService);
        this.foodService = foodService;
        this.oxygenMask = oxygenMask;
    }
}