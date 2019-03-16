// Vincent Rusca

package Customers;

public class Customer {
    String customerName;
    String customerID;
    Address address;
    Orders.OrderList orderList;

    // constructors
    public Customer() {
        customerName = "";
        customerID = "-1";
        address = new Address();
        orderList = new Orders.OrderList("Customer Order List");
    }
    public Customer(String _companyName, String _companyID, Address _address) {
        customerName = _companyName;
        customerID = _companyID;
        address = _address;
        orderList = new Orders.OrderList("Customer Order List");
    }

    // getters
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerID() {
        return customerID;
    }
    public Address getAddress() {
        return address;
    }
    public Orders.OrderList getOrderList() {
        return orderList;
    }


    // setters
    public void setCustomerName(String _customerName) {
        customerName = _customerName;
    }
    public void setCustomerID(String _customerID) {
        customerID = _customerID;
    }
    public void setAddress(Address _address) {
        address = _address;
    }
    public void setOrderList(Orders.OrderList _orderList) {
        orderList = _orderList;
    }

    // other functions
    public void addToOrderList(Orders.Order order) {
        orderList.addOrder(order);
    }


}
