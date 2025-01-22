import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleRentalManager {
    private List<Person> customerList;
    private List<Person> denylist;
    private List<Vehicle> vehicles;
    private List<Contract> contracts;

    public VehicleRentalManager() {
        this.customerList = new ArrayList<>();
        this.denylist = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.contracts = new ArrayList<>();
        System.out.println("\n" +
                "██╗   ██╗███████╗██╗  ██╗██╗ ██████╗██╗     ███████╗    ██████╗ ███████╗███╗   ██╗████████╗\n" +
                "██║   ██║██╔════╝██║  ██║██║██╔════╝██║     ██╔════╝    ██╔══██╗██╔════╝████╗  ██║╚══██╔══╝\n" +
                "██║   ██║█████╗  ███████║██║██║     ██║     █████╗      ██████╔╝█████╗  ██╔██╗ ██║   ██║   \n" +
                "╚██╗ ██╔╝██╔══╝  ██╔══██║██║██║     ██║     ██╔══╝      ██╔══██╗██╔══╝  ██║╚██╗██║   ██║   \n" +
                " ╚████╔╝ ███████╗██║  ██║██║╚██████╗███████╗███████╗    ██║  ██║███████╗██║ ╚████║   ██║   \n" +
                "  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝ ╚═════╝╚══════╝╚══════╝    ╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   \n" +
                "                                                                                           \n");


    }

    public void addPersonToDenylist(Person person) {
        if (!denylist.contains(person)) {
            denylist.add(person);
        } else {
            System.out.println(person.getName());
        }
    }

    public void createContract(Person customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate, String terms) {
        try {
            Contract contract = new Contract(customer, vehicle, startDate, endDate, terms);
            contracts.add(contract);
            System.out.println("\nContract created:");
            System.out.println("Customer: " + customer.getName());
            System.out.println("Vehicle: " + vehicle.getName());
            System.out.println("Rental period: " + startDate + " to " + endDate);
        } catch (Exception e) {
            System.err.println("Error creating contract: " + e.getMessage());
        }
    }

    public void addCustomer(Person customer) {
        if (!customerList.contains(customer)) {
            customerList.add(customer);
        }
    }

    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
        }
    }

    public List<Person> getCustomerList() {
        return customerList;
    }

    public List<Person> getDenylist() {
        return denylist;
    }



    public List<Contract> getContracts() {
        return contracts;
    }

    public List<Vehicle> getVehiclesByType(Class<? extends Vehicle> type) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (type.isInstance(vehicle)) {
                result.add(vehicle);
            }
        }
        return result;
    }
}