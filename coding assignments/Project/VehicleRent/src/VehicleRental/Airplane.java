package VehicleRental;

public class Airplane extends AirVehicle {
    String foodService;
    int oxygenMask;

    public String getFoodService() {
        return foodService;
    }

    public void setFoodService(String foodService) {
        this.foodService = foodService;
    }

    public int getOxygenMask() {
        return oxygenMask;
    }

    public void setOxygenMask(int oxygenMask) {
        this.oxygenMask = oxygenMask;
    }

    public Airplane(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String driveSystem, String securitySystem, String navigationSystem, String foodService, int oxygenMask) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, driveSystem, securitySystem, navigationSystem, foodService);
        this.foodService = foodService;
        this.oxygenMask = oxygenMask;
    }
}