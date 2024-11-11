public class TaskB {
    // Attributes
    private int temperature;
    private int min;
    private int max;
    private int increment;

    // Constructor with default temperature value
    public TaskB(int min, int max, int increment) {
        this(15, min, max, increment); // Default temperature is set to 15
    }

    // Constructor with specified initial temperature
    public TaskB(int initialTemperature, int min, int max, int increment) {
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
}

