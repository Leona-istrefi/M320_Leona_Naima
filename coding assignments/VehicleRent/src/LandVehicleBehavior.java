public class LandVehicleBehavior implements VehicleBehavior {
    private String highWayApproval;

    @Override
    public String getHighWayApproval() {
        return highWayApproval;
    }

    @Override
    public void setHighWayApproval(String highWayApproval) {
        this.highWayApproval = highWayApproval;
    }

}