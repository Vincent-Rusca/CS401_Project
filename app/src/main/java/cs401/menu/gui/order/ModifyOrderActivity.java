package cs401.menu.gui.order;

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

import cs401.Customers.Customer;
import cs401.Orders.Order;
import cs401.Orders.OrderList;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.order.modify.ModifyOrderCostActivity;
import cs401.menu.gui.order.modify.ModifyOrderDescriptionActivity;
import cs401.menu.gui.order.modify.ModifyOrderInvoiceActivity;
import cs401.menu.gui.order.modify.ModifyOrderNameActivity;
import cs401.menu.gui.order.modify.ModifyOrderQuantityActivity;

public class ModifyOrderActivity extends AppCompatActivity implements OrderListRecyclerViewAdapter.ItemClickListener {

    OrderListRecyclerViewAdapter orderListRecyclerViewAdapter;
    Customer customer;
    int customerIndex;
    int orderIndex;
    Order order;
    OrderList orderList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_order);

        customerIndex = (Integer) getIntent().getSerializableExtra("index");
        customer = CustomerListStateManager.getInstance().getCustomer(customerIndex);
        orderList = customer.getOrderList();
        recyclerView = findViewById(R.id.modifyOrderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderListRecyclerViewAdapter = new OrderListRecyclerViewAdapter(this, orderList);
        orderListRecyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(orderListRecyclerViewAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        order = orderListRecyclerViewAdapter.getItem(position);
        orderIndex = position;
        Toast.makeText(this, "selected " + order.getItemName(), Toast.LENGTH_LONG).show();
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

    // TODO: sometimes these crash for unknown reasons... (low priority)
    // might be crashing because the intent is the same name for each
        // TODO: verify if fixed
    public void modifyName(View view) {
        Intent intentModifyName = new Intent(this, ModifyOrderNameActivity.class);
        intentModifyName.putExtra("customerIndex", customerIndex);
        intentModifyName.putExtra("orderIndex", orderIndex);
        startActivity(intentModifyName);
    }

    public void modifyCost(View view) {
        Intent intentModifyCost = new Intent(this, ModifyOrderCostActivity.class);
        intentModifyCost.putExtra("customerIndex", customerIndex);
        intentModifyCost.putExtra("orderIndex", orderIndex);
        startActivity(intentModifyCost);
    }

    public void modifyQuantity(View view) {
        Intent intentModifyQuantity = new Intent(this, ModifyOrderQuantityActivity.class);
        intentModifyQuantity.putExtra("customerIndex", customerIndex);
        intentModifyQuantity.putExtra("orderIndex", orderIndex);
        startActivity(intentModifyQuantity);
    }

    public void modifyInvoice(View view) {
        Intent intentModifyInvoice = new Intent(this, ModifyOrderInvoiceActivity.class);
        intentModifyInvoice.putExtra("customerIndex", customerIndex);
        intentModifyInvoice.putExtra("orderIndex", orderIndex);
        startActivity(intentModifyInvoice);
    }

    public void modifyDescription(View view) {
        Intent intentModifyInvoice = new Intent(this, ModifyOrderDescriptionActivity.class);
        intentModifyInvoice.putExtra("customerIndex", customerIndex);
        intentModifyInvoice.putExtra("orderIndex", orderIndex);
        startActivity(intentModifyInvoice);
    }
}
