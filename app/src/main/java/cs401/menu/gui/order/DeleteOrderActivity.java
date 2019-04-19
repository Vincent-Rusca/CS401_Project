package cs401.menu.gui.order;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cs401.Customers.Customer;
import cs401.Orders.OrderList;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;

/**
 * delete an order from a customer
 */
public class DeleteOrderActivity extends AppCompatActivity implements OrderListRecyclerViewAdapter.ItemClickListener {

    int customerIndex;
    OrderListRecyclerViewAdapter orderListRecyclerViewAdapter;
    OrderList orderList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_order);

        customerIndex = (Integer) getIntent().getSerializableExtra("index");
        Customer customer = CustomerListStateManager.getInstance().getCustomer(customerIndex);
        orderList = customer.getOrderList();
        recyclerView = findViewById(R.id.deleteOrderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderListRecyclerViewAdapter = new OrderListRecyclerViewAdapter(this, orderList);
        orderListRecyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(orderListRecyclerViewAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        CustomerListStateManager.getInstance().getCustomer(customerIndex).removeFromOrderList(position);
        finish();
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
                orderListRecyclerViewAdapter = new OrderListRecyclerViewAdapter(this, orderList);
                orderListRecyclerViewAdapter.setClickListener(this);
                recyclerView.setAdapter(orderListRecyclerViewAdapter);
                return true;

            case R.id.order_sort_by_newest:
                orderList.orderByNewest();
                orderListRecyclerViewAdapter = new OrderListRecyclerViewAdapter(this, orderList);
                orderListRecyclerViewAdapter.setClickListener(this);
                recyclerView.setAdapter(orderListRecyclerViewAdapter);
                return true;

            case R.id.order_sort_by_oldest:
                orderList.orderByOldest();
                orderListRecyclerViewAdapter = new OrderListRecyclerViewAdapter(this, orderList);
                orderListRecyclerViewAdapter.setClickListener(this);
                recyclerView.setAdapter(orderListRecyclerViewAdapter);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
