package cs401.menu.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cs401.Customers.Customer;
import cs401.Orders.OrderList;
import cs401.R;

import cs401.menu.gui.order.AddOrderActivity;
import cs401.menu.gui.order.DeleteOrderActivity;
import cs401.menu.gui.order.ModifyOrderActivity;
import cs401.menu.gui.order.OrderListRecyclerViewAdapter;

public class Order_Activity extends AppCompatActivity implements OrderListRecyclerViewAdapter.ItemClickListener {
    OrderListRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    Customer customer;
    OrderList orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_menu);

        customer = (Customer)getIntent().getExtras().getSerializable("customer");
        orderList = customer.getOrderList();

        recyclerView = findViewById(R.id.orderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderListRecyclerViewAdapter(this, orderList);
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
        inflater.inflate(R.menu.menu_order_settings, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.order_sort_by_name:
                orderList.orderByName();
                adapter = new OrderListRecyclerViewAdapter(this, orderList);
                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                return true;

            case R.id.order_sort_by_newest:
                orderList.orderByNewest();
                adapter = new OrderListRecyclerViewAdapter(this, orderList);
                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                return true;

            case R.id.order_sort_by_oldest:
                orderList.orderByOldest();
                adapter = new OrderListRecyclerViewAdapter(this, orderList);
                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                return true;

            case R.id.activity_add_order:
                Intent intentAddOrder = new Intent(this, AddOrderActivity.class);
                //intentAddOrder.putExtra("index", customer);
                startActivity(intentAddOrder);
                return true;

            case R.id.activity_delete_order:
                Intent intentDeleteOrder = new Intent(this, DeleteOrderActivity.class);
                //intentDeleteOrder.putExtra("index", customer);
                startActivity(intentDeleteOrder);
            return true;

            case R.id.activity_modify_order:
                Intent intentModifyOrder = new Intent(this, ModifyOrderActivity.class);
                //intentModifyOrder.putExtra("index", customer);
                startActivity(intentModifyOrder);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

