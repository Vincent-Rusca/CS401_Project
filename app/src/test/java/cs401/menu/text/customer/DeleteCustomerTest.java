package cs401.menu.text.customer;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DeleteCustomerTest {

    private CustomerList customerList;
    private Customer newCustomer;
    private Customer newCustomer2;

    @Before
    public void setUp() {
        customerList = new CustomerList();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        newCustomer = new Customer("name", "12", testAddress);
        customerList.add(newCustomer);
        newCustomer2 = new Customer("name2", "24", testAddress);
        customerList.add(newCustomer2);
    }

    @Test
    public void customerDeleted() {
        DeleteCustomer delete = new DeleteCustomer();
        String inputString = "0";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        Scanner scanner = new Scanner(inputStream);
        delete.display(scanner, customerList);
        assertEquals(1, customerList.getCustomerList().size());
        assertEquals(newCustomer2, customerList.getCustomerList().get(0));
    }

}