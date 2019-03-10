package Accounts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAccount {
    Address testAddress;

    @Before
    public void setUp() throws Exception {
        testAddress = new Address("123 Easy St.", "Eureka",
                "California", "94599");
    }

    @Test
    public void test1() {
        System.out.println(testAddress.toString());
    }
}