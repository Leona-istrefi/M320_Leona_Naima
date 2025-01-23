package VehicleRental;

public class WaterVehicle extends Vehicle {
    int chanceOfSinking;

    public int getChanceOfSinking() {
        return chanceOfSinking;
    }

    public void setChanceOfSinking(int chanceOfSinking) {
        this.chanceOfSinking = chanceOfSinking;
    }

    public WaterVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, int chanceOfSinking) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.chanceOfSinking = chanceOfSinking;
    }


    @Override
    public String getVehicleInfo() {
        return "Water vehicleRental.Vehicle: " + getName() + " (" + getModel() + ")";
    }
}