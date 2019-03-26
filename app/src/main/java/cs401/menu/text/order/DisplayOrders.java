package cs401.menu.text.order;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.menu.text.customer.DisplayCustomers;
import cs401.menu.MenuItem;

import java.util.Scanner;

/**
 * display a list of all orders
 * @author Neil Moon
 */
public class DisplayOrders implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        DisplayCustomers.displayNames(customerList);
        System.out.println("enter the customer to look at the orders of");
        int customerSelection = scanner.nextInt();
        Customer customer = customerList.getCustomerList().get(customerSelection);
        customer.getOrderList().showOrders();
    }
}
