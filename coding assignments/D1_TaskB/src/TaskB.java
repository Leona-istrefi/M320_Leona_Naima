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

    // Getter and setter for temperature
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    // Getter and setter for min
    public void setMin(int min) {
        this.min = min;
    }

    public void getMin(int min) {
        this.min = min;
    }


    // Getter and setter for max
    public void setMax(int max) {
        this.max = max;
    }

    public void getMax(int max) {
        this.max = max;
    }

    // Getter and setter for increment
    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public void getIncrement(int increment) {
        this.increment = increment;
    }
}

