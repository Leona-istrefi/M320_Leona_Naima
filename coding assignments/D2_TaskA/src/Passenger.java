public class Passenger {
    private String name;
    private String passportNumber;

    public Passenger(String name, String passportNumber) {
        setName(name);
        setPassportNumber(passportNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.matches("^[a-zA-Z ]+$")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name! Name must contain only letters and spaces.");
        }
    }

    public String getPassportNumber() {
        return passportNumber;
    }

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
