package VehicleRental;

public class Train extends LandVehicle {
    int restaurant;
    int toilets;

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

    public int getToilets() {
        return toilets;
    }

    public void setToilets(int toilets) {
        this.toilets = toilets;
    }

    public Train(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, int restaurant, int toilets) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.restaurant = restaurant;
        this.toilets = toilets;
    }


}