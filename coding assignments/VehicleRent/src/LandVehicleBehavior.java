public class LandVehicleBehavior implements TerrestrialAndAerialBehavior {
    private String terrainType;

    @Override
    public String getTerrainType() {
        return terrainType;
    }

    @Override
    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }


}