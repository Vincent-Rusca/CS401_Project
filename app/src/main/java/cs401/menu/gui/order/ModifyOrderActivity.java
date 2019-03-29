package cs401.menu.gui.order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_order);

        customerIndex = (Integer) getIntent().getSerializableExtra("index");
        customer = CustomerListStateManager.getInstance().getCustomer(customerIndex);
        OrderList orderList = customer.getOrderList();
        RecyclerView recyclerView = findViewById(R.id.modifyOrderList);
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

    // TODO implement for orderList and copy this elsewhere (medium priority
    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CustomerList customerList = CustomerListStateManager.getInstance().getCustomerList();
        switch(item.getItemId()) {
            case R.id.cust_sort_by_name:
                customerList.sortByName();
                customerListAdapter = new CustomerListRVA(this, customerList);
                customerListAdapter.setClickListener(this);
                recyclerView.setAdapter(customerListAdapter);
                return true;

            case R.id.cust_sort_by_id:
                customerList.sortByID();
                customerListAdapter = new CustomerListRVA(this, customerList);
                customerListAdapter.setClickListener(this);
                recyclerView.setAdapter(customerListAdapter);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    // TODO: sometimes these crash for unknown reasons... (low priority)
    public void modifyName(View view) {
        Intent intent = new Intent(this, ModifyOrderNameActivity.class);
        intent.putExtra("customerIndex", customerIndex);
        intent.putExtra("orderIndex", orderIndex);
        startActivity(intent);
    }

    public void modifyCost(View view) {
        Intent intent = new Intent(this, ModifyOrderCostActivity.class);
        intent.putExtra("customerIndex", customerIndex);
        intent.putExtra("orderIndex", orderIndex);
        startActivity(intent);
    }

    public void modifyQuantity(View view) {
        Intent intent = new Intent(this, ModifyOrderQuantityActivity.class);
        intent.putExtra("customerIndex", customerIndex);
        intent.putExtra("orderIndex", orderIndex);
        startActivity(intent);
    }

    public void modifyInvoice(View view) {
        Intent intent = new Intent(this, ModifyOrderInvoiceActivity.class);
        intent.putExtra("customerIndex", customerIndex);
        intent.putExtra("orderIndex", orderIndex);
        startActivity(intent);
    }

    public void modifyDescription(View view) {
        Intent intent = new Intent(this, ModifyOrderDescriptionActivity.class);
        intent.putExtra("customerIndex", customerIndex);
        intent.putExtra("orderIndex", orderIndex);
        startActivity(intent);
    }
}
