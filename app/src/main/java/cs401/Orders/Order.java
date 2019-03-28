package cs401.Orders;
/* Carlos Castillo
 * Created: 3.8.19
 * Description: will be able to take in order objects that include all necessary
 * information for an order and put into
 * an order list that can then be manipulated
 * Created: 3.8.19
 * Description: The Order class */

import java.io.Serializable;
import java.util.Calendar;

public class Order implements Serializable {
    private String item;
    private double cost;
    private int quantity;
    private int invoiceNumber;
    private String itemDescr;
    private int yr, mo, day;
    private int hour, min, sec;
    private Calendar calendar;


    public Order(){
        this.calendar = Calendar.getInstance();
        this.item = "";
        this.cost = 0;
        this.quantity = 0;
        this.invoiceNumber = 0;
        this.itemDescr = "";
    }

    public Order(String item, double cost, int quantity, int invoiceNumber, String itemDescr){
        this.item = item;
        this.cost = cost;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
        this.itemDescr = itemDescr;

        /* initializing the current time */
        this.calendar = Calendar.getInstance();
        this.yr = calendar.get(calendar.YEAR);
        this.mo = calendar.get(calendar.MONTH);
        this.day = calendar.get(calendar.DAY_OF_MONTH);
        this.hour = calendar.get(calendar.HOUR);
        this.min = calendar.get(calendar.MINUTE);
        this.sec = calendar.get(calendar.SECOND);
    }

    public Order(String item, double cost, int quantity, int invoiceNumber, String itemDescr, int year, int month, int day){
        this.item = item;
        this.cost = cost;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
        this.itemDescr = itemDescr;

        /* initializing the current time */
        this.calendar = Calendar.getInstance();
        this.yr = year;
        this.mo = month;
        this.day = day;
        this.hour = calendar.get(calendar.HOUR);
        this.min = calendar.get(calendar.MINUTE);
        this.sec = calendar.get(calendar.SECOND);
    }

    /*******************************************************************************************************************
     * SETTERS
     ******************************************************************************************************************/

    /* sets the order's name */
    public void setItemName(String name){ item = name; }

    /* sets the cost of the order */
    public void setCost(double newCost){ cost = newCost; }

    /* sets the quantitiy of the order */
    public void setQuantity(int newQuantiy){ quantity = newQuantiy; }

    /* sets the invoice number */
    public void setInvoiceNumber(int newInvoiceNum){ invoiceNumber = newInvoiceNum; }

    /* sets he descpriton of the order */
    public void setDescription(String newDescr){ itemDescr = newDescr; }

    /* sets the year the order was placed */
    public void setYr(int year){ yr = year; }

    /* sets the month the order was placed*/
    public void setMo(int month){ mo = month; }

    /* sets the day the order was placed */
    public void setDay(int day){ this.day = day;}

    /* sets the hour the order was placed */
    public void setHour(int hour){ this.hour = hour; }

    /* sets the minute the order was placed */
    public void setMin(int minute){ this.min = minute; }

    /* sets the second the order was placed */
    public void setSec(int second){ this.sec = second; }
    /*******************************************************************************************************************
     * GETTERS
     ******************************************************************************************************************/

    /* returns the name of the order */
    public String getItemName() { return item; }

    /* returns the cost of the order */
    public double getCost(){ return cost; }

    /* returns the quantity of the order */
    public int getQuantity(){ return quantity; }

    /* returns the invoice of the order */
    public int getInvoiceNumber(){ return invoiceNumber; }

    /* returns the description of the order */
    public String getItemDescr() { return itemDescr; }

    /* returns the year the order was placed */
    public int getYr(){ return yr; }

    /* returns the month the order was placed */
    public int getMo(){ return mo; }

    /* returns the day the order was placed */
    public int getDay(){ return day; }

    /* returns the hour of when the order was placed */
    public int getHour(){ return hour; }

    /* returns the minute of when the order was placed */
    public int getMin(){ return min; }

    /* returns the seconds of when the order was placed */
    public int getSec(){ return sec; }

    /*******************************************************************************************************************
     * UNIQUE FUNCTIONS
     ******************************************************************************************************************/

    /* adds adds or subtracts to the [order]'s quantity */
    public void addToQuantity(int num){ quantity += num; }
}
