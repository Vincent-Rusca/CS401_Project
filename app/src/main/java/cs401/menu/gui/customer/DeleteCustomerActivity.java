package cs401.menu.gui.customer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.ViewUpdate;

/**
 * Delete a customer from the list
 */
public class DeleteCustomerActivity extends AppCompatActivity implements CustomerListRecyclerViewActivity.ItemClickListener, ViewUpdate {

    CustomerListRecyclerViewActivity customerListAdapter;
    CustomerList customerList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_customer);

        customerList = CustomerListStateManager.getInstance().getCustomerList();
        recyclerView = findViewById(R.id.deleteCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRecyclerViewActivity(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        CustomerListStateManager.getInstance().removeCustomer(position);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_customer_sort, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cust_sort_by_name:
                customerList.sortByName();
                customerListAdapter = new CustomerListRecyclerViewActivity(this, customerList);
                customerListAdapter.setClickListener(this);
                recyclerView.setAdapter(customerListAdapter);
                return true;

            case R.id.cust_sort_by_id:
                customerList.sortByID();
                customerListAdapter = new CustomerListRecyclerViewActivity(this, customerList);
                customerListAdapter.setClickListener(this);
                recyclerView.setAdapter(customerListAdapter);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void updateView(CustomerList customerList) {
        this.customerList = customerList;
        this.customerListAdapter = new CustomerListRecyclerViewActivity(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }
}
