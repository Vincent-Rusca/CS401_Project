/* Carlos Castillo
 * Created: 3.8.19
 * Description: The orderList class */

package cs401.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Will be a list of [order]s that has the ability to return [Order] objects,and be reorganized by a certain characteristic
  * of the [order]s, add and remove [Order] objects, and have the ability to show the [orderList]'s contents */
public class OrderList{
    private List<Order> orderList;
    private String orderListName;

    /* constructor to initialize a new list and the name of the [orderList]*/
    public OrderList(String name){
        orderList = new ArrayList<>();
        orderListName = name;
    }

    /* changes the name of the [orderList[ */
    public void changeOrderListName(String newName){ orderListName = newName; }

    /* returns the name of the [orderList] */
    public String getOrderListName(){ return orderListName; }

    /* will add an [Order] object to the [orderList] */
    public void addOrder(Order newOrder){
        Scanner reader = new Scanner(System.in);

        /* will check to see if there is an already duplicate entry in the [orderList] */
        for(int i = 0; i < orderList.size(); i++){
            Order currOrder = orderList.get(i);

            if(currOrder.getItemName().equals(newOrder.getItemName()) && currOrder.getCost() == newOrder.getCost()){        // if the item names and price are the same
                orderList.get(i).addToQuantity(newOrder.getQuantity());     // just add the quantaties together
                return;
            } else if(currOrder.getItemName().equals(newOrder.getItemName()) && currOrder.getCost() != newOrder.getCost()){     // if the item names are the same but the prices are different
                System.out.println(" ");
                System.out.println("The order you entered has conflicting prices with an already existing order!");
                System.out.println("The original price of [" + currOrder.getItemName() + "] is " + currOrder.getCost());
                System.out.println("You entered " + newOrder.getCost());
                System.out.println("Which of these two prices would you like to keep?");
                System.out.println("[1] - " + currOrder.getCost());
                System.out.println("[2] - " + newOrder.getCost());
                int choice = Integer.parseInt(reader.nextLine());

                while(choice != 1 && choice != 2){
                    System.out.println("please select [1] or [2]");
                    System.out.println("[1] - " + currOrder.getCost());
                    System.out.println("[2] - " + newOrder.getCost());
                    choice = Integer.parseInt(reader.nextLine());
                }

                if(choice == 1){
                    orderList.get(i).setCost(currOrder.getCost());
                } else if(choice == 2){
                    orderList.get(i).setCost(newOrder.getCost());
                }
                orderList.get(i).addToQuantity(newOrder.getQuantity());
            }
        }
        orderList.add(newOrder);       // if its an entirely new entry, then just add it to the orderList
    }

    /* returns an [Order] by index */
    public Order getOrderByIndex(int index){
        if(index > orderList.size()-1){     // if the user selects and index our of range
            return null;
        }

        return orderList.get(index);
    }

    /* returns an [Order] by removing it from the list */
    public Order removeOrderByIndex(int index){
        if(index > orderList.size()-1){
            return null;
        }

        return orderList.remove(index);
    }

    /* adds adds or subtracts to the [order]'s quantity */
    public void addToQuantity(String orderName, int num){
        Order currOrder = getOrderbyName(orderName);
        if(currOrder == null){
            System.out.println("Could not find [" + orderName + "] in the orderList");
        } else{
            currOrder.addToQuantity(num);
        }
    }

    /* will print out all the [Order]'s information in a formated way */
    public void showOrders(){
        String item = "<ITEM>", cost = "<COST>", quantity = "<QUANTITY>", invoice = "<INVOICE>", desc = "<DESCRIPTION>", date = "<DATE>", theTime = "<TIME>";
        System.out.println("");
        System.out.printf( "%-20s %-15s %-20s %-15s %-15s %-15s %-15s %n", item, cost, quantity, invoice, date, theTime, desc);
        System.out.print("----------------------------------------------------------------------------------------------------------------------------");

        for(Order currItem : orderList){
            System.out.println("");
            System.out.printf( "%-20s %-15s %-20s %-15s %d.%d.%d %8s:%d:%d         %-20s", currItem.getItemName(), currItem.getCost(), currItem.getQuantity(), currItem.getInvoiceNumber(),
                    currItem.getMo(), currItem.getDay(), currItem.getYr(),
                    currItem.getHour(), currItem.getMin(), currItem.getSec(),
                    currItem.getItemDescr());
        }
    }

