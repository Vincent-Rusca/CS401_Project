package cs401.menu;

import cs401.Customers.CustomerList;

import java.util.Scanner;

/**
 * a menu item is a submenu of another menu
 * @author Neil Moon
 */
public interface MenuItem {

    /**
     * display this submenu
     * @param scanner scanner for input
     * @param customerList existing list of customers
     */
    void display(Scanner scanner, CustomerList customerList);
}
