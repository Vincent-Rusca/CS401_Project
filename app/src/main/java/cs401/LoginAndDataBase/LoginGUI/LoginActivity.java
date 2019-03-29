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
        validLogin();
    }

    private void validLogin() {
            DataBase userPass = new DataBase();
            try {
                Menu menu = new TextMenu();
                UserAccounts user = new UserAccounts();
                userPass.loadUserAccounts();
                Set<UserAccounts> userAccountsSet = userPass.getUserAccounts();
                String usr = username.getText().toString();
                String pass = password.getText().toString();
                UserAccounts newAccount = new UserAccounts(usr, pass);
                if (userAccountsSet.contains(newAccount)) {
                    Toast.makeText();
                    userPass.loadUserData(usr);
                    Intent mainmenu = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(mainmenu);
                } else {
                    Toast.makeText();
                    System.out.println("Wrong password or User account doesn't exist." +
                            " Please register if the user account doesn't exist.");
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
