package cs401.menu.gui.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cs401.Customers.CustomerList;
import cs401.R;

public class DeleteCustomerActivity extends AppCompatActivity implements CustomerListRVA.ItemClickListener {

    CustomerListRVA customerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_customer);

        CustomerList customerList = (CustomerList) getIntent().getSerializableExtra("customerList");
        RecyclerView recyclerView = findViewById(R.id.deleteCustList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerListAdapter = new CustomerListRVA(this, customerList);
        customerListAdapter.setClickListener(this);
        recyclerView.setAdapter(customerListAdapter);
    }

    // TODO: actually save the list being deleted. All this does is delete a copy of the data.
    // This can be done with a singleton class.
    @Override
    public void onItemClick(View view, int position) {
        customerListAdapter.removeItem(position);
    }
}
