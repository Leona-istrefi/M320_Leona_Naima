package VehicleRental;

/**
 * Represents the behavior of air vehicles in terms of their operational characteristics.
 * This class implements the TerrestrialAndAerialBehavior interface and manages
 * attributes related to the terrain type, which denotes takeoff and landing areas.
 */
public class AirVehicleBehavior implements TerrestrialAndAerialBehavior {
    private String terrainType; // The type of terrain for takeoff and landing areas

    /**
     * Retrieves the terrain type for the air vehicle's behavior.
     *
     * @return A string representing the terrain type.
     */
    @Override
    public String getTerrainType() {
        return terrainType;
    }

    /**
     * Sets the terrain type for the air vehicle's behavior.
     *
     * @param terrainType A string representing the terrain type to be set.
     */
    @Override
    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }
}