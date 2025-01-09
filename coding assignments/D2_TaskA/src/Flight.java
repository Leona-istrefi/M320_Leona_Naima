import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Represents a flight with a flight number, date/time, and a list of passengers.
 */
public class Flight {
    private String flightNumber;
    private LocalDateTime dateTime;
    private ArrayList<Passenger> passengers;

    /**
     * Constructs a Flight with a flight number and scheduled date/time.
     *
     * @param flightNumber the flight number
     * @param dateTime     the scheduled date/time of the flight
     */
    public Flight(String flightNumber, LocalDateTime dateTime) {
        this.flightNumber = flightNumber;
        this.dateTime = dateTime;
        this.passengers = new ArrayList<>();
    }

    /**
     * Gets the flight number.
     *
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the flight number.
     *
     * @param flightNumber the flight number to set
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Gets the date and time of the flight.
     *
     * @return the flight's scheduled date and time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the flight.
     *
     * @param dateTime the date and time to set
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Adds a passenger to the flight.
     * Ensures no duplicate passengers are added based on passport number.
     *
     * @param passenger the passenger to add
     */
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

    /**
     * Prints all passengers on the flight.
     */
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
