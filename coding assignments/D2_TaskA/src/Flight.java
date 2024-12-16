import java.util.ArrayList;

public class Flight {
    private String flightNumber;
    private ArrayList<Passenger> passengers;

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<>();
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }


    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void printPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers registered for flight " + flightNumber);
        } else {
            System.out.println("Passengers on flight " + flightNumber + ":");
            for (Passenger p : passengers) {
                System.out.println(p.getName());
            }
        }
    }
}
