package menu.text.customer;

import Customers.Address;
import Customers.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ModfiyCustomerAddressTest {

    Customer customer;
    List<Customer> customerList;

    @Before
    public void setUp() {
        customerList = new ArrayList<>();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        customer = new Customer("name", "12", testAddress);
        customerList.add(customer);
    }

    @Test
    public void addressModified() {
        Address newAddress = new Address("street", "city", "state", "zip");
        ModfiyCustomerAddress modfiyAddress = new ModfiyCustomerAddress();
        modfiyAddress.modifyAddress(newAddress);
        assertEquals(modfiyAddress.getNewAddress(), newAddress);
    }

}