// Vincent Rusca

package cs401.Customers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerList implements Serializable {
    List<Customer> customerList;

    // constructors
    public CustomerList() {
        customerList = new ArrayList<>();
    }
    public CustomerList(List<Customer> _customerList) {
        customerList = _customerList;
    }

    // search functions - these will return null if customer does not exist
    public Customer searchByName(String _customerName) {
        for (Customer customer : customerList) {
            if (customer.getCustomerName() == _customerName)
                return customer;
        }
        return null;
    }
    public Customer searchByID (String _customerID) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID() == _customerID)
                return customer;
        }
        return null;
    }

    // more functionality as needed...

    // add
    public void add(Customer customer) {
        customerList.add(customer);
    }

    // remove
    public void remove(Customer customer) {
        customerList.remove(customer);
    }

    public void remove(int location) {
        customerList.remove(location);
    }

    // get the customerList
    public List<Customer> getCustomerList() {
        return customerList;
    }

    // this code taken from Carlos' OrderList sorting methods
    public void sortByName(){
        Customer currSmallest;
        Customer secondItem;

        for(int i = 0; i < customerList.size()-1; i++){
            int minIndex = i;
            currSmallest = customerList.get(minIndex);
            for(int j = (i+1); j < customerList.size(); j++){
                secondItem = customerList.get(j);

                if(secondItem.getCustomerName().charAt(0) == currSmallest.getCustomerName().charAt(0)){
                    int n = 1, m = 1;
                    boolean sameItem = false;
                    boolean foundSmallest = false;

                    /* will iterate through each character of the both strings to determine the proper alphabetical order */
                    while(!sameItem && !foundSmallest){
                        if(n == secondItem.getCustomerName().length() && m == currSmallest.getCustomerName().length()){
                            sameItem = true;
                        } else if(secondItem.getCustomerName().charAt(n) < currSmallest.getCustomerName().charAt(m)){
                            minIndex = j;
                            currSmallest = customerList.get(minIndex);
                            foundSmallest = true;
                        }
                        n++;
                        m++;
                    }
                } else if(secondItem.getCustomerName().charAt(0) < currSmallest.getCustomerName().charAt(0)){
                    minIndex = j;
                    currSmallest = customerList.get(minIndex);
                }
            }
            /* swap elements to satisfy selection sort algorithm */
            Customer temp = customerList.get(minIndex);
            customerList.set(minIndex,customerList.get(i));
            customerList.set(i, temp);
        }
    }

    public void sortByID() {
        Customer currSmallest;
        Customer secondItem;

        for (int i = 0; i < customerList.size() - 1; i++) {
            int minIndex = i;
            currSmallest = customerList.get(minIndex);
            for (int j = (i + 1); j < customerList.size(); j++) {
                secondItem = customerList.get(j);

                if (secondItem.getCustomerID().charAt(0) == currSmallest.getCustomerID().charAt(0)) {
                    int n = 1, m = 1;
                    boolean sameItem = false;
                    boolean foundSmallest = false;

                    /* will iterate through each character of the both strings to determine the proper alphabetical order */
                    while (!sameItem && !foundSmallest) {
                        if (n == secondItem.getCustomerID().length() && m == currSmallest.getCustomerID().length()) {
                            sameItem = true;
                        } else if (secondItem.getCustomerID().charAt(n) < currSmallest.getCustomerID().charAt(m)) {
                            minIndex = j;
                            currSmallest = customerList.get(minIndex);
                            foundSmallest = true;
                        }
                        n++;
                        m++;
                    }
                } else if (secondItem.getCustomerID().charAt(0) < currSmallest.getCustomerID().charAt(0)) {
                    minIndex = j;
                    currSmallest = customerList.get(minIndex);
                }
            }
            /* swap elements to satisfy selection sort algorithm */
            Customer temp = customerList.get(minIndex);
            customerList.set(minIndex, customerList.get(i));
            customerList.set(i, temp);
        }
    }
}
