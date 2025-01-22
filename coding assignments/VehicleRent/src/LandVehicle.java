public class LandVehicle extends Vehicle{
    String highWayApproval;

    public String getHighWayApproval() {
        return highWayApproval;
    }

    public void setHighWayApproval(String highWayApproval) {
        this.highWayApproval = highWayApproval;
    }

    public LandVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.highWayApproval = highWayApproval;
    }
}