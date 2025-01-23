package VehicleRental;

public class Truck extends LandVehicle {
    int height;
    int length;
    int wheels;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public Truck(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, int height, int length, int wheels) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.height = height;
        this.length = length;
        this.wheels = wheels;
    }


}