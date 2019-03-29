package cs401.menu.gui.order.modify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cs401.Customers.Customer;
import cs401.Orders.Order;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.Modifier;

/**
 * modify an order's cost
 */
public class ModifyOrderCostActivity extends AppCompatActivity implements Modifier {

    int customerIndex;
    int orderIndex;
    Customer customer;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_order_cost);
        customerIndex = (Integer) getIntent().getSerializableExtra("customerIndex");
        orderIndex = (Integer) getIntent().getSerializableExtra("orderIndex");
        customer = CustomerListStateManager.getInstance().getCustomer(customerIndex);
        order = CustomerListStateManager.getInstance().getCustomer(customerIndex).getOrderList().getOrderByIndex(orderIndex);
    }

    @Override
    public void save(View view) {
        CustomerListStateManager customerListStateManager = CustomerListStateManager.getInstance();
        customerListStateManager.removeCustomer(customerIndex);
        double cost = Double.parseDouble(((EditText) findViewById(R.id.modify_order_cost)).getText().toString());
        customer.removeFromOrderList(orderIndex);
        order.setCost(cost);
        customer.addToOrderList(order);
        customerListStateManager.addCustomer(customer);
        finish();
    }
}
