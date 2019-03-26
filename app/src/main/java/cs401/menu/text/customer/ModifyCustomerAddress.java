package cs401.menu.text.customer;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.menu.MenuItem;

import java.util.Scanner;

/**
 * modify a customer's address only, called from {@link ModifyCustomer}
 * @author Neil Moon
 */
public class ModifyCustomerAddress implements MenuItem {

    private Customer customer;

    /**
     * modify the given customer
     * @param customer customer to modify
     */
    ModifyCustomerAddress(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        System.out.println("input the street address");
        String streetAddress = scanner.next();
        System.out.println("input the city address");
        String cityAddress = scanner.next();
        System.out.println("input the state address");
        String stateAddress = scanner.next();
        System.out.println("input the zip address");
        String zipAddress = scanner.next();
        Address address = new Address(streetAddress, cityAddress, stateAddress, zipAddress);
        modifyAddress(address);
    }

    /**
     * change the address of the customer in this class
     * @param address new address
     */
    private void modifyAddress(Address address) {
        customer.setAddress(address);
    }
}