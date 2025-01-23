package VehicleRental;

public class Bicycle extends LandVehicle {
    String babyMode;

    public String getBabyMode() {
        return babyMode;
    }

    public void setBabyMode(String babyMode) {
        this.babyMode = babyMode;
    }

    public Bicycle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, String babyMode) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.babyMode = babyMode;
    }
}