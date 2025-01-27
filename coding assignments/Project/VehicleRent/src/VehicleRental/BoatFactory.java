package VehicleRental;

/**
 * A factory class for creating instances of the Boat class.
 * This class implements the WaterVehicleFactory interface and initializes
 * the parameters required to create a boat.
 */
public class BoatFactory implements WaterVehicleFactory {
    private int year; // The manufacturing year of the boat
    private int price; // The rental price of the boat
    private int speed; // The maximum speed of the boat
    private int ageApproval; // The minimum age required to rent the boat
    private int seats; // The number of seats in the boat
    private String name; // The name of the boat
    private String color; // The color of the boat
    private String model; // The model of the boat
    private String brand; // The brand of the boat
    private int chanceOfSinking; // The probability of the boat sinking
    private String fishingEquipment; // The fishing equipment available on the boat
    private String food; // The food provisions available on the boat

    /**
     * Constructs a BoatFactory object with specified parameters.
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
    public BoatFactory(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, int chanceOfSinking, String fishingEquipment, String food) {
        this.year = year;
        this.price = price;
        this.speed = speed;
        this.ageApproval = ageApproval;
        this.seats = seats;
        this.name = name;
        this.color = color;
        this.model = model;
        this.brand = brand;
        this.chanceOfSinking = chanceOfSinking;
        this.fishingEquipment = fishingEquipment;
        this.food = food;
    }

    /**
     * Creates and returns a new instance of a Boat using the factory's parameters.
     *
     * @return A new Boat object initialized with the factory's attributes.
     */
    @Override
    public WaterVehicle createWaterVehicle() {
        return new Boat(year, price, speed, ageApproval, seats, name, color, model, brand, chanceOfSinking, fishingEquipment, food);
    }
}