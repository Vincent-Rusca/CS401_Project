package cs401.menu.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.Orders.Order;
import cs401.R;
import cs401.menu.gui.customer.AddCustomerActivity;
import cs401.menu.gui.customer.DeleteCustomerActivity;
import cs401.menu.gui.customer.DisplayCustomerActivity;
import cs401.menu.gui.customer.ModifyCustomerActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        generateSampleInput();
    }

    public void goToCustomerActivity(View view) {
        Intent intent = new Intent(this, Customer_Activity.class);

        // this will initialize a CustomerList and pass it to my customer activity
        // FOR TESTING PURPOSES ONLY *****************************************************
        CustomerList customerList = new CustomerList();
        Address customerAddress = new Address("123 Easy St.", "Eureka", "CA", "94599");
        Customer newCustomer = new Customer("Test Incorporated LLC", "4", customerAddress);
        customerList.add(newCustomer);

        customerAddress = new Address("69 Everyone Ln.", "Kansas City", "KS", "54321");
        newCustomer = new Customer("Wincest Properties LLC", "3", customerAddress);
        customerList.add(newCustomer);

        customerAddress = new Address("45 Ocho St.", "Paris", "TX", "54554");
        newCustomer = new Customer("Texas Cheese Toast Co.", "2", customerAddress);
        customerList.add(newCustomer);
        // END TESTING CODE **************************************************************

        intent.putExtra("customerList", customerList);
        startActivity(intent);
    }

    // TODO: move this to the login activity (low priority)
    private void generateSampleInput() {
        if (CustomerListStateManager.getInstance().isEmpty()) {
            Address customerAddress = new Address("123 Easy St.", "Eureka", "CA", "94599");
            Customer newCustomer = new Customer("Test Incorporated LLC", "1", customerAddress);
            newCustomer.addToOrderList(new Order("taco", 1100, 20, 98723, "a taco"));
            newCustomer.addToOrderList(new Order("taco2", 140, 23, 923423, "a taco2"));
            CustomerListStateManager.getInstance().addCustomer(newCustomer);

            customerAddress = new Address("45 Ocho St.", "Paris", "TX", "54554");
            newCustomer = new Customer("Texas Cheese Toast Co.", "2", customerAddress);
            newCustomer.addToOrderList(new Order("burrito", 13540, 2233, 923, "a burrito"));
            CustomerListStateManager.getInstance().addCustomer(newCustomer);

            customerAddress = new Address("69 Everyone Ln.", "Kansas City", "KS", "54321");
            newCustomer = new Customer("Wincest Properties LLC", "3", customerAddress);
            CustomerListStateManager.getInstance().addCustomer(newCustomer);
        }
    }

    public void addCustomerView(View view) {
        Intent intent = new Intent(this, AddCustomerActivity.class);
        startActivity(intent);
    }

    public void modifyCustomerView(View view) {
        Intent intent = new Intent(this, ModifyCustomerActivity.class);
        startActivity(intent);
    }

    public void deleteCustomerView(View view) {
        Intent intent = new Intent(this, DeleteCustomerActivity.class);
        startActivity(intent);
    }

    public void displayCustomerView(View view) {
        Intent intent = new Intent(this, DisplayCustomerActivity.class);
        startActivity(intent);
    }

}
