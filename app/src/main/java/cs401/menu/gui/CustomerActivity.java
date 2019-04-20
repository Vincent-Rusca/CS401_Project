package cs401.menu.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Calendar;
import java.util.GregorianCalendar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.Orders.Order;
import cs401.R;
import cs401.menu.gui.customer.AddCustomerActivity;
import cs401.menu.gui.customer.CustomerListRecyclerViewActivity;
import cs401.menu.gui.customer.DeleteCustomerActivity;
import cs401.menu.gui.customer.DisplayCustomerActivity;
import cs401.menu.gui.customer.ModifyCustomerActivity;


public class CustomerActivity extends AppCompatActivity implements CustomerListRecyclerViewActivity.ItemClickListener {

    CustomerListRecyclerViewActivity adapter;
    RecyclerView recyclerView;
    CustomerList customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_menu);

        customerList = CustomerListStateManager.getInstance().getCustomerList();
        notifyOrderMightBeFilled();

        recyclerView = findViewById(R.id.custList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomerListRecyclerViewActivity(this, customerList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void notifyOrderMightBeFilled() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Calendar now = Calendar.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customerList.getCustomerList()) {
            for (Order order : customer.getOrderList().getOrderList()) {
                if (order.isFulfilled() && now.get(Calendar.YEAR) > order.getYrReceived()) {
                    stringBuilder.append(order.getItemName());
                    stringBuilder.append(" from ");
                    stringBuilder.append(customer.getCustomerName());
                    stringBuilder.append("\n");
                }
            }
        }
        builder.setTitle(R.string.order_display_title).setMessage(stringBuilder.toString());
        builder.create().show();
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Order_Activity.class);
        intent.putExtra("index", position);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_customer_settings, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.cust_sort_by_name:
                customerList.sortByName();
                adapter = new CustomerListRecyclerViewActivity(this, customerList);
                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                return true;

            case R.id.cust_sort_by_id:
                customerList.sortByID();
                adapter = new CustomerListRecyclerViewActivity(this, customerList);
                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                return true;

            case R.id.activity_add_customer:
                Intent intentAddCustomer = new Intent(this, AddCustomerActivity.class);
                //intentAddCustomer.putExtra("customerList", customerList);
                startActivity(intentAddCustomer);
                return true;

            case R.id.activity_delete_customer:
                Intent intentDeleteCustomer = new Intent(this, DeleteCustomerActivity.class);
                //intentDeleteCustomer.putExtra("customerList", customerList);
                startActivity(intentDeleteCustomer);
                return true;

            case R.id.activity_display_customer:
                Intent intentDisplayCustomer = new Intent(this, DisplayCustomerActivity.class);
                //intentDisplayCustomer.putExtra("customerList", customerList);
                startActivity(intentDisplayCustomer);
                return true;

            case R.id.activity_modify_customer:
                Intent intentModifyCustomer = new Intent(this, ModifyCustomerActivity.class);
                //intentModifyCustomer.putExtra("customerList", customerList);
                startActivity(intentModifyCustomer);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}