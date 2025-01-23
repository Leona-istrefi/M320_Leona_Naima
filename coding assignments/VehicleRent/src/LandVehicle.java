public class LandVehicle extends Vehicle {
    private TerrestrialAndAerialBehavior behavior;

    public LandVehicle(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String terrainType) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand);
        this.behavior = new LandVehicleBehavior();
        this.behavior.setTerrainType(terrainType);
    }

    public String getTerrainType() {
        return behavior.getTerrainType();
    }

    public void setTerrainType(String terrainType) {
        behavior.setTerrainType(terrainType);
    }
}