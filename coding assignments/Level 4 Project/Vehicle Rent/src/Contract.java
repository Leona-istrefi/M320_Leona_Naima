import java.time.LocalDate;

public class Contract {
    private Person customer;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private String terms;

    public Contract(Person customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate, String terms) throws Exception {
        if (customer == null || vehicle == null || startDate == null || endDate == null || terms == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.terms = terms;
    }



    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


}