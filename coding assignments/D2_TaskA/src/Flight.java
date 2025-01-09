import java.util.ArrayList;
import java.time.LocalDateTime;

public class Flight {
    private String flightNumber;
    private LocalDateTime dateTime;
    private ArrayList<Passenger> passengers;

    public Flight(String flightNumber, LocalDateTime dateTime) {
        this.flightNumber = flightNumber;
        this.dateTime = dateTime;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        for (Passenger p : passengers) {
            if (p.getPassportNumber().equals(passenger.getPassportNumber())) {
                System.out.println("Passenger with this passport number already exists.");
                return;
            }
        }
        passengers.add(passenger);
        System.out.println("Passenger added successfully!");
    }

    public void printPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers registered for flight " + flightNumber);
        } else {
            System.out.println("Passengers on flight " + flightNumber + ":");
            for (Passenger p : passengers) {
                System.out.println(p);
            }
        }
    }
}
