
public class Rocket extends AirVehicle{
    String flyingAbility;

    public String getFlyingAbility() {
        return flyingAbility;
    }

    public void setFlyingAbility(String flyingAbility) {
        this.flyingAbility = flyingAbility;
    }

    public Rocket(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String driveSystem, String securitySystem, String navigationSystem, int seats1, String flyingAbility) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, driveSystem, securitySystem, navigationSystem, seats1);
        this.flyingAbility = flyingAbility;
    }


}