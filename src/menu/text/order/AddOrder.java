package menu.text.order;

import Customers.Customer;
import Orders.Order;
import menu.MenuItem;
import menu.text.customer.DisplayCustomers;

import java.util.List;
import java.util.Scanner;

/**
 * add an order to a customer
 * @author Neil Moon
 */
public class AddOrder implements MenuItem {

    @Override
    public void display(Scanner scanner, List<Customer> customerList) {
        new DisplayCustomers().displayNames(customerList);
        System.out.println("input the customer to add an order to");
        int customer = scanner.nextByte();
        System.out.println("enter the item to order");
        scanner.skip("\n");
        String item = scanner.nextLine();
        System.out.println("enter the cost of the item");
        double cost = scanner.nextDouble();
        System.out.println("enter the quantity of the item");
        int quantity = scanner.nextInt();
        System.out.println("enter the invoice number");
        int invoice = scanner.nextInt();
        System.out.println("enter the item's description");
        scanner.skip("\n");
        String description = scanner.nextLine();
        Order order = new Order(item, cost, quantity, invoice, description);
        addOrder(customerList, customer, order);
    }

    void addOrder(List<Customer> customerList, int customerChoice, Order order) {
        Customer customer = customerList.get(customerChoice);
        customerList.remove(customerChoice);
        customer.addToOrderList(order);
        customerList.add(customer);
    }
}
