package Customers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAddress {
    Address testAddress;

    @Before
    public void setUp() throws Exception {
        testAddress = new Address("123 Easy St.", "Eureka",
                "California", "94599");
    }

    @Test
    public void test1() {
        System.out.println(testAddress.toString());
        assertEquals(testAddress.getStreetAddress(), "123 Easy St.");
        assertEquals(testAddress.getCityAddress(), "Eureka");
        assertEquals(testAddress.getStateAddress(), "California");
        assertEquals(testAddress.getZipAddress(), "94599");
    }
}