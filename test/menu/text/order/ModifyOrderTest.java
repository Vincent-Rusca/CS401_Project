package menu.text.order;

import Customers.Address;
import Customers.Customer;
import Customers.CustomerList;
import Orders.Order;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ModifyOrderTest {

    private Customer customer;
    private CustomerList customerList;
    private Order order;

    @Before
    public void setUp() {
        customerList = new CustomerList();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        customer = new Customer("name", 12, testAddress);
        order = new Order("apple", 6.14, 45, 48956, "a red thing");
        customer.addToOrderList(order);
        customerList.add(customer);
    }

    @Test
    public void testModified() {
        ModifyOrder modifyOrder = new ModifyOrder();
        String inputString = "0\napple\n5\nbanananana";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        Scanner scanner = new Scanner(inputStream);
        modifyOrder.display(scanner, customerList);
        assertEquals("banananana", customerList.getCustomerList().get(0).getOrderList().getOrderByIndex(0).getItemName());
    }
}
