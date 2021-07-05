package com.example.cs401groupwork2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cs401groupwork2.orders.OrderList;

public class OrderActivity extends AppCompatActivity implements OrderListRVA.ItemClickListener {
    OrderListRVA adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_menu);    // <<

        OrderList orderList = (OrderList)getIntent().getExtras().getSerializable("orderList");

        recyclerView = findViewById(R.id.orderList);    // <<
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderListRVA(this, orderList);
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
        inflater.inflate(R.menu.order_settings, menu);   // <<

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        OrderList orderList = (OrderList)getIntent().getExtras().getSerializable("orderList");
        switch(item.getItemId()) {
            case R.id.order_sort_by_name:
                orderList.orderByName();
                adapter = new OrderListRVA(this, orderList);
                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
