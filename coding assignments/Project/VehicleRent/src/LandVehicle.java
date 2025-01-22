public class LandVehicle extends Vehicle {
    private VehicleBehavior behavior;

    public LandVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.behavior = new LandVehicleBehavior();
        this.behavior.setHighWayApproval(highWayApproval);
    }

    public String getHighWayApproval() {
        return behavior.getHighWayApproval();
    }

    public void setHighWayApproval(String highWayApproval) {
        behavior.setHighWayApproval(highWayApproval);
    }
}