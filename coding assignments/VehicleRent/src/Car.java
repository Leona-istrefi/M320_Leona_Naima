public class Car extends LandVehicle{
    int thermalBlankets;
    int Radio;



    public int getThermalBlankets() {
        return thermalBlankets;
    }

    public void setThermalBlankets(int thermalBlankets) {
        this.thermalBlankets = thermalBlankets;
    }

    public int getRadio() {
        return Radio;
    }

    public void setRadio(int radio) {
        Radio = radio;
    }

    public Car(int year, int price, int speed, int ageApproval, int seats, String name, String color, String model, String brand, String highWayApproval, int thermalBlankets, int radio) {
        super(year, price, speed, ageApproval, seats, name, color, model, brand, highWayApproval);
        this.thermalBlankets = thermalBlankets;
        Radio = radio;
    }
}