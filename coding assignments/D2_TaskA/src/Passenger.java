/**
 * Represents a passenger with a name and a passport number.
 */
public class Passenger {
    private String name;
    private String passportNumber;

    /**
     * Constructs a Passenger with a name and passport number.
     *
     * @param name           the passenger's name
     * @param passportNumber the passenger's passport number
     */
    public Passenger(String name, String passportNumber) {
        setName(name);
        setPassportNumber(passportNumber);
    }

    /**
     * Gets the name of the passenger.
     *
     * @return the name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the passenger.
     *
     * @param name the name to set, must contain only letters and spaces
     * @throws IllegalArgumentException if the name is invalid
     */
    public void setName(String name) {
        if (name.matches("^[a-zA-Z ]+$")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name! Name must contain only letters and spaces.");
        }
    }

    /**
     * Gets the passport number of the passenger.
     *
     * @return the passport number of the passenger
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Sets the passport number of the passenger.
     *
     * @param passportNumber the passport number to set
     * @throws IllegalArgumentException if the passport number is invalid
     */
    public void setPassportNumber(String passportNumber) {
        if (passportNumber.matches("^[A-Z0-9]+$")) {
            this.passportNumber = passportNumber;
        } else {
            throw new IllegalArgumentException("Invalid passport number!");
        }
    }

    @Override
    public String toString() {
        return "Passenger Name: " + name + ", Passport Number: " + passportNumber;
    }
}
