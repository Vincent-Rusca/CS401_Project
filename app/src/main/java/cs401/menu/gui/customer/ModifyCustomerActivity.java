package cs401.menu.gui.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.CustomerListRVA;

public class ModifyCustomerActivity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    Customer customer;
    CustomerListRVA customerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer);

        CustomerList customerList = (CustomerList) getIntent().getSerializableExtra("customerList");
        RecyclerView recyclerView = findViewById(R.id.modifyCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRVA(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        customer = customerListAdapter.getItem(position);
        // TODO: make the selected item be highlighted instead of displaying it like this
        Toast.makeText(this, "selected " + customer.getCustomerName(), Toast.LENGTH_LONG).show();
    }

    public void modifyName(View view) {
        // TODO
    }

    public void modifyAddress(View view) {
        // TODO
    }

    public void addOrder(View view) {
        // TODO
    }

    public void modifyOrder(View view) {
        // TODO
    }

    public void removeOrder(View view) {
        // TODO
    }
}
