package cs401.Orders;
/* Carlos Castillo
 * Created: 3.8.19
 * Description: The orderList class */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Will be a list of [order]s that has the ability to return [Order] objects,and be reorganized by a certain characteristic
 * of the [order]s, add and remove [Order] objects, and have the ability to show the [orderList]'s contents */
public class OrderList implements Serializable {
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
            return;
        } else{
            currOrder.addToQuantity(num);
        }
    }

    /* will print out all the [Order]'s information in a formated way */
    public void showOrders(){
    }

    /* will remove the matching item name that the user inputs */
    public void removeByName(String itemName){
        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getItemName().equals(itemName)){
                break;
            }
        }
    }

    /* will return an [order] object by the name, if not found then return null */
    public Order getOrderbyName(String itemName){
        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getItemName().equals(itemName)){
                return orderList.get(i);
            }
        }
        return null;
    }

    /* will remove the matching invoice number that the user inputs */
    public void removeByInvoiceNum(int invoiceNum){
        int initialSize = orderList.size();

        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getInvoiceNumber() == invoiceNum){
                orderList.remove(i);
            }
        }
    }

    /* returns an [order] object by the invoice number, if not found then return null */
    public Order getOrderByInvoice(int invoiceNum){
        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getInvoiceNumber() == invoiceNum){
                return orderList.remove(i);
            }
        }
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
        return orderList.isEmpty();
    }

    public int size() {
        return orderList.size();
    }

    public int getOrderListSize(){
        return orderList.size();
    }
}
