package cs401.menu.gui.customer;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.CustomerListRVA;
import cs401.menu.gui.CustomerListStateManager;

public class DisplayCustomerActivity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    CustomerListRVA customerListAdapter;
    RecyclerView recyclerView;
    CustomerList customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_customer);

        customerList = CustomerListStateManager.getInstance().getCustomerList();
        recyclerView = findViewById(R.id.displayCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRVA(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    private String buildStringMessage(Customer customer) {
        Resources resources = getResources();
        StringBuilder builder = new StringBuilder();
        String name = resources.getString(R.string.customer_name) + " " + customer.getCustomerName() + "\n";
        String id = resources.getString(R.string.customer_id) + " " + customer.getCustomerID() + "\n";
        String street = resources.getString(R.string.customer_street) + " " + customer.getAddress().getStreetAddress() + "\n";
        String city = resources.getString(R.string.customer_city) + " " + customer.getAddress().getCityAddress() + "\n";
        String state = resources.getString(R.string.customer_state) + " " + customer.getAddress().getStateAddress() + "\n";
        String zip = resources.getString(R.string.customer_zip) + " " + customer.getAddress().getZipAddress();
        builder.append(name);
        builder.append(id);
        builder.append(street);
        builder.append(city);
        builder.append(state);
        builder.append(zip);
        // TODO: append all orders to the end of this (medium priority)
        return builder.toString();
    }

    @Override
    public void onItemClick(View view, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Customer customer = customerListAdapter.getItem(position);
        builder.setTitle(R.string.customer_display_title).setMessage(buildStringMessage(customer));
        builder.create().show();
    }

    // TODO: make this work and copy-paste to other places with customer displays (medium priority)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.cust_sort_by_name:
                customerList.sortByName();
                customerListAdapter = new CustomerListRVA(this, customerList);
                customerListAdapter.setClickListener(this);
                recyclerView.setAdapter(customerListAdapter);
                return true;

            case R.id.cust_sort_by_id:
                customerList.sortByID();
                customerListAdapter = new CustomerListRVA(this, customerList);
                customerListAdapter.setClickListener(this);
                recyclerView.setAdapter(customerListAdapter);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
