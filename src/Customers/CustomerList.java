// Vincent Rusca

package Customers;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {
    List<Customer> customerList;

    // constructors
    public CustomerList() {
        customerList = new ArrayList<>();
    }
    public CustomerList(List<Customer> _customerList) {
        customerList = _customerList;
    }

    // search functions - these will return null if customer does not exist
    public Customer searchByName(String _customerName) {
        for (Customer customer : customerList) {
            if (customer.getCustomerName() == _customerName)
                return customer;
        }
        return null;
    }
    public Customer searchByID (int _customerID) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID() == _customerID)
                return customer;
        }
        return null;
    }

    // more functionality as needed...
}
