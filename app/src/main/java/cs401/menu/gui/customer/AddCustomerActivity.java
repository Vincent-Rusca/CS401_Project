package cs401.menu.gui.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.Modifier;

/**
 * add a customer to the list
 */
public class AddCustomerActivity extends AppCompatActivity implements Modifier {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
    }

    @Override
    public void save(View view) {
        String name = ((EditText) findViewById(R.id.add_customer_name)).getText().toString();
        String id = ((EditText) findViewById(R.id.add_customer_id)).getText().toString();
        String street = ((EditText) findViewById(R.id.add_customer_street)).getText().toString();
        String city = ((EditText) findViewById(R.id.add_customer_city)).getText().toString();
        String state = ((EditText) findViewById(R.id.add_customer_state)).getText().toString();
        String zip = ((EditText) findViewById(R.id.add_customer_zip)).getText().toString();
        Customer customer = new Customer(name, id, new Address(street, city, state, zip));
        CustomerListStateManager.getInstance().addCustomer(customer);
        finish();
    }
}
