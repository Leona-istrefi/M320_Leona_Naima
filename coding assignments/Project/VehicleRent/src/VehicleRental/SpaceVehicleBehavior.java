package VehicleRental;

public class SpaceVehicleBehavior implements VehicleBehavior {
    private String airPressure;

    @Override
    public String getAirPressure() {
        return airPressure;
    }

    @Override
    public void setAirPressure(String airPressure) {
        this.airPressure = airPressure;
    }
}
