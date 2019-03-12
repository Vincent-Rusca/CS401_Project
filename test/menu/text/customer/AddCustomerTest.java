package menu.text.customer;

import Customers.Address;
import Customers.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddCustomerTest {

    @Test
    public void customerGetsAdded() {
        List<Customer> customerList = new ArrayList<>();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        Customer newCustomer = new Customer("name", 12, testAddress);
        new AddCustomer().addCustomer(newCustomer, customerList);
        assertEquals(1, customerList.size());
        assertEquals(newCustomer, customerList.get(0));
    }

}