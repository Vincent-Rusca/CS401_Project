package menu.text.customer;

import Customers.Address;
import Customers.Customer;
import menu.MenuItem;

import java.util.List;
import java.util.Scanner;

public class ModfiyCustomerAddress implements MenuItem {

    private Address address;

    @Override
    public void display(Scanner scanner, List<Customer> customerList) {
        System.out.println("input the street address");
        String streetAddress = scanner.nextLine();
        System.out.println("input the city address");
        String cityAddress = scanner.nextLine();
        System.out.println("input the state address");
        String stateAddress = scanner.nextLine();
        System.out.println("input the zip address");
        String zipAddress = scanner.nextLine();
        address = new Address(streetAddress, cityAddress, stateAddress, zipAddress);
        modifyAddress(address);
    }

    void modifyAddress(Address address) {
        this.address = address;
    }

    Address getNewAddress() {
        return address;
    }
}
