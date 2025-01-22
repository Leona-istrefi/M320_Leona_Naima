public class AirVehicle extends Vehicle{
    String driveSystem; // Fernsteuerung
    String securitySystem;
    String navigationSystem;
    int seats;

    public String getDriveSystem() {
        return driveSystem;
    }

    public void setDriveSystem(String driveSystem) {
        this.driveSystem = driveSystem;
    }

    public String getSecuritySystem() {
        return securitySystem;
    }

    public void setSecuritySystem(String securitySystem) {
        this.securitySystem = securitySystem;
    }

    public String getNavigationSystem() {
        return navigationSystem;
    }

    public void setNavigationSystem(String navigationSystem) {
        this.navigationSystem = navigationSystem;
    }



    public AirVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String driveSystem, String securitySystem, String navigationSystem, int seats1) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.driveSystem = driveSystem;
        this.securitySystem = securitySystem;
        this.navigationSystem = navigationSystem;
        this.seats = seats1;
    }
}
