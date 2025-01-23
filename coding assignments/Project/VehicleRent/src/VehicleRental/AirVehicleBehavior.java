package VehicleRental;

public class AirVehicleBehavior implements TerrestrialAndAerialBehavior {
    private String terrainType; // Although not typical for air vehicles, it can denote takeoff/landing areas.

    @Override
    public String getTerrainType() {
        return terrainType;
    }

    @Override
    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }


}