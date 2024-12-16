public class Passenger {
    private String name;

    public Passenger(String name) {
        setName(name);
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

    @Override
    public String toString() {
        return "Passenger Name: " + name;
    }
}
