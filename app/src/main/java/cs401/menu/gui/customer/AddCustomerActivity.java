package cs401.menu.gui.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cs401.Customers.CustomerList;
import cs401.R;

public class AddCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        CustomerList customerList = (CustomerList)getIntent().getExtras().getSerializable("customerList");

    }

    // TODO functionality
    public void save(View view) {

    }

    public void cancel(View view) {

    }
}
