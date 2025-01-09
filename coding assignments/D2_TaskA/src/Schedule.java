import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Represents a flight schedule with a list of flights.
 */
public class Schedule {
    private ArrayList<Flight> flights;

    /**
     * Constructs a Schedule with an empty list of flights.
     */
    public Schedule() {
        this.flights = new ArrayList<>();
    }

    /**
     * Gets the list of flights.
     *
     * @return the list of flights
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    /**
     * Adds a flight to the schedule.
     *
     * @param flight the flight to add
     */
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    /**
     * Finds a flight by its flight number.
     *
     * @param flightNumber the flight number to search for
     * @return the flight if found, or null if not found
     */
    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    /**
     * Prints all flights in the schedule, including their date/time.
     */
    public void printAllFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights in the schedule.");
        } else {
            System.out.println("Scheduled Flights:");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            for (Flight flight : flights) {
                System.out.println("Flight Number: " + flight.getFlightNumber() +
                        ", Time: " + flight.getDateTime().format(formatter));
            }
        }
    }
}
