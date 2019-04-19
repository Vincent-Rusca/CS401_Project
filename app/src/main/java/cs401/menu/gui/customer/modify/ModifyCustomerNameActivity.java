package cs401.menu.gui.customer.modify;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import cs401.Customers.Customer;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.Modifier;

/**
 * modify a customer's name
 */
public class ModifyCustomerNameActivity extends AppCompatActivity implements Modifier {

    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer_name);
        int index = (Integer) getIntent().getSerializableExtra("customer");
        customer = CustomerListStateManager.getInstance().getCustomer(index);
    }

    @Override
    public void save(View view) {
        CustomerListStateManager customerListStateManager = CustomerListStateManager.getInstance();
        customerListStateManager.removeCustomer(customer);
        String name = ((EditText) findViewById(R.id.modify_customer_name)).getText().toString();
        customer.setCustomerName(name);
        customerListStateManager.addCustomer(customer);
        finish();
    }
}
