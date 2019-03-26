package cs401.menu.text.order;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.Orders.Order;
import cs401.Orders.OrderList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AddOrderTest {

    private Customer customer;
    private Customer customer2;
    private CustomerList customerList;
    private Order order;

    @Before
    public void setUp() {
        customerList = new CustomerList();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        customer = new Customer("name", "12", testAddress);
        customer2 = new Customer("name2", "24", testAddress);
        customerList.add(customer);
        customerList.add(customer2);
        order = new Order("apple", 6.14, 45, 48956, "aredthing");
    }

    @Test
    public void orderAdded() {
        AddOrder addOrder = new AddOrder();
        String inputString = "1\napple\n6.14\n45\n48956\naredthing";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        Scanner scanner = new Scanner(inputStream);
        addOrder.display(scanner, customerList);
        OrderList list = customerList.getCustomerList().get(1).getOrderList();
        // TODO: change this to not include the item name if order gets a .equals function
        assertEquals(order.getItemName(), list.getOrderByIndex(0).getItemName());
    }

}