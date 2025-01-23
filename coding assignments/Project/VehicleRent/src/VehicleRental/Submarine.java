package VehicleRental;

public class Submarine extends WaterVehicle {
    int maximumDepth;
    int windows;

    public int getMaximumDepth() {
        return maximumDepth;
    }

    public void setMaximumDepth(int maximumDepth) {
        this.maximumDepth = maximumDepth;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public Submarine(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, int chanceOfSinking, int maximumDepth, int windows) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, chanceOfSinking);
        this.maximumDepth = maximumDepth;
        this.windows = windows;
    }

    @Override
    public String getVehicleInfo() {
        return super.getVehicleInfo() + " | Maximum Depth: " + maximumDepth + " meters | Windows: " + windows;
    }
}