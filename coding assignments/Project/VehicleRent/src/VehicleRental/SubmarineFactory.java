package VehicleRental;

public class SubmarineFactory implements WaterVehicleFactory {
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
    private int maximumDepth;
    private int windows;

    public SubmarineFactory(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, int chanceOfSinking, int maximumDepth, int windows) {
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
        this.maximumDepth = maximumDepth;
        this.windows = windows;
    }

    @Override
    public WaterVehicle createWaterVehicle() {
        return new Submarine(year, price, speed, ageApproval, seats, name, color, model, brand, chanceOfSinking, maximumDepth, windows);
    }
}