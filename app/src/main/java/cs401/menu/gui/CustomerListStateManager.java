package cs401.menu.gui;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;

/**
 * singleton class that manages a global customerlist
 * TODO: this class is bad style, should be removed in favor of SharedPreferences or the database
 */
public class CustomerListStateManager {

    private static CustomerListStateManager instance;
    private static CustomerList customerList;

    /**
     * create the instance, private to avoid outside calls (use getInstance instead)
     */
    private CustomerListStateManager() {
        customerList = new CustomerList();
    }

    /**
     * get the instance
     * @return the instance
     */
    public static CustomerListStateManager getInstance() {
        if (instance == null) {
            instance = new CustomerListStateManager();
        }
        return instance;
    }

    /**
     * get the globally managed customer list
     * @return the customer list
     */
    public CustomerList getCustomerList() {
        return customerList;
    }

    /**
     * get a customer from the list
     * @param index index to get
     * @return the customer at the index
     */
    public Customer getCustomer(int index) {
        return customerList.getCustomerList().get(index);
    }

    /**
     * add a customer to the list
     * @param customer customer to add
     */
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    /**
     * remove a customer from the list by index
     * @param index index of the customer to remove
     */
    public void removeCustomer(int index) {
        customerList.remove(index);
    }

    /**
     * remove a customer from the list by value
     * @param customer customer to remove
     */
    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
    }

    /**
     * check if the customer list is empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        return customerList.getCustomerList().isEmpty();
    }

    /**
     * empty the customer list
     */
    public void clearList() {
        customerList.getCustomerList().clear();
    }
}
