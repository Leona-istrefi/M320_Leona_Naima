package VehicleRental;

import java.time.LocalDate;

public class Contract<T extends Vehicle> {
    private Person customer;
    private T vehicle; // Use a generic type for the vehicle
    private LocalDate startDate;
    private LocalDate endDate;
    private String terms;

    public Contract(Person customer, T vehicle, LocalDate startDate, LocalDate endDate, String terms) {
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

    public T getVehicle() { // Return the vehicle as the generic type
        return vehicle;
    }

    public void setVehicle(T vehicle) { // Accept the vehicle as the generic type
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

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }
}