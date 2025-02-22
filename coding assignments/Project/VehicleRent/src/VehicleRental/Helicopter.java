package VehicleRental;

public class Helicopter extends AirVehicle {
    int propellers;

    public int getPropellers() {
        return propellers;
    }

    public void setPropellers(int propellers) {
        this.propellers = propellers;
    }

    public Helicopter(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String driveSystem, String securitySystem, String navigationSystem, String terrainType, int propellers) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, driveSystem, securitySystem, navigationSystem, terrainType);
        this.propellers = propellers;
    }
}