package menu.text;

import Customers.Customer;
import menu.Menu;
import menu.MenuItem;
import menu.text.customer.AddCustomer;
import menu.text.customer.DeleteCustomer;
import menu.text.customer.DisplayCustomers;
import menu.text.customer.ModifyCustomer;
import menu.text.order.AddOrder;
import menu.text.order.DisplayOrders;
import menu.text.order.ModifyOrder;
import menu.text.order.RemoveOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Text implementation of the menu interface
 * @author Neil Moon
 */
public class TextMenu implements Menu {

    private static final Scanner scanner = new Scanner(System.in);
    // TODO: use a CustomerList class once it gets new features (such as list.get)
    private List<Customer> customerList;
    private List<MenuItem> options;

    /**
     * initialize a new menu without any customers
     */
    public TextMenu() {
        customerList = new ArrayList<>();
        options = new ArrayList<>();
        options.addAll(Arrays.asList(new AddCustomer(), new ModifyCustomer(), new DeleteCustomer(), new DisplayCustomers(),
                new AddOrder(), new DisplayOrders(), new RemoveOrder(), new ModifyOrder()));
    }

    /**
     * initialize a new menu with predetermined customers
     * @param customerList the already existing customers
     */
    public TextMenu(List<Customer> customerList) {
        super();
        this.customerList = customerList;
    }



    /**
     * start running the menu
     */
    @Override
    public void start() {
        byte input = -1;
        while (input != 9) {
            System.out.println("0 - add a customer");
            System.out.println("1 - modify a customer");
            System.out.println("2 - delete a customer");
            System.out.println("3 - display customers");
            System.out.println("4 - add an order to a customer");
            System.out.println("5 - display a customer's orders");
            System.out.println("6 - remove an order from a customer");
            System.out.println("7 - modify a customer's order");
            System.out.println("9 - exit");
            input = scanner.nextByte();
            if (input >= options.size()) {
                continue;
            }
            options.get(input).display(scanner, customerList);
        }
    }
}
