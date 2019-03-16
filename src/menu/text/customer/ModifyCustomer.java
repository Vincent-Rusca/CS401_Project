package menu.text.customer;

import Customers.Customer;
import menu.MenuItem;
import menu.text.TextMenu;

import java.util.List;
import java.util.Scanner;

public class ModifyCustomer implements MenuItem {

    @Override
    public void display(Scanner scanner, List<Customer> customerList) {
        new DisplayCustomers().displayNames(customerList);
        System.out.println("input the customer to modify");
        Customer customer = customerList.remove(scanner.nextInt());
        System.out.println("1 - name");
        System.out.println("2 - id");
        System.out.println("3 - address");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("enter the new name");
                customer.setCustomerName(scanner.next());
                break;
            case 2:
                System.out.println("enter the new id");
                customer.setCustomerID(scanner.next());
                break;
            case 3:
                // TODO: break this off into something that follows oop better
                ModfiyCustomerAddress modfiyAddress = new ModfiyCustomerAddress();
                modfiyAddress.display(scanner, customerList);
                customer.setAddress(modfiyAddress.getNewAddress());
        }
        customerList.add(customer);
    }
}