    /* will remove the matching item name that the user inputs */
    public void removeByName(String itemName){
        int initialsize = orderList.size();
        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getItemName().equals(itemName)){
                System.out.println(" ");
                System.out.println("Removing [" + orderList.get(i).getItemName() + "] from the orderList");
                orderList.remove(i);
                break;
            }
        }

        if(initialsize == orderList.size()){
            System.out.println("Could not find item: " + itemName);
        }
    }

    /* will return an [order] object by the name, if not found then return null */
    public Order getOrderbyName(String itemName){
        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getItemName().equals(itemName)){
                return orderList.get(i);
            }
        }

        System.out.println("Could not find item: " + itemName);
        return null;
    }

    /* will remove the matching invoice number that the user inputs */
    public void removeByInvoiceNum(int invoiceNum){
        int initialSize = orderList.size();

        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getInvoiceNumber() == invoiceNum){
                System.out.println(" ");
                System.out.println("Removing [" + orderList.get(i).getItemName() + "] from the orderList");
                orderList.remove(i);
            }
        }

        if(orderList.size() == initialSize){
            System.out.println("Could not find an item with the invoice number: " + invoiceNum);
        }
    }

    /* returns an [order] object by the invoice number, if not found then return null */
    public Order getOrderByInvoice(int invoiceNum){
        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getInvoiceNumber() == invoiceNum){
                return orderList.remove(i);
            }
        }

        System.out.println("Could not find an item with the invoice number: " + invoiceNum);
        return null;
    }

    /* will add up all the prices for a given item */
    public double totalItemCost(String item){
        double totalCost = 0;
        Order currOrder = null;

        for(int i = 0; i < orderList.size(); i++){
            currOrder = orderList.get(i);
            if(currOrder.getItemName().equals(item)){
                totalCost = currOrder.getQuantity() * currOrder.getCost();
            }
        }
        return totalCost;
    }

    /* will re-arange the [orderlist] so that the list is printed out in alphabetical order using selection sort algorithm*/
    public void orderByName(){
        Order currSmallest;
        Order secondItem;       // this will be compared to [currSmallest]

        for(int i = 0; i < orderList.size()-1; i++){
            int minIndex = i;
            currSmallest = orderList.get(minIndex);
            for(int j = (i+1); j < orderList.size(); j++){
                secondItem = orderList.get(j);

                if(secondItem.getItemName().charAt(0) == currSmallest.getItemName().charAt(0)){     // if the first two characters are the same
                    int n = 1, m = 1;       // will be the indexes to iterate through the characters of the two strings being compared
                    boolean sameItem = false;
                    boolean foundSmallest = false;

                    /* will iterate through each character of the both strings to determine the proper alphabetical order */
                    while(!sameItem && !foundSmallest){       // loop will break if the string being compared is the same or if the the smaller string is found
                        if(n == secondItem.getItemName().length() && m == currSmallest.getItemName().length()){
                            sameItem = true;
                        } else if(secondItem.getItemName().charAt(n) < currSmallest.getItemName().charAt(m)){
                            minIndex = j;
                            currSmallest = orderList.get(minIndex);
                            foundSmallest = true;
                        }
                        n++;
                        m++;
                    }
                } else if(secondItem.getItemName().charAt(0) < currSmallest.getItemName().charAt(0)){       // if the first two characters of the the strings are different....
                    minIndex = j;
                    currSmallest = orderList.get(minIndex);
                }
            }
            /* swap elements to satisfy selection sort algorithm */
            Order temp = orderList.get(minIndex);
            orderList.set(minIndex,orderList.get(i));
            orderList.set(i, temp);
        }
    }

    /* will order the [orderList] by the newest entered orders first */
    public void orderByNewest(){
        Order currNewest;
        Order secondItem;       // this will be compared to [currSmallest]

        for(int i = 0; i < orderList.size()-1; i++){
            int minIndex = i;
            currNewest = orderList.get(minIndex);
            for(int j = (i+1); j < orderList.size(); j++){
                secondItem = orderList.get(j);
                boolean found = false;

                if(secondItem.getYr() > currNewest.getYr()){
                    minIndex = j;
                    currNewest = orderList.get(minIndex);
                } else if(secondItem.getYr() > currNewest.getYr() && secondItem.getMo() < currNewest.getMo()){
                    minIndex = j;
                    currNewest = orderList.get(minIndex);
                } else if(secondItem.getYr() > currNewest.getYr() && secondItem.getMo() < currNewest.getMo() && secondItem.getDay() < currNewest.getDay()){
                    minIndex = j;
                    currNewest = orderList.get(minIndex);
                }
            }
            /* swap elements to satisfy selection sort algorithm */
            Order temp = orderList.get(minIndex);
            orderList.set(minIndex,orderList.get(i));
            orderList.set(i, temp);
        }
    }

    /* will order the [orderList] by the oldest entered orders first */
    public void orderByOldest(){
        Order currOldest;
        Order secondItem;       // this will be compared to [currSmallest]

        for(int i = 0; i < orderList.size()-1; i++){
            int minIndex = i;
            currOldest = orderList.get(minIndex);
            for(int j = (i+1); j < orderList.size(); j++){
                secondItem = orderList.get(j);
                boolean found = false;

                if(secondItem.getYr() < currOldest.getYr()){      // if the statement is true, the [secondItem] will technically be a smaller number but thats because 2018 is older than 2019 for example
                    minIndex = j;
                    currOldest = orderList.get(minIndex);
                } else if(secondItem.getYr() == currOldest.getYr() && secondItem.getMo() < currOldest.getMo()){
                    minIndex = j;
                    currOldest = orderList.get(minIndex);
                } else if(secondItem.getYr() == currOldest.getYr() && secondItem.getMo() == currOldest.getMo() && secondItem.getDay() < currOldest.getDay()){
                    minIndex = j;
                    currOldest = orderList.get(minIndex);
                }
            }
            /* swap elements to satisfy selection sort algorithm */
            Order temp = orderList.get(minIndex);
            orderList.set(minIndex,orderList.get(i));
            orderList.set(i, temp);
        }
    }

    // isEmpty()
    public boolean isEmpty() {
        if(orderList.isEmpty())
            return true;
        return false;
    }
}
