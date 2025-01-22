public class Bus extends LandVehicle{
    int spareWheels;
    int doors;

    public int getSpareWheels() {
        return spareWheels;
    }

    public void setSpareWheels(int spareWheels) {
        this.spareWheels = spareWheels;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public Bus(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, int spareWheels, int doors) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.spareWheels = spareWheels;
        this.doors = doors;
    }
}
