package cs401.menu.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.customer.AddCustomerActivity;
import cs401.menu.gui.customer.Customer_Activity;
import cs401.menu.gui.customer.DeleteCustomerActivity;
import cs401.menu.gui.customer.DisplayCustomerActivity;
import cs401.menu.gui.customer.ModifyCustomerActivity;

public class MenuActivity extends AppCompatActivity {

    CustomerList customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        customerList = new CustomerList();
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

    public void addCustomerView(View view) {
        Intent intent = new Intent(this, AddCustomerActivity.class);
        startActivity(intent);
    }

    // TODO: use a customer list from somewhere else for the following
    public void modifyCustomerView(View view) {
        CustomerList customerList = new CustomerList();
        Address customerAddress = new Address("123 Easy St.", "Eureka", "CA", "94599");
        Customer newCustomer = new Customer("Test Incorporated LLC", "1", customerAddress);
        customerList.add(newCustomer);

        customerAddress = new Address("45 Ocho St.", "Paris", "TX", "54554");
        newCustomer = new Customer("Texas Cheese Toast Co.", "2", customerAddress);
        customerList.add(newCustomer);

        customerAddress = new Address("69 Everyone Ln.", "Kansas City", "KS", "54321");
        newCustomer = new Customer("Wincest Properties LLC", "3", customerAddress);
        customerList.add(newCustomer);
        Intent intent = new Intent(this, ModifyCustomerActivity.class);
        intent.putExtra("customerList", customerList);
        startActivity(intent);
    }

    public void deleteCustomerView(View view) {
        Intent intent = new Intent(this, DeleteCustomerActivity.class);
        intent.putExtra("customerList", customerList);
        startActivity(intent);
    }

    public void displayCustomerView(View view) {
        Intent intent = new Intent(this, DisplayCustomerActivity.class);
        intent.putExtra("customerList", customerList);
        startActivity(intent);
    }

}
