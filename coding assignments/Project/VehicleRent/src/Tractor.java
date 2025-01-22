public class Tractor extends LandVehicle{
    int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Tractor(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, int height) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.height = height;
    }


}