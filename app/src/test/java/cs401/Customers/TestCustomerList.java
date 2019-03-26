package cs401.Customers;

import cs401.Orders.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCustomerList {
    Customer testCustomer;
    Address testAddress;
    Order testOrder;
    CustomerList testCustomerList;

    @Before
    public void setUp() {
        testAddress = new Address("123 Easy St.", "Eureka",
                "California", "94599");
        testCustomer = new Customer("testCo.", "555555", testAddress);
        testOrder = new Order("testItem", 100, 1, 123456, "a test item");
        testCustomerList = new CustomerList();
        testCustomerList.add(testCustomer);
    }

    @Test
    public void test1() {
        assertNull(testCustomerList.searchByID("0"));
        assertNull(testCustomerList.searchByName("NOT IN LIST"));

        assertNotNull(testCustomerList.searchByID("555555"));
        assertNotNull(testCustomerList.searchByName("testCo."));

        testCustomerList.remove(testCustomerList.searchByID("555555"));
        assertNull(testCustomerList.searchByID("555555"));
        assertNull(testCustomerList.searchByName("testCo."));
    }

}