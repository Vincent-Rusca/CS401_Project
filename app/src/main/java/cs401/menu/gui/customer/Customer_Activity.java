package cs401.menu.gui.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import cs401.Customers.CustomerList;
import cs401.R;


public class Customer_Activity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    CustomerListRVA adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_menu);

        CustomerList customerList = (CustomerList)getIntent().getExtras().getSerializable("customerList");

        recyclerView = findViewById(R.id.custList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomerListRVA(this, customerList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

        // TODO: NEED TO DECIDE WHAT THIS IS GOING TO SHOW!!!!!

//        Intent customerIntent = new Intent(this, DisplayCustomerActivity.class);
//        customerIntent.putExtra("customer", adapter.getItem(position));
//        startActivity(customerIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.customer_settings, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CustomerList customerList = (CustomerList)getIntent().getExtras().getSerializable("customerList");
        switch(item.getItemId()) {
            case R.id.activity_add_customer:
                Intent customerListIntent = new Intent(this, AddCustomerActivity.class);
                customerListIntent.putExtra("customerList", customerList);
                startActivity(customerListIntent);

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


                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}