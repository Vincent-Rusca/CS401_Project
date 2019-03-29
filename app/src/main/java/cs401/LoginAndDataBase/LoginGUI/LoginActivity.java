package cs401.LoginAndDataBase.LoginGUI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cs401.LoginAndDataBase.Database.DatabaseHelper;
import cs401.R;
import cs401.menu.gui.MenuActivity;


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
                        Intent menu = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(menu);
                    } else {
                        Toast nopass = Toast.makeText(LoginActivity.this, "Username and Password don't match!", Toast.LENGTH_SHORT);
                        nopass.show();
                    }

                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(reg);
            }
        });

    }
}
