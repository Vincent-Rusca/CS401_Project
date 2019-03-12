package menu.text.customer;

import Customers.Customer;
import menu.MenuItem;

import java.util.List;
import java.util.Scanner;

public class DeleteCustomer implements MenuItem {

    @Override
    public void display(Scanner scanner, List<Customer> customerList) {
        new DisplayCustomers().displayNames(customerList);
        System.out.println("input the customer to delete");
        int customer = scanner.nextInt();
        deleteCustomer(customer, customerList);
    }

    void deleteCustomer(int customer, List<Customer> customerList) {
        customerList.remove(customer);
    }
}
