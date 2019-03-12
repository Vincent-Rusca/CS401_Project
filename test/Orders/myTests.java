package Orders;/* Carlos Castillo
 * 3.12.19
 * Description: This package contains tests for some of the functions from the [OrderList] and [Order] classes
 * Note: not all functions were included since most of them were just simple setters and getters, only the
 *       more complicated functions were included along with a few of the setters and getters */

import Orders.Order;
import Orders.OrderList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class myTests {
    private OrderList orderList;
    private Order order1;
    private Order order2;
    private Order order3;
    private Order firstOrder;       // will reference the first element in the [orderList]

    @Before
    public void setUp(){
        order1 = new Order("apple", 1.56, 86, 55548, "a red ball thing", 2010, 6, 29);
        order2 = new Order("pear", 3.25, 45, 49768, "stretched green apple", 2012, 1, 1);
        order3 = new Order("grape", 0.06, 200, 13458, "small purple ball", 2019, 4, 18);
        orderList = new OrderList("Shopping Cart");
        orderList.addOrder(order3);
        orderList.addOrder(order1);
        orderList.addOrder(order2);
    }

    @Test
    public void orderNameTest(){
        Assert.assertEquals("apple", order1.getItemName());
    }

    @Test
    public void orderCostTest(){
        Assert.assertEquals(1.56, order1.getCost(), 0.0);
    }

    @Test
    public void orderQuantitiyTest(){
        Assert.assertEquals(86, order1.getQuantity());
    }

    @Test
    public void orderInvoiceTest(){
        Assert.assertEquals(55548, order1.getInvoiceNumber());
    }

    @Test
    public void orderDescriptionTest(){
        Assert.assertEquals("a red ball thing", order1.getItemDescr());
    }

    @Test
    public void totalCostTest(){
        Assert.assertEquals(134.16, orderList.totalItemCost("apple"), 0.0);
    }

    @Test
    public void addToQuantity(){
        order1.addToQuantity(20);
        Assert.assertEquals(106, order1.getQuantity());
    }

    @After
    public void removeAddedQuantity(){
        order1.addToQuantity(-20);
    }

    @Test
    public void addToQuanityFromList(){
        orderList.addToQuantity("apple", 30);
        Assert.assertEquals(116, orderList.getOrderbyName("apple").getQuantity());
    }

    @Test
    public void orderedByNameTest(){
        orderList.orderByName();
        firstOrder = orderList.getOrderByIndex(0);      // since the name apple is in the list, it should be the first element in the list after its been ordered
        Assert.assertEquals("apple", firstOrder.getItemName());
    }

    @Test
    public void orderedByNewestTest (){
        orderList.orderByNewest();
        firstOrder = orderList.getOrderByIndex(0);      // since 2019 was the newest order in the list, it should then be the first element in the list after its been ordered
        Assert.assertEquals(2019, firstOrder.getYr());
    }

    @Test
    public void orderedByOldestTest(){
        orderList.orderByOldest();
        firstOrder = orderList.getOrderByIndex(0);      // since 2010 was the newest order in the list, it should then be the first element in the list after its been ordered
        Assert.assertEquals(2010, firstOrder.getYr());
    }
}
