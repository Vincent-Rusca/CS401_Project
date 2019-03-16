package menu.text.order;

import Customers.Customer;
import Customers.CustomerList;
import Orders.OrderList;
import menu.MenuItem;
import menu.text.customer.DisplayCustomers;

import java.util.List;
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
