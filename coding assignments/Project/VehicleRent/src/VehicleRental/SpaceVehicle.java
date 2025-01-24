package VehicleRental;

public class SpaceVehicle extends Vehicle {
    private VehicleBehavior behavior;
    public SpaceVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String AirPressure) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.behavior = new SpaceVehicleBehavior();
        this.behavior.setAirPressure(AirPressure);
    }
    public String getAirPressure() {
        return behavior.getAirPressure();
    }
    public void setAirPressure(String AirPressure) {
        behavior.setAirPressure(AirPressure);
    }
}