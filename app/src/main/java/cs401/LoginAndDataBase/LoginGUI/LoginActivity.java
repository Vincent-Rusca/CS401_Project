package cs401.LoginAndDataBase.LoginGUI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.Set;

import cs401.LoginAndDataBase.DataBase;
import cs401.LoginAndDataBase.Login;
import cs401.LoginAndDataBase.UserAccounts;
import cs401.R;
import cs401.menu.Menu;
import cs401.menu.gui.MenuActivity;
import cs401.menu.text.TextMenu;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText username, password;
    Login test = new Login();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
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
                    //Toast.makeText();
                    userPass.loadUserData(usr);
                    Intent mainmenu = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(mainmenu);
                } else {
                    //Toast.makeText();
                    System.out.println("Wrong password or User account doesn't exist." +
                            " Please register if the user account doesn't exist.");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
}
