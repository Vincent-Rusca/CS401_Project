package menu.text.customer;

import Customers.Address;
import Customers.Customer;
import menu.MenuItem;

import java.util.List;
import java.util.Scanner;

public class AddCustomer implements MenuItem {

    @Override
    public void display(Scanner scanner, List<Customer> customerList) {
        System.out.println("input the customer name");
        String customerName = scanner.next();
        System.out.println("input the customer id");
        int customerId =  scanner.nextInt();
        System.out.println("input the street address");
        String streetAddress = scanner.next();
        System.out.println("input the city address");
        String cityAddress = scanner.next();
        System.out.println("input the state address");
        String stateAddress = scanner.next();
        System.out.println("input the zip address");
        String zipAddress = scanner.next();
        Address customerAddress = new Address(streetAddress, cityAddress, stateAddress, zipAddress);
        Customer newCustomer = new Customer(customerName, customerId, customerAddress);
        // modifying the list here modifies it outside this function
        addCustomer(newCustomer, customerList);
    }

    void addCustomer(Customer customer, List<Customer> customerList) {
        customerList.add(customer);
    }
}
