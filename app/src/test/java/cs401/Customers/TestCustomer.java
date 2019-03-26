package cs401.Customers;

import cs401.Orders.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCustomer {
    Customer testCustomer;
    Address testAddress;
    Order testOrder;

    @Before
    public void setUp() {
        testCustomer = new Customer();
        testAddress = new Address("123 Easy St.", "Eureka",
                "California", "94599");
        testOrder = new Order("testItem", 100, 1, 123456, "a test item");
    }

    @Test
    public void test1() {
        testCustomer.setCustomerName("testCo.");
        assertEquals(testCustomer.getCustomerName(), "testCo.");

        testCustomer.setCustomerID("555555");
        assertEquals(testCustomer.getCustomerID(), "555555");

        testCustomer.setAddress(testAddress);
        assertEquals(testCustomer.getAddress(), testAddress);

        testCustomer.addToOrderList(testOrder);
        assertFalse(testCustomer.getOrderList().isEmpty());
    }
}