package cs401.menu.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import cs401.Customers.CustomerList;
import cs401.R;


public class Customer_Activity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    CustomerListRVA adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_menu);

        CustomerList customerList = (CustomerList)getIntent().getExtras().getSerializable("customerList");

        RecyclerView recyclerView = findViewById(R.id.custList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomerListRVA(this, customerList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.customer_settings, menu);

        return true;
    }

}