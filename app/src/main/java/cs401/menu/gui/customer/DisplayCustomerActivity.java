package cs401.menu.gui.customer;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.CustomerListRVA;

public class DisplayCustomerActivity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    CustomerListRVA customerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_customer);

        CustomerList customerList = (CustomerList) getIntent().getSerializableExtra("customerList");
        RecyclerView recyclerView = findViewById(R.id.displayCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRVA(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    // TODO: replace with something cleaner
    private String buildStringMessage(Customer customer) {
        Resources resources = getResources();
        return resources.getString(R.string.customer_name) + " " + customer.getCustomerName() + "\n" +
                resources.getString(R.string.customer_id) + " " + customer.getCustomerID() + "\n" +
                resources.getString(R.string.customer_street) + " " + customer.getAddress().getStreetAddress() + "\n" +
                resources.getString(R.string.customer_city) + " " + customer.getAddress().getCityAddress() + "\n" +
                resources.getString(R.string.customer_state) + " " + customer.getAddress().getStateAddress() + "\n" +
                resources.getString(R.string.customer_zip) + " " + customer.getAddress().getZipAddress();
    }

    // TODO: display orders as well in the popup
    @Override
    public void onItemClick(View view, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Customer customer = customerListAdapter.getItem(position);
        builder.setTitle(R.string.customer_display_title).setMessage(buildStringMessage(customer));
        builder.create().show();
    }
}
