public class Main {
    // Attributes
    private int temperature;
    private int min;
    private int max;
    private int increment;

    // Constructor
    public Main(int initialTemperature, int min, int max, int increment) {
        this.temperature = initialTemperature;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }

    // Method to increase the temperature
    public void increaseTemperature() {
        if (temperature + increment <= max) {
            temperature += increment;
        } else {
            temperature = max;
        }
        System.out.println("Temperature increased to: " + temperature);
    }

    // Method to decrease the temperature
    public void decreaseTemperature() {
        if (temperature - increment >= min) {
            temperature -= increment;
        } else {
            temperature = min;
        }
        System.out.println("Temperature decreased to: " + temperature);
    }

    // Getter for temperature
    public int getTemperature() {
        return temperature;
    }

    public static void main(String[] args) {
        // Test class - Creating multiple heating objects
        Main heating1 = new Main(20, 10, 30, 2);
        Main heating2 = new Main(15, 5, 25, 3);

        // Testing heating1
        heating1.increaseTemperature(); // Should increase to 22
        heating1.decreaseTemperature(); // Should decrease to 20
        heating1.decreaseTemperature(); // Should decrease to 18

        // Testing heating2
        heating2.increaseTemperature(); // Should increase to 18
        heating2.increaseTemperature(); // Should increase to 21
        heating2.decreaseTemperature(); // Should decrease to 18
    }
}
