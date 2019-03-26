// Vincent Rusca

package cs401.Customers;

import java.io.Serializable;

public class Customer implements Serializable {
    String customerName;
    String customerID;
    Address address;
    cs401.Orders.OrderList orderList;

    // constructors
    public Customer() {
        customerName = "";
        customerID = "-1";
        address = new Address();
        orderList = new cs401.Orders.OrderList("Customer Order List");
    }
    public Customer(String _companyName, String _companyID, Address _address) {
        customerName = _companyName;
        customerID = _companyID;
        address = _address;
        orderList = new cs401.Orders.OrderList("Customer Order List");
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
    public cs401.Orders.OrderList getOrderList() {
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
    public void setOrderList(cs401.Orders.OrderList _orderList) {
        orderList = _orderList;
    }

    // other functions
    public void addToOrderList(cs401.Orders.Order order) {
        orderList.addOrder(order);
    }


}
