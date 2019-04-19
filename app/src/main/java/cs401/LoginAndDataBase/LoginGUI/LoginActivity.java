package cs401.LoginAndDataBase.LoginGUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.LoginAndDataBase.Database.DatabaseHelper;
import cs401.Orders.Order;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;
import cs401.menu.gui.CustomerActivity;

/*This is the login screen which is the starting screen for the whole application.
* It will give the users the option to login or to register for an account.
* When the successfully register it will take them back to this screen to login.
* Once they are logged in it will display a menu for them.*/


public class LoginActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    private Button login, register;
    private EditText username, password;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*Username and Password Text boxes*/
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        /*Login Button*/
        login = (Button) findViewById(R.id.loginbtn);
        /*Registration Button*/
        register = (Button) findViewById(R.id.registerbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*This checks if the login button was pressed.
                * If it was then it will take the users name and password.
                * Then it will check to see if the users password is correct.
                * If it is then it will take them to the menu, if not is will give an error message*/
                if (v.getId() == R.id.loginbtn) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    String passCheck = databaseHelper.searchPass(user);
                    if (pass.equals(passCheck)) {
                        generateSampleInput();
                        Intent menu = new Intent(LoginActivity.this, CustomerActivity.class);
                        startActivity(menu);
                    } else {
                        Toast nopass = Toast.makeText(LoginActivity.this, "Username or Password don't match!", Toast.LENGTH_SHORT);
                        nopass.show();
                    }

                }
            }
        });
        /*Takes the user to the registration activity*/
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(reg);
            }
        });

    }

    private void generateSampleInput() {
        if (CustomerListStateManager.getInstance().isEmpty()) {
            Address customerAddress = new Address("123 Easy St.", "Eureka", "CA", "94599");
            Customer newCustomer = new Customer("Test Incorporated LLC", "2", customerAddress);
            newCustomer.addToOrderList(new Order("Zebra", 1100, 20, 98723, "a taco", 2002, 4,1));
            newCustomer.addToOrderList(new Order("Apple", 140, 23, 923423, "a taco2", 2004, 1, 1));
            CustomerListStateManager.getInstance().addCustomer(newCustomer);

            customerAddress = new Address("45 Ocho St.", "Paris", "TX", "54554");
            newCustomer = new Customer("Texas Cheese Toast Co.", "1", customerAddress);
            newCustomer.addToOrderList(new Order("burrito", 13540, 2233, 923, "a burrito", 1986, 2, 2));
            CustomerListStateManager.getInstance().addCustomer(newCustomer);

            customerAddress = new Address("69 Everyone Ln.", "Kansas City", "KS", "54321");
            newCustomer = new Customer("Grundle Properties LLC", "3", customerAddress);
            CustomerListStateManager.getInstance().addCustomer(newCustomer);
        }
    }
}
