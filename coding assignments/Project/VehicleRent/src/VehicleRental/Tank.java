package VehicleRental;

public class Tank extends LandVehicle {
    int destroyingTime;

    public int getDestroyingTime() {
        return destroyingTime;
    }

    public void setDestroyingTime(int destroyingTime) {
        this.destroyingTime = destroyingTime;
    }

    public Tank(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, int destroyingTime) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.destroyingTime = destroyingTime;
    }


}