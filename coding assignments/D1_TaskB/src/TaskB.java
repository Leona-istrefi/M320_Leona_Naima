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
        if (temperature < min || temperature > max) {
            throw new IllegalArgumentException("Temperature must be within the range of min and max");
        }
        this.temperature = temperature;
    }

    // Getter and setter for min
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }
        this.min = min;
    }

    // Getter and setter for max
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        if (max < min) {
            throw new IllegalArgumentException("Max cannot be less than Min");
        }
        this.max = max;
    }

    // Getter and setter for increment
    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        if (increment <= 0) {
            throw new IllegalArgumentException("Increment must be greater than zero");
        }
        this.increment = increment;
    }
}
