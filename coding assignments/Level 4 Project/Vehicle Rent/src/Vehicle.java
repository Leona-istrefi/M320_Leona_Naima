
public class Vehicle {
    private int year;
    private int price;
    private int speed;
    private int ageApproval;
    private int seats;
    private String name;
    private String color;
    private String model;
    private String brand;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAgeApproval() {
        return ageApproval;
    }

    public void setAgeApproval(int ageApproval) {
        this.ageApproval = ageApproval;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Vehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand) {
        this.year = year;
        this.price = price;
        this.speed = speed;
        this.ageApproval = ageApproval;
        this.seats = seats;
        this.name = name;
        this.color = color;
        this.model = model;
        this.brand = brand;
    }
}