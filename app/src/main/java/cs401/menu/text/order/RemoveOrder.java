package cs401.menu.text.order;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.menu.text.customer.DisplayCustomers;
import cs401.menu.MenuItem;

import java.util.Scanner;

/**
 * remove an order from the customer
 * @author Neil Moon
 */
public class RemoveOrder implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        DisplayCustomers.displayNames(customerList);
        System.out.println("input the customer to modify");
        Customer customer = customerList.getCustomerList().get(scanner.nextInt());
        customer.getOrderList().showOrders();
        System.out.println("input the name of the order to remove");
        customer.getOrderList().removeByName(scanner.next());
    }
}
