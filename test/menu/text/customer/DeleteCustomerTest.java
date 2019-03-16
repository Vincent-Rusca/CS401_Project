package menu.text.customer;

import Customers.Address;
import Customers.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeleteCustomerTest {

    List<Customer> customerList;
    Customer newCustomer;
    Customer newCustomer2;

    @Before
    public void setUp() {
        customerList = new ArrayList<>();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        newCustomer = new Customer("name", "12", testAddress);
        customerList.add(newCustomer);
        newCustomer2 = new Customer("name2", "24", testAddress);
        customerList.add(newCustomer2);
    }

    @Test
    public void customerDeleted() {
        new DeleteCustomer().deleteCustomer(0, customerList);
        assertEquals(newCustomer2, customerList.get(0));
    }

}