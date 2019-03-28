package cs401.menu.gui.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import cs401.Orders.Order;
import cs401.Orders.OrderList;
import cs401.R;

public class ModifyOrderActivity extends AppCompatActivity implements OrderListRecyclerViewAdapter.ItemClickListener {

    OrderListRecyclerViewAdapter orderListRecyclerViewAdapter;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_order);

        OrderList orderList = (OrderList) getIntent().getSerializableExtra("customerList");
        RecyclerView recyclerView = findViewById(R.id.modifyCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderListRecyclerViewAdapter = new OrderListRecyclerViewAdapter(this, orderList);
        orderListRecyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(orderListRecyclerViewAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        order = orderListRecyclerViewAdapter.getItem(position);
        Toast.makeText(this, "selected " + order.getItemName(), Toast.LENGTH_LONG).show();
    }

    public void modifyName(View view) {
    }

    public void modifyCost(View view) {
    }

    public void modifyQuantity(View view) {
    }

    public void modifyInvoice(View view) {
    }

    public void modifyDescription(View view) {
    }
}
