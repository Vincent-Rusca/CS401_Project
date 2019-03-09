public class Account {
    String companyName;
    int companyID;
    Address address;
    //List<Order> orderList;

    // constructors
    public Account() {
        companyName = "";
        companyID = -1;
        address = new Address();
        //orderList = new ArrayList<Order>;
    }
    public Account(String _companyName, int _companyID, Address _address) {
        companyName = _companyName;
        companyID = _companyID;
        address = _address;
        //orderList = new ArrayList<Order>;
    }

    // getters
    public String getCompanyName() {
        return companyName;
    }
    public int getCompanyID() {
        return companyID;
    }
    public Address getAddress() {
        return address;
    }
    /*public List<Order> getOrderList() {
        return orderList;
    }
    */

    // setters
    public void setCompanyName(String _companyName) {
        companyName = _companyName;
    }
    public void setCompanyID(int _companyID) {
        companyID = _companyID;
    }
    public void setAddress(Address _address) {
        address = _address;
    }
    /*public void setOrderList(List<Order> _orderList) {
        orderList = _orderList;
    }

    // other functions
    public void addOrder(Order order) {
        orderList.add(order);
    }


    */

}
