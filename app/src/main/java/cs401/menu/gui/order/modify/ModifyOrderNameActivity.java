package cs401.menu.gui.order.modify;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import cs401.Customers.Customer;
import cs401.Orders.Order;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.Modifier;

/**
 * modify an order's name
 */
public class ModifyOrderNameActivity extends AppCompatActivity implements Modifier {

    int customerIndex;
    int orderIndex;
    Customer customer;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_order_name);
        customerIndex = (Integer) getIntent().getSerializableExtra("customerIndex");
        orderIndex = (Integer) getIntent().getSerializableExtra("orderIndex");
        customer = CustomerListStateManager.getInstance().getCustomer(customerIndex);
        order = CustomerListStateManager.getInstance().getCustomer(customerIndex).getOrderList().getOrderByIndex(orderIndex);
    }

    @Override
    public void save(View view) {
        CustomerListStateManager customerListStateManager = CustomerListStateManager.getInstance();
        customerListStateManager.removeCustomer(customerIndex);
        String name = ((EditText) findViewById(R.id.modify_order_name)).getText().toString();
        customer.removeFromOrderList(orderIndex);
        order.setItemName(name);
        customer.addToOrderList(order);
        customerListStateManager.addCustomer(customer);
        finish();
    }
}
