package cs401.menu.gui.customer.modify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;

public class ModifyCustomerAddressActivity extends AppCompatActivity {

    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer_address);
        int index = (Integer) getIntent().getSerializableExtra("customer");
        customer = CustomerListStateManager.getInstance().getCustomer(index);
    }

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
