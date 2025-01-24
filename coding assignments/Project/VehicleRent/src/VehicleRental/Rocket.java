package VehicleRental;

public class Rocket extends SpaceVehicle {
    String flyingAbility;

    public String getFlyingAbility() {
        return flyingAbility;
    }

    public void setFlyingAbility(String flyingAbility) {
        this.flyingAbility = flyingAbility;
    }

    public Rocket(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String AirPressure, String flyingAbility) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, AirPressure);
        this.flyingAbility = flyingAbility;
    }
}