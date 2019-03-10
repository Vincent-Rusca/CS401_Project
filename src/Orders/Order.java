package Orders;

public class Order{
    private String item;
    private double cost;
    private int quantity;
    private int invoiceNumber;
    private String itemDescr;


    public Order(){
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
    }

    /*******************************************************************************************************************
     * SETTERS
     ******************************************************************************************************************/

    /*  */
    public void setItemName(String name){ item = name; }

    /*  */
    public void setCost(double newCost){ cost = newCost; }

    /*  */
    public void setQuantity(int newQuantiy){ quantity = newQuantiy; }

    /*  */
    public void setInvoiceNumber(int newInvoiceNum){ invoiceNumber = newInvoiceNum; }

    /*  */
    public void setDescription(String newDescr){ itemDescr = newDescr; }

    /*******************************************************************************************************************
     * GETTERS
     ******************************************************************************************************************/

    /*  */
    public String getItemName() { return item; }

    /*  */
    public double getCost(){ return cost; }

    /*  */
    public int getQuantity(){ return quantity; }

    /*  */
    public int getInvoiceNumber(){ return invoiceNumber; }

    /*  */
    public String getItemDescr() { return itemDescr; }

    /*******************************************************************************************************************
     * UNIQUE FUNCTIONS
     ******************************************************************************************************************/

    public void addToQuantity(int num){
        quantity += num;
    }
}
