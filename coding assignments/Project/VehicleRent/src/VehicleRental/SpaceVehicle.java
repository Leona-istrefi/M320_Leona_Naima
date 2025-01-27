package VehicleRental;

public class SpaceVehicle extends Vehicle {
    private VehicleBehavior behavior; // Delegating behavior

    public SpaceVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String airPressure) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.behavior = new SpaceVehicleBehavior(); // Instantiate specific behavior
        this.behavior.setAirPressure(airPressure);
    }

    // Delegating air pressure behavior
    public String getAirPressure() {
        return behavior.getAirPressure();
    }

    public void setAirPressure(String airPressure) {
        behavior.setAirPressure(airPressure);
    }

    // Ability to change behavior dynamically
    public void setBehavior(VehicleBehavior behavior) {
        this.behavior = behavior;
    }

    public VehicleBehavior getBehavior() {
        return behavior;
    }
}
