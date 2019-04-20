package cs401.menu.gui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cs401.Customers.Customer;
import cs401.Orders.Order;
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
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_menu);
        index = (Integer) getIntent().getSerializableExtra("index");
//        customer = (Customer)getIntent().getExtras().getSerializable("index");
        customer = CustomerListStateManager.getInstance().getCustomer(index);
        orderList = customer.getOrderList();

        recyclerView = findViewById(R.id.orderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderListRecyclerViewAdapter(this, orderList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        final int thePosition = position;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (!adapter.getItem(position).isFulfilled()) {
            builder.setTitle("Fulfillment Status")
                    .setMessage("Do you want to mark this order as fulfilled?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            customer.getOrderList().getOrderList().get(thePosition).fulfillOrder();
                            //adapter.update();
                            adapter.notifyItemChanged(thePosition);
                            //recyclerView.setAdapter(adapter);
                        }
                    })
                    .setNegativeButton("No", null);
        } else {
            builder.setTitle("Fulfillment Status")
                    .setMessage("This order has been fulfilled already.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
        }
        builder.create().show();
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
                intentAddOrder.putExtra("index", index);
                startActivity(intentAddOrder);
                return true;

            case R.id.activity_delete_order:
                Intent intentDeleteOrder = new Intent(this, DeleteOrderActivity.class);
                intentDeleteOrder.putExtra("index", index);
                startActivity(intentDeleteOrder);
            return true;

            case R.id.activity_modify_order:
                Intent intentModifyOrder = new Intent(this, ModifyOrderActivity.class);
                intentModifyOrder.putExtra("index", index);
                startActivity(intentModifyOrder);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

