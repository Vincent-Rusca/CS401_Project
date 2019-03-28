package cs401.menu.gui.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.customer.modify.ModifyCustomerAddressActivity;
import cs401.menu.gui.customer.modify.ModifyCustomerNameActivity;
import cs401.menu.gui.order.AddOrderActivity;
import cs401.menu.gui.order.DeleteOrderActivity;
import cs401.menu.gui.order.ModifyOrderActivity;

public class ModifyCustomerActivity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    Customer customer;
    CustomerListRVA customerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer);

        CustomerList customerList = (CustomerList) getIntent().getSerializableExtra("customerList");
        RecyclerView recyclerView = findViewById(R.id.modifyCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRVA(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        customer = customerListAdapter.getItem(position);
        // TODO: make the selected item be highlighted instead of displaying it like this
        Toast.makeText(this, "selected " + customer.getCustomerName(), Toast.LENGTH_LONG).show();
    }

    public void modifyName(View view) {
        Intent intent = new Intent(this, ModifyCustomerNameActivity.class);
        startActivity(intent);
    }

    public void modifyAddress(View view) {
        Intent intent = new Intent(this, ModifyCustomerAddressActivity.class);
        startActivity(intent);
    }

    public void addOrder(View view) {
        Intent intent = new Intent(this, AddOrderActivity.class);
        startActivity(intent);
    }

    public void modifyOrder(View view) {
        Intent intent = new Intent(this, ModifyOrderActivity.class);
        if (customer.getOrderList().isEmpty()) {
            Toast.makeText(this, "No orders to modify", Toast.LENGTH_SHORT).show();
        } else {
            intent.putExtra("orderList", customer.getOrderList());
            startActivity(intent);
        }
    }

    public void removeOrder(View view) {
        Intent intent = new Intent(this, DeleteOrderActivity.class);
        intent.putExtra("orderList", customer.getOrderList());
        startActivity(intent);
    }
}
