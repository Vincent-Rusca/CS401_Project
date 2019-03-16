package menu.text.customer;

import Customers.CustomerList;
import menu.MenuItem;

import java.util.Scanner;

/**
 * display all customers in the customer list
 * @author Neil Moon
 */
public class DisplayCustomers implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        for (int i = 0; i < customerList.getCustomerList().size(); ++i) {
            System.out.println(i + " - customer name: " + customerList.getCustomerList().get(i).getCustomerName());
            System.out.println(i + " - customer id: " + customerList.getCustomerList().get(i).getCustomerID());
            System.out.println(i + " - customer address: " + customerList.getCustomerList().get(i).getAddress());
        }
    }

    /**
     * display a shorter list of customers, using only their names
     * @param customerList list to display
     */
    public static void displayNames(CustomerList customerList) {
        for (int i = 0; i < customerList.getCustomerList().size(); ++i) {
            System.out.println(i + " - " + customerList.getCustomerList().get(i).getCustomerName());
        }
    }
}
