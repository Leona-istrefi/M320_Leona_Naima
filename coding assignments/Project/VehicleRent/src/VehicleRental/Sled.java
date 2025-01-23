package VehicleRental;

public class Sled extends LandVehicle {
    String slidingAbility;

    public String getSlidingAbility() {
        return slidingAbility;
    }

    public void setSlidingAbility(String slidingAbility) {
        this.slidingAbility = slidingAbility;
    }

    public Sled(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, String slidingAbility) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.slidingAbility = slidingAbility;
    }


}