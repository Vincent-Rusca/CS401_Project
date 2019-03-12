package menu.text.order;

import Customers.Address;
import Customers.Customer;
import Orders.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddOrderTest {

    Customer customer;
    Customer customer2;
    List<Customer> customerList;
    Order order;

    @Before
    public void setUp() {
        customerList = new ArrayList<>();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        customer = new Customer("name", 12, testAddress);
        customer2 = new Customer("name2", 24, testAddress);
        customerList.add(customer);
        customerList.add(customer2);
        order = new Order("apple", 6.14, 45, 48956, "a red thing");
    }

    @Test
    public void orderAdded() {
        new AddOrder().addOrder(customerList, 1, order);
        // TODO need a way to get an individual order
    }

}