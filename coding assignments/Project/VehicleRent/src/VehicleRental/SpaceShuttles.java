package VehicleRental;

public class SpaceShuttles extends SpaceVehicle {
    private int walkieTalkie; // Shuttle-specific property

    public SpaceShuttles(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String airPressure, int walkieTalkie) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, airPressure);
        this.walkieTalkie = walkieTalkie;
    }

    public int getWalkieTalkie() {
        return walkieTalkie;
    }

    public void setWalkieTalkie(int walkieTalkie) {
        this.walkieTalkie = walkieTalkie;
    }
}
