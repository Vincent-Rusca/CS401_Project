package cs401.menu.gui.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cs401.Customers.Customer;
import cs401.Orders.OrderList;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;

// TODO: class is incomplete, needs a save button in the layout and functionality for that button
// TODO see modify order class for inspiration (high priority)
public class DeleteOrderActivity extends AppCompatActivity implements OrderListRecyclerViewAdapter.ItemClickListener {

    int customerIndex;
    OrderListRecyclerViewAdapter orderListRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_order);

        customerIndex = (Integer) getIntent().getSerializableExtra("index");
        Customer customer = CustomerListStateManager.getInstance().getCustomer(customerIndex);
        OrderList orderList = customer.getOrderList();
        RecyclerView recyclerView = findViewById(R.id.deleteOrderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderListRecyclerViewAdapter = new OrderListRecyclerViewAdapter(this, orderList);
        orderListRecyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(orderListRecyclerViewAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        CustomerListStateManager.getInstance().getCustomer(customerIndex).removeFromOrderList(position);
    }
}
