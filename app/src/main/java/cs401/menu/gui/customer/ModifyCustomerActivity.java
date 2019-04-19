package cs401.menu.gui.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.customer.modify.ModifyCustomerAddressActivity;
import cs401.menu.gui.customer.modify.ModifyCustomerNameActivity;
import cs401.menu.gui.order.AddOrderActivity;
import cs401.menu.gui.order.DeleteOrderActivity;
import cs401.menu.gui.order.ModifyOrderActivity;

/**
 * modify a customer
 */
public class ModifyCustomerActivity extends AppCompatActivity implements CustomerListRecyclerViewActivity.ItemClickListener {

    Customer customer;
    int index;
    CustomerListRecyclerViewActivity customerListAdapter;
    RecyclerView recyclerView;
    CustomerList customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer);

        customerList = CustomerListStateManager.getInstance().getCustomerList();
        recyclerView = findViewById(R.id.modifyCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRecyclerViewActivity(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        customer = customerListAdapter.getItem(position);
        index = position;
        // TODO: make the selected item be highlighted instead of displaying it like this (low priority)
        Toast.makeText(this, "selected " + customer.getCustomerName(), Toast.LENGTH_LONG).show();
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

    // go to the other modify activities
    public void modifyName(View view) {
        Intent intent = new Intent(this, ModifyCustomerNameActivity.class);
        intent.putExtra("customer", index);
        startActivity(intent);
    }

    public void modifyAddress(View view) {
        Intent intent = new Intent(this, ModifyCustomerAddressActivity.class);
        intent.putExtra("customer", index);
        startActivity(intent);
    }

    public void addOrder(View view) {
        Intent intent = new Intent(this, AddOrderActivity.class);
        intent.putExtra("customer", index);
        startActivity(intent);
    }

    public void modifyOrder(View view) {
        if (customer.getOrderList().isEmpty()) {
            Toast.makeText(this, "No orders to modify", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, ModifyOrderActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }

    public void removeOrder(View view) {
        if (customer.getOrderList().isEmpty()) {
            Toast.makeText(this, "No orders to remove", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, DeleteOrderActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}
