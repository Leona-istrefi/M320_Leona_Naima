package VehicleRental;

public class SpaceVehicleBehavior implements VehicleBehavior {
    private String AirPressure;
    @Override
    public String getAirPressure() {
        return AirPressure;
    }
    @Override
    public void setAirPressure(String AirPressure) {
        this.AirPressure = AirPressure;
    }
}