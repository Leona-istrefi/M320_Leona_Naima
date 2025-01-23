package VehicleRental;

public class Boat extends WaterVehicle {
    String fishingEquipment;
    String food;

    public String getFishingEquipment() {
        return fishingEquipment;
    }

    public void setFishingEquipment(String fishingEquipment) {
        this.fishingEquipment = fishingEquipment;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Boat(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, int chanceOfSinking, String fishingEquipment, String food) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, chanceOfSinking);
        this.fishingEquipment = fishingEquipment;
        this.food = food;
    }

    @Override
    public String getVehicleInfo() {
        return super.getVehicleInfo() + " | Fishing Equipment: " + fishingEquipment + " | Food: " + food;
    }
}