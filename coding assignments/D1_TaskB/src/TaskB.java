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
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }
        this.temperature = initialTemperature;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }

    // Method to increase the temperature
    public void increaseTemperature() {
        int newTemperature = temperature + increment;
        if (newTemperature <= max) {
            setTemperature(newTemperature);
        } else {
            setTemperature(max);
        }
        System.out.println("Temperature increased to: " + temperature);
    }

    // Method to decrease the temperature
    public void decreaseTemperature() {
        int newTemperature = temperature - increment;
        if (newTemperature >= min) {
            setTemperature(newTemperature);
        } else {
            setTemperature(min);
        }
        System.out.println("Temperature decreased to: " + temperature);
    }


    // Getter and setter for temperature
    public int getTemperature() {
        return temperature;
    }

    // Setter for Temparature
    public void setTemperature(int temperature) {
        if (temperature < min || temperature > max) {
            throw new IllegalArgumentException("Temperature must be within the range of min and max");
        }
        this.temperature = temperature;
    }
}
}
