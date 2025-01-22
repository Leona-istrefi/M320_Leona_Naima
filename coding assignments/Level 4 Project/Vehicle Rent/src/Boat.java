public class Boat extends WaterVehicle{
    String fishingEquipment;
    String Food;

    public String getFishingEquipment() {
        return fishingEquipment;
    }

    public void setFishingEquipment(String fishingEquipment) {
        this.fishingEquipment = fishingEquipment;
    }

    public String getFood() {
        return Food;
    }

    public void setFood(String food) {
        Food = food;
    }

    public Boat(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, int chanceOfSinking, String fishingEquipment, String food) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, chanceOfSinking);
        this.fishingEquipment = fishingEquipment;
        Food = food;
    }
}
