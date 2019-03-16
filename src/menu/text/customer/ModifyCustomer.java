package menu.text.customer;

import Customers.Customer;
import Customers.CustomerList;
import menu.MenuItem;

import java.util.Scanner;

/**
 * modify a customer
 * @author Neil Moon
 */
public class ModifyCustomer implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        DisplayCustomers.displayNames(customerList);
        System.out.println("input the customer to modify");
        Customer customer = customerList.getCustomerList().get(scanner.nextInt());
        customerList.remove(customer);
        System.out.println("1 - name");
        System.out.println("2 - id");
        System.out.println("3 - address");
        System.out.println("input the part of the customer to modify");
        int input = scanner.nextInt();
        modify(scanner, customer, customerList, input);
        customerList.add(customer);
    }

    /**
     * modify a value of the given customer
     * @param scanner scanner to get input from
     * @param customer customer to modify
     * @param customerList list containing the customer
     * @param input the choice of what to modify
     */
    private void modify(Scanner scanner, Customer customer, CustomerList customerList, int input) {
        switch (input) {
            case 1:
                System.out.println("enter the new name");
                customer.setCustomerName(scanner.nextLine());
                break;
            case 2:
                System.out.println("enter the new id");
                customer.setCustomerID(scanner.nextLine());
                break;
            case 3:
                // TODO: break this off into something more consistent that follows oop better
                ModifyCustomerAddress modfiyAddress = new ModifyCustomerAddress(customer);
                modfiyAddress.display(scanner, customerList);
        }
    }
}
