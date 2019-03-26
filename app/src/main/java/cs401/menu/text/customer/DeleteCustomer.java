package cs401.menu.text.customer;

import cs401.Customers.CustomerList;
import cs401.menu.MenuItem;

import java.util.Scanner;

/**
 * delete a customer
 * @author Neil Moon
 */
public class DeleteCustomer implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        DisplayCustomers.displayNames(customerList);
        System.out.println("input the customer to delete");
        int customer = scanner.nextInt();
        deleteCustomer(customer, customerList);
    }

    /**
     * remove the customer from the list
     * @param customer number of the customer to remove
     * @param customerList list to remove from
     */
    private void deleteCustomer(int customer, CustomerList customerList) {
        customerList.remove(customerList.getCustomerList().get(customer));
    }
}
