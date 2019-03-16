package menu.text.customer;

import Customers.CustomerList;
import menu.MenuItem;

import java.util.Scanner;

public class DeleteCustomer implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        DisplayCustomers.displayNames(customerList);
        System.out.println("input the customer to delete");
        int customer = scanner.nextInt();
        deleteCustomer(customer, customerList);
    }

    private void deleteCustomer(int customer, CustomerList customerList) {
        customerList.remove(customerList.getCustomerList().get(customer));
    }
}
