package cs401.menu.gui;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;

public class CustomerListStateManager {

    private static CustomerListStateManager instance;
    private static CustomerList customerList;

    private CustomerListStateManager() {
        customerList = new CustomerList();
    }

    public static CustomerListStateManager getInstance() {
        if (instance == null) {
            instance = new CustomerListStateManager();
        }
        return instance;
    }

    public CustomerList getCustomerList() {
        return customerList;
    }

    public Customer getCustomer(int index) {
        return customerList.getCustomerList().get(index);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer(int index) {
        customerList.remove(index);
    }

    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
    }

    public boolean isEmpty() {
        return customerList.getCustomerList().isEmpty();
    }
}
