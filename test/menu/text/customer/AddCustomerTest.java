package menu.text.customer;

import Customers.Address;
import Customers.Customer;
import Customers.CustomerList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AddCustomerTest {

    private Customer customer;
    private CustomerList customerList;

    @Before
    public void setUp() {
        customerList = new CustomerList();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        customer = new Customer("name", "12", testAddress);
    }

    @Test
    public void customerAdded() {
        AddCustomer add = new AddCustomer();
        String inputString = "\nname\n12\nnewname\n1234\n5678\nabc\ndef";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        Scanner scanner = new Scanner(inputStream);
        add.display(scanner, customerList);
        // TODO: remove the getCustomerName call if customer gets an equals override
        assertEquals(1, customerList.getCustomerList().size());
        assertEquals(customer.getCustomerName(), customerList.getCustomerList().get(0).getCustomerName());
    }
}