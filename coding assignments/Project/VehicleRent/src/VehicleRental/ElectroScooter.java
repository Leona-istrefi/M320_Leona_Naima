package VehicleRental;

public class ElectroScooter extends LandVehicle {
    int kilometers;
    int battery;

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public ElectroScooter(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, int kilometers, int battery) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.kilometers = kilometers;
        this.battery = battery;
    }


}