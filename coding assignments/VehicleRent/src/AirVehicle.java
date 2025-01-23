public class AirVehicle extends Vehicle {
    private String driveSystem;
    private String securitySystem;
    private String navigationSystem;
    private int seats;
    private TerrestrialAndAerialBehavior behavior;

    public AirVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String driveSystem, String securitySystem, String navigationSystem, String terrainType) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.driveSystem = driveSystem;
        this.securitySystem = securitySystem;
        this.navigationSystem = navigationSystem;
        this.seats = seats;
        this.behavior = new AirVehicleBehavior(); // Assuming you create this behavior class
        this.behavior.setTerrainType(terrainType);
    }

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

    public String getTerrainType() {
        return behavior.getTerrainType();
    }

    public void setTerrainType(String terrainType) {
        behavior.setTerrainType(terrainType);
    }
}