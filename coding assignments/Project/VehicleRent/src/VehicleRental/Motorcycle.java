package VehicleRental;

public class Motorcycle extends LandVehicle {
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Motorcycle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, String type) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.type = type;
    }
}