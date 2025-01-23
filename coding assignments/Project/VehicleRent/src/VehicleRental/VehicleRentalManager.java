package VehicleRental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VehicleRentalManager {

    private static final Logger LOGGER = Logger.getLogger(VehicleRentalManager.class.getName());
    private List<Person> customerList;
    private List<Person> denylist;
    private List<Vehicle> vehicles;
    private List<Contract> contracts;

    public VehicleRentalManager() {
        this.customerList = new ArrayList<>();
        this.denylist = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.contracts = new ArrayList<>();
        LOGGER.info("""
        ██╗   ██╗███████╗██╗  ██╗██╗ ██████╗██╗     ███████╗    ██████╗ ███████╗███╗   ██╗████████╗
        ██║   ██║██╔════╝██║  ██║██║██╔════╝██║     ██╔════╝    ██╔══██╗██╔════╝████╗  ██║╚══██╔══╝
        ██║   ██║█████╗  ███████║██║██║     ██║     █████╗      ██████╔╝█████╗  ██╔██╗ ██║   ██║   
        ╚██╗ ██╔╝██╔══╝  ██╔══██║██║██║     ██║     ██╔══╝      ██╔══██╗██╔══╝  ██║╚██╗██║   ██║   
         ╚████╔╝ ███████╗██║  ██║██║╚██████╗███████╗███████╗    ██║  ██║███████╗██║ ╚████║   ██║   
          ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝ ╚═════╝╚══════╝╚══════╝    ╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   
                                                                                                   
        """);

    }

    public void addPersonToDenylist(Person person) {
        if (!denylist.contains(person)) {
            denylist.add(person);
        } else {
            LOGGER.info(person.getName() + " is already on the deny list.");
        }
    }

    public void createContract(Person customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate, String terms) {
        try {
            Contract contract = new Contract(customer, vehicle, startDate, endDate, terms);
            contracts.add(contract);
            LOGGER.info("\nvehicleRental.Contract created:");
            LOGGER.info("Customer: " + customer.getName());
            LOGGER.info("vehicleRental.Vehicle: " + vehicle.getName());
            LOGGER.info("Rental period: " + startDate + " to " + endDate);
        } catch (Exception e) {
            LOGGER.info("Error creating contract: " + e.getMessage());
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


    public boolean isCustomerDenied(Person customer) {
        return denylist.contains(customer);
    }
}