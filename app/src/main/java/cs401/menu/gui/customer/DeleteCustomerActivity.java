package cs401.menu.gui.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cs401.Customers.CustomerList;
import cs401.R;
import cs401.menu.gui.CustomerListRVA;
import cs401.menu.gui.CustomerListStateManager;

public class DeleteCustomerActivity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    CustomerListRVA customerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_customer);

        CustomerList customerList = CustomerListStateManager.getInstance().getCustomerList();
        RecyclerView recyclerView = findViewById(R.id.deleteCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRVA(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        CustomerListStateManager.getInstance().removeCustomer(position);
    }
}
