package VehicleRental;

public class BoatFactory implements WaterVehicleFactory {
    private int year;
    private int price;
    private int speed;
    private int ageApproval;
    private int seats;
    private String name;
    private String color;
    private String model;
    private String brand;
    private int chanceOfSinking;
    private String fishingEquipment;
    private String food;

    public BoatFactory(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, int chanceOfSinking, String fishingEquipment, String food) {
        this.year = year;
        this.price = price;
        this.speed = speed;
        this.ageApproval = ageApproval;
        this.seats = seats;
        this.name = name;
        this.color = color;
        this.model = model;
        this.brand = brand;
        this.chanceOfSinking = chanceOfSinking;
        this.fishingEquipment = fishingEquipment;
        this.food = food;
    }

    @Override
    public WaterVehicle createWaterVehicle() {
        return new Boat(year, price, speed, ageApproval, seats, name, color, model, brand, chanceOfSinking, fishingEquipment, food);
    }
}