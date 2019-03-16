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

public class RemoveOrderTest {

    private Customer customer;
    private CustomerList customerList;
    private Order order;
    private Order order2;

    @Before
    public void setUp() {
        customerList = new CustomerList();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        customer = new Customer("name", 12, testAddress);
        order = new Order("apple", 6.14, 45, 48956, "a red thing");
        order2 = new Order("banana", 3.24, 25, 11124, "a curved yellow aparatis");
        customer.addToOrderList(order);
        customer.addToOrderList(order2);
        customerList.add(customer);
    }

    @Test
    public void orderRemoved() {
        RemoveOrder removeOrder = new RemoveOrder();
        String inputString = "0\napple";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        Scanner scanner = new Scanner(inputStream);
        removeOrder.display(scanner, customerList);
        assertEquals(order2.getItemName(), customerList.getCustomerList().get(0).getOrderList().getOrderByIndex(0).getItemName());
    }
}