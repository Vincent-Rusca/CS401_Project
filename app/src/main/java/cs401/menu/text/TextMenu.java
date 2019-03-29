package cs401.menu.text;

import cs401.Customers.CustomerList;
import cs401.menu.text.customer.AddCustomer;
import cs401.menu.text.customer.DeleteCustomer;
import cs401.menu.text.customer.DisplayCustomers;
import cs401.menu.text.customer.ModifyCustomer;
import cs401.menu.text.order.AddOrder;
import cs401.menu.text.order.DisplayOrders;
import cs401.menu.text.order.ModifyOrder;
import cs401.menu.text.order.RemoveOrder;
import cs401.menu.Menu;
import cs401.menu.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Text implementation of the menu interface
 * NOTE: the menu does not accept spaces for input due to strangeness with scanner's getLine
 * @author Neil Moon
 */
public class TextMenu implements Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private CustomerList customerList;
    private List<MenuItem> options;

    /**
     * initialize a new menu without any customers
     */
    public TextMenu() {
        customerList = new CustomerList();
        options = new ArrayList<>();
        options.addAll(Arrays.asList(new AddCustomer(), new ModifyCustomer(), new DeleteCustomer(), new DisplayCustomers(),
                new AddOrder(), new DisplayOrders(), new RemoveOrder(), new ModifyOrder()));
    }

    /**
     * initialize a new menu with predetermined customers
     * @param customerList the already existing customers
     */
    public TextMenu(CustomerList customerList) {
        this();
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
