package cs401.Orders;
/* Carlos Castillo
 * Created: 3.8.19
 * Description: will be able to take in order objects that include all necessary
 * ...information for an order to be put into
 * ...an order list that can then be manipulated
 * Modified: 4.17.19
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
    private Boolean orderStatus;
    private int expectedYr, expectedMo, expectedDay;
    private int yrReceived, moReceived, dayReceived;

    /* basic constructor that doesn't initialize the time */
    public Order(){
        this.calendar = Calendar.getInstance();
        this.item = "";
        this.cost = 0;
        this.quantity = 0;
        this.invoiceNumber = 0;
        this.itemDescr = "";
        this.orderStatus = false;
    }

    /* constructor that creates an order and initializes the date to the time it was created */
    public Order(String item, double cost, int quantity, int invoiceNumber, String itemDescr){
        this.item = item;
        this.cost = cost;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
        this.itemDescr = itemDescr;
        this.orderStatus = false;

        /* initializing the current time */
        this.calendar = Calendar.getInstance();
        this.yr = calendar.get(calendar.YEAR);
        this.mo = calendar.get(calendar.MONTH);
        this.day = calendar.get(calendar.DAY_OF_MONTH);
        this.hour = calendar.get(calendar.HOUR);
        this.min = calendar.get(calendar.MINUTE);
        this.sec = calendar.get(calendar.SECOND);
    }

    /* constructor that creates an order and initializes the date to the time it was created and sets when the order should be received at the latest*/
    public Order(int expectedYr, int expectedMo, int expectedDay,
                 String item, double cost, int quantity, int invoiceNumber, String itemDescr){

        /* initializing the dates for when the order is expected to arrive by the latest */
        this.expectedYr = expectedYr;
        this.expectedMo = expectedMo;
        this.expectedDay = expectedDay;
        this.orderStatus = false;

        /* initializing the times for when the order is received */
        this.yrReceived = -1;
        this.moReceived = -1;
        this.dayReceived = -1;

        /* initializing the variables of the order */
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

    /* constructor that creates and order and initializes the date base on the user's input */
    public Order(String item, double cost, int quantity, int invoiceNumber, String itemDescr, int year, int month, int day){
        this.item = item;
        this.cost = cost;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
        this.itemDescr = itemDescr;
        this.orderStatus = false;

        /* initializing the times for when the order is received */
        this.yrReceived = -1;
        this.moReceived = -1;
        this.dayReceived = -1;

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

    /* sets the quantity of the order */
    public void setQuantity(int newQuantiy){ quantity = newQuantiy; }

    /* sets the invoice number */
    public void setInvoiceNumber(int newInvoiceNum){ invoiceNumber = newInvoiceNum; }

    /* sets the description of the order */
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

    /* will allow the user to set the order status and the date it was received */
    public void setOrderStatus(Boolean currStatus, int yrReceived, int moReceived, int dayReceived){
        this.orderStatus = currStatus;

        /* if the user has not yet received the other but still types in when they received it then these lines will be ignored */
        if(this.orderStatus == true){
            this.yrReceived = yrReceived;
            this.moReceived = moReceived;
            this.dayReceived = dayReceived;
        }
    }

    /* will automatically initialize the dates for when the user receives an order */
    public void setOrderStatus(Boolean currStatus){
        this.orderStatus = currStatus;

        /* these lines are ignored if the user has not received the order yet */
        if(this.orderStatus == true){
            Calendar currentCalendar = Calendar.getInstance();
            int currYr = currentCalendar.get(currentCalendar.YEAR);
            int currMo = currentCalendar.get(currentCalendar.MONTH);
            int currDay = currentCalendar.get(currentCalendar.DAY_OF_MONTH);

            this.yrReceived = currYr;
            this.moReceived = currMo;
            this.dayReceived = currDay;
        }
    }

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

    public Boolean isProcessed(){ return orderStatus; };

    public String getDateReceived(){
        return ((this.moReceived + 1) + "." + this.dayReceived + "." + this.yrReceived);
    }

    public String getDateOrderedPlaced(){
        return ((this.mo + 1) + "." + this.day + "." + this.yr);
    }

    public int getYrReceived() {
        return yrReceived;
    }
    public int getMoReceived() {
        return moReceived;
    }
    public int getDayReceived() {
        return dayReceived;
    }

    /*******************************************************************************************************************
     * UNIQUE FUNCTIONS
     ******************************************************************************************************************/

    /* adds adds or subtracts to the [order]'s quantity */
    public void addToQuantity(int num){ quantity += num; }

    /* simple toString function */
    public String toString(Order currOrder){
        return (this.item + this.cost + this.quantity + this.invoiceNumber);
    }

    /* prints out when the order should arrive at the latest */
    public String getExpectedDate(){
        return (this.expectedMo + "." + this.expectedDay + "." + this.expectedYr);
    }

    /* this function should only return true when it is PASSED the expected due date AND the order has NOT been received
       ...since it's primary function will be to notify a customer when they haven't received an order when it
       ...is passed their expected due date */
    public Boolean isPassedExpectedDate(){
        Calendar currentCalendar = Calendar.getInstance();
        int currentYr = currentCalendar.get(currentCalendar.YEAR);
        int currentMo = currentCalendar.get(currentCalendar.MONTH);
        int currentDay = currentCalendar.get(currentCalendar.DAY_OF_MONTH);

        /* if the order has been received then just return since it doesn't matter if its passed its expected date */
        if(isProcessed() == true){
            return false;
        };

        /* if the order has not been received then check if its passed its expected date */
        if(currentYr > expectedYr && !isProcessed()){
            return true;
        } else if(currentYr == expectedYr && currentMo > expectedMo && !isProcessed()){
            return true;
        } else if(currentYr == expectedYr && currentMo == expectedMo && currentDay > expectedDay && !isProcessed()){
            return true;
        }

        /* if the order has not been received but has not passed the expected due date */
        return false;
    }

    // check fulfillment status
    public boolean isFulfilled() {
        if (yrReceived > 0) return true;
        return false;
    }

    // to fulfill order
    public void fulfillOrder() {
        Calendar now = Calendar.getInstance();
        yrReceived = now.YEAR;
        moReceived = now.MONTH;
        dayReceived = now.DAY_OF_MONTH;
    }

    // for testing
    public void setFulfilledDate(int day, int month, int year) {
        yrReceived = year;
        moReceived = month;
        dayReceived = day;
    }
}
