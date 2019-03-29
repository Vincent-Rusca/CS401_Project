package cs401.menu.gui.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Orders.Order;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.Modifier;

/**
 * add an order to the customer at the given index
 */
public class AddOrderActivity extends AppCompatActivity implements Modifier {

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = (Integer) getIntent().getSerializableExtra("index");
        setContentView(R.layout.activity_add_order);
    }

    @Override
    public void save(View view) {
        String name = ((EditText) findViewById(R.id.add_order_name)).getText().toString();
        double cost = Double.parseDouble(((EditText) findViewById(R.id.add_order_cost)).getText().toString());
        int quantity = Integer.parseInt(((EditText) findViewById(R.id.add_order_quantity)).getText().toString());
        int invoice = Integer.parseInt(((EditText) findViewById(R.id.add_order_invoice)).getText().toString());
        String description = ((EditText) findViewById(R.id.add_order_description)).getText().toString();
        Order newOrder = new Order(name, cost, quantity, invoice, description);
        CustomerListStateManager.getInstance().getCustomer(index).addToOrderList(newOrder);
    }
}
