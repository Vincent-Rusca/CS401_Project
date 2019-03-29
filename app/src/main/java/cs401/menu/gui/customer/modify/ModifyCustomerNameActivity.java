package cs401.menu.gui.customer.modify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.CustomerListRVA;
import cs401.menu.gui.CustomerListStateManager;

public class ModifyCustomerNameActivity extends AppCompatActivity {

    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer_name);
        int index = (Integer) getIntent().getSerializableExtra("customer");
        customer = CustomerListStateManager.getInstance().getCustomer(index);
    }

    public void save(View view) {
        CustomerListStateManager customerListStateManager = CustomerListStateManager.getInstance();
        customerListStateManager.removeCustomer(customer);
        String name = ((EditText) findViewById(R.id.modify_customer_name)).getText().toString();
        customer.setCustomerName(name);
        customerListStateManager.addCustomer(customer);
        finish();
    }
}
