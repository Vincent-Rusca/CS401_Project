/* Carlos Castillo
 * Created: 3.8.19
 * Description: will be able to take in order objects that include all necessary information for an order and put into
   an order list that can then be manipulated */

package MainDriver;

import Orders.Order;
import Orders.OrderList;

public class Main{
    public static void main(String[] args){
        Order banana = new Order("banana", 3.24, 25, 11124, "a curved yellow aparatis", 2019, 6, 9);
        Order apple = new Order("apple", 6.14, 45, 48956, "a red thing", 2019, 6, 8);
        Order pear = new Order("pear", 1.36, 13, 31649, "an overgrown green apple", 2018, 6, 8);
        Order blueberry = new Order("blueberry", .16, 198, 74852, "tiny blue balls");
        Order grape = new Order("grape", .6, 136, 69852, "tiny purple balls");
        Order blackberry = new Order("blackberry", .89, 131, 95125, "tiny black balls");
        OrderList allOrders = new OrderList("shopping cart");

        allOrders.addOrder(banana);
        allOrders.addOrder(apple);
        allOrders.addOrder(pear);
        allOrders.addOrder(blueberry);
        allOrders.addOrder(grape);
        allOrders.addOrder(blackberry);

        System.out.println("Item name: " + banana.getItemName());
        System.out.println("Item Cost: " + banana.getCost());
        System.out.println("Item quantity: " + banana.getQuantity());
        System.out.println("Item invoice number: " + banana.getInvoiceNumber());
        System.out.println("Item description: " + banana.getItemDescr());
        System.out.println("");
        System.out.println("Total inventory price of [" + banana.getItemName() + "]: " + allOrders.totalItemCost("banana"));

        allOrders.showOrders();
        allOrders.removeByName("banana");
        System.out.println("New orders");
        allOrders.showOrders();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Ordered by name");
        allOrders.orderByName();

        allOrders.showOrders();

        System.out.println("");
        System.out.println("");
        System.out.println("Ordered by newest");
        allOrders.orderByNewest();
        allOrders.showOrders();

        System.out.println("");
        System.out.println("");
        System.out.println("Ordered by oldest");
        allOrders.orderByOldest();
        allOrders.showOrders();
    }
}
