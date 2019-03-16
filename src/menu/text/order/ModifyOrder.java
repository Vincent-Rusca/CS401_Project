package menu.text.order;

import Customers.Customer;
import Customers.CustomerList;
import Orders.Order;
import menu.MenuItem;
import menu.text.customer.DisplayCustomers;

import java.util.Scanner;

/**
 * modify an order
 * @author Neil Moon
 */
public class ModifyOrder implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        DisplayCustomers.displayNames(customerList);
        System.out.println("input the customer to modify");
        Customer customer = customerList.getCustomerList().get(scanner.nextInt());
        customer.getOrderList().showOrders();
        System.out.println("input the name of the order to modify");
        String orderName = scanner.next();
        Order order = customer.getOrderList().getOrderbyName(orderName);
        customer.getOrderList().removeByName(orderName);
        System.out.println("1 - description");
        System.out.println("2 - invoice number");
        System.out.println("3 - quantity");
        System.out.println("4 - cost");
        System.out.println("5 - name");
        int input = scanner.nextInt();
        modify(scanner, input, order);
        customer.getOrderList().addOrder(order);
    }

    /**
     * modify the given order
     * @param scanner scanner to get input from
     * @param input parameter to change
     * @param order order to modify
     */
    private void modify(Scanner scanner, int input, Order order) {
        // note: changing the date the order was placed wouldn't make sense here
        switch (input) {
            case 1:
                order.setDescription(scanner.next());
                break;
            case 2:
                order.setInvoiceNumber(scanner.nextInt());
                break;
            case 3:
                order.setQuantity(scanner.nextInt());
                break;
            case 4:
                order.setCost(scanner.nextDouble());
                break;
            case 5:
                order.setItemName(scanner.next());
                break;
        }
    }
}
