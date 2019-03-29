package cs401.menu.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.customer.AddCustomerActivity;
import cs401.menu.gui.customer.DeleteCustomerActivity;
import cs401.menu.gui.customer.DisplayCustomerActivity;
import cs401.menu.gui.customer.ModifyCustomerActivity;


public class Customer_Activity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    CustomerListRVA adapter;
    RecyclerView recyclerView;
    CustomerList customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_menu);

        customerList = CustomerListStateManager.getInstance().getCustomerList();

        recyclerView = findViewById(R.id.custList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomerListRVA(this, customerList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        Intent openOrders = new Intent(this, Order_Activity.class);
        openOrders.putExtra("orderList", adapter.getItem(position).getOrderList());
        startActivity(openOrders);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_customer_settings, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.cust_sort_by_name:
                customerList.sortByName();
                adapter = new CustomerListRVA(this, customerList);
                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                return true;

            case R.id.cust_sort_by_id:
                customerList.sortByID();
                adapter = new CustomerListRVA(this, customerList);
                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                return true;

            case R.id.activity_add_customer:
                Intent intentAddCustomer = new Intent(this, AddCustomerActivity.class);
                //intentAddCustomer.putExtra("customerList", customerList);
                startActivity(intentAddCustomer);
                return true;

            case R.id.activity_delete_customer:
                Intent intentDeleteCustomer = new Intent(this, DeleteCustomerActivity.class);
                //intentDeleteCustomer.putExtra("customerList", customerList);
                startActivity(intentDeleteCustomer);
                return true;

            case R.id.activity_display_customer:
                Intent intentDisplayCustomer = new Intent(this, DisplayCustomerActivity.class);
                //intentDisplayCustomer.putExtra("customerList", customerList);
                startActivity(intentDisplayCustomer);
                return true;

            case R.id.activity_modify_customer:
                Intent intentModifyCustomer = new Intent(this, ModifyCustomerActivity.class);
                //intentModifyCustomer.putExtra("customerList", customerList);
                startActivity(intentModifyCustomer);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}