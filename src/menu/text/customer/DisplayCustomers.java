package menu.text.customer;

import Customers.Customer;
import menu.MenuItem;

import java.util.List;
import java.util.Scanner;

/**
 * display all customers in the customer list
 * @author Neil Moon
 */
public class DisplayCustomers implements MenuItem {

    @Override
    public void display(Scanner scanner, List<Customer> customerList) {
        for (int i = 0; i < customerList.size(); ++i) {
            System.out.println(i + " - customer name: " + customerList.get(i).getCustomerName());
            System.out.println(i + " - customer id: " + customerList.get(i).getCustomerID());
            System.out.println(i + " - customer address: " + customerList.get(i).getAddress());
        }
    }

    public void displayNames(List<Customer> customerList) {
        for (int i = 0; i < customerList.size(); ++i) {
            System.out.println(i + " - " + customerList.get(i).getCustomerName());
        }
    }
}
