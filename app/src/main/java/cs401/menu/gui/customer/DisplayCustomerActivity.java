package cs401.menu.gui.customer;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.Orders.Order;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;

/**
 * display a list of all the customers
 */
public class DisplayCustomerActivity extends AppCompatActivity implements CustomerListRecyclerViewActivity.ItemClickListener {

    CustomerListRecyclerViewActivity customerListAdapter;
    RecyclerView recyclerView;
    CustomerList customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_customer);

        customerList = CustomerListStateManager.getInstance().getCustomerList();
        recyclerView = findViewById(R.id.displayCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRecyclerViewActivity(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    /**
     * build the message to display to the user
     * @param customer customer to get info from
     * @return a string used to display the customer's info
     */
    private String buildStringMessage(Customer customer) {
        Resources resources = getResources();
        StringBuilder builder = new StringBuilder();
        String name = resources.getString(R.string.customer_name) + " " + customer.getCustomerName() + "\n";
        String id = resources.getString(R.string.customer_id) + " " + customer.getCustomerID() + "\n";
        String street = resources.getString(R.string.customer_street) + " " + customer.getAddress().getStreetAddress() + "\n";
        String city = resources.getString(R.string.customer_city) + " " + customer.getAddress().getCityAddress() + "\n";
        String state = resources.getString(R.string.customer_state) + " " + customer.getAddress().getStateAddress() + "\n";
        String zip = resources.getString(R.string.customer_zip) + " " + customer.getAddress().getZipAddress() + "\n";
        builder.append(name);
        builder.append(id);
        builder.append(street);
        builder.append(city);
        builder.append(state);
        builder.append(zip);
        builder.append("\nOrders:\n");
        for (Order order : customer.getOrderList().getOrderList()) {
            String orderName = "Name: " + order.getItemName() + "\n";
            String orderCost = "Cost: " + order.getCost() + "\n";
            String orderQuantity = "Quantity: " + order.getQuantity() + "\n";
            String orderInvoice = "Invoice Number: " + order.getInvoiceNumber() + "\n";
            String orderDescription = "Description: " + order.getItemDescr() + "\n";
            builder.append(orderName);
            builder.append(orderCost);
            builder.append(orderQuantity);
            builder.append(orderInvoice);
            builder.append(orderDescription);
        }
        return builder.toString();
    }

    @Override
    public void onItemClick(View view, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Customer customer = customerListAdapter.getItem(position);
        builder.setTitle(R.string.customer_display_title).setMessage(buildStringMessage(customer));
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_customer_sort, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cust_sort_by_name:
                customerList.sortByName();
                customerListAdapter = new CustomerListRecyclerViewActivity(this, customerList);
                customerListAdapter.setClickListener(this);
                recyclerView.setAdapter(customerListAdapter);
                return true;

            case R.id.cust_sort_by_id:
                customerList.sortByID();
                customerListAdapter = new CustomerListRecyclerViewActivity(this, customerList);
                customerListAdapter.setClickListener(this);
                recyclerView.setAdapter(customerListAdapter);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
