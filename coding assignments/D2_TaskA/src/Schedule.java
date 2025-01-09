import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule {
    private ArrayList<Flight> flights;

    public Schedule() {
        this.flights = new ArrayList<>();
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

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
