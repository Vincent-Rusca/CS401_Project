package cs401.LoginAndDataBase.LoginGUI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validLogin();
            }
        });
    }

    private void validLogin() {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.equals("admin") && pass.equals("admin")) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent mainmenu = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(mainmenu);
        } else
            Toast.makeText(this, "Unsuccessful", Toast.LENGTH_SHORT).show();
        //DataBase userPass = new DataBase();
            /*try {
                Menu menu = new TextMenu();
                UserAccounts user = new UserAccounts();
                userPass.loadUserAccounts();
                Set<UserAccounts> userAccountsSet = userPass.getUserAccounts();
                String usr = username.getText().toString();
                String pass = password.getText().toString();
                UserAccounts newAccount = new UserAccounts(usr, pass);
                if (userAccountsSet.contains(newAccount)) {
                    Toast.makeText(this,"Login Sucessful",Toast.LENGTH_SHORT).show();
                    userPass.loadUserData(usr);
                    Intent mainmenu = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(mainmenu);
                } else {
                    Toast.makeText(this,"Wrong password or User account doesn't exist." +
                            "                            Please register if the user account doesn't exist.",Toast.LENGTH_SHORT).show();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
    }
}
