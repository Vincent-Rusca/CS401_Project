package cs401.menu.gui.customer.modify;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.Modifier;

/**
 * modify a customer's address
 */
public class ModifyCustomerAddressActivity extends AppCompatActivity implements Modifier {

    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer_address);
        int index = (Integer) getIntent().getSerializableExtra("customer");
        customer = CustomerListStateManager.getInstance().getCustomer(index);
    }

    @Override
    public void save(View view) {
        CustomerListStateManager customerListStateManager = CustomerListStateManager.getInstance();
        String street = ((EditText) findViewById(R.id.modify_customer_street)).getText().toString();
        String city = ((EditText) findViewById(R.id.modify_customer_city)).getText().toString();
        String state = ((EditText) findViewById(R.id.modify_customer_state)).getText().toString();
        String zip = ((EditText) findViewById(R.id.modify_customer_zip)).getText().toString();
        Address newAddress = new Address(street, city, state, zip);
        customerListStateManager.removeCustomer(customer);
        customer.setAddress(newAddress);
        customerListStateManager.addCustomer(customer);
        finish();
    }
}
