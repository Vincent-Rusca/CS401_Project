package cs401.menu.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goToCustomerActivity(View view) {
        Intent intent = new Intent(this, Customer_Activity.class);

        // this will initialize a CustomerList and pass it to my customer activity
        // FOR TESTING PURPOSES ONLY *****************************************************
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
        // END TESTING CODE **************************************************************

        //intent.putExtra("customerList", customerList);
        startActivity(intent);
    }

}
