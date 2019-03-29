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

import cs401.Orders.OrderList;
import cs401.R;

import cs401.menu.gui.order.OrderListRecyclerViewAdapter;

public class Order_Activity extends AppCompatActivity implements OrderListRecyclerViewAdapter.ItemClickListener {
    OrderListRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    OrderList orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_menu);

        orderList = (OrderList)getIntent().getExtras().getSerializable("orderList");

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
        inflater.inflate(R.menu.menu_order_sort, menu);

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

//            case R.id.activity_add_customer:
//                Intent intentAddCustomer = new Intent(this, AddCustomerActivity.class);
//                //intentAddCustomer.putExtra("customerList", customerList);
//                startActivity(intentAddCustomer);
//                return true;
//
//            case R.id.activity_delete_customer:
//                Intent intentDeleteCustomer = new Intent(this, DeleteCustomerActivity.class);
//                //intentDeleteCustomer.putExtra("customerList", customerList);
//                startActivity(intentDeleteCustomer);
//                return true;
//
//            case R.id.activity_display_customer:
//                Intent intentDisplayCustomer = new Intent(this, DisplayCustomerActivity.class);
//                //intentDisplayCustomer.putExtra("customerList", customerList);
//                startActivity(intentDisplayCustomer);
//                return true;
//
//            case R.id.activity_modify_customer:
//                Intent intentModifyCustomer = new Intent(this, ModifyCustomerActivity.class);
//                //intentModifyCustomer.putExtra("customerList", customerList);
//                startActivity(intentModifyCustomer);
//                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

