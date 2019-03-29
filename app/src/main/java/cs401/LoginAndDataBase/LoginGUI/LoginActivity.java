package cs401.LoginAndDataBase.LoginGUI;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.Set;

import cs401.LoginAndDataBase.DataBase;
import cs401.LoginAndDataBase.Database.DatabaseHelper;
import cs401.LoginAndDataBase.UserAccounts;
import cs401.R;
import cs401.menu.Menu;
import cs401.menu.gui.MenuActivity;
import cs401.menu.text.TextMenu;


public class LoginActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;
    DatabaseHelper databaseHelper;
    private Button login, register;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // openHelper = new DatabaseHelper(this);
        // db = openHelper.getReadableDatabase();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.loginbtn);
        register = (Button) findViewById(R.id.registerbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
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

    /*private void login(){
        DataBase userPass = new DataBase();
        Menu menu = new TextMenu();
        UserAccounts user = new UserAccounts();
        try {
            userPass.loadUserAccounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<UserAccounts> userAccountsSet = userPass.getUserAccounts();
        String usr = username.getText().toString();
        String pwd = password.getText().toString();
        UserAccounts newAccount = new UserAccounts(usr, pwd);
        if (userAccountsSet.contains(newAccount)) {
            Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
            //System.out.println("Login Successful");
            userPass.loadUserData(usr);
            menu.start();
        } else {
            Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_LONG).show();
            // System.out.println("Wrong password or User account doesn't exist." +
            //         " Please register if the user account doesn't exist.");
        }
    }*/

    public void login(){
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if (user.equals("test") && pass.equals("test")) {
            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
            Intent menu = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(menu);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_LONG).show();
        }
    }

}



       /* databaseHelper = new DatabaseHelper(LoginActivity.this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                cursor = db.rawQuery("SELECT * FROM "+DatabaseHelper.TABLE_NAME+ " WHERE " + DatabaseHelper.COL_1+"=? " + DatabaseHelper.COL_2+"=? ", new String[]{user,pass});
                if(cursor != null){
                    if(cursor.getCount() > 0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                        Intent menu = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(menu);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerUser = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerUser);
            }
        });
        }

    }*/


    /*private void validLogin() throws IOException {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        DataBase test = new DataBase();
        test.loadUserAccounts();

        if (user.equals("admin") && pass.equals("admin")) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent mainmenu = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(mainmenu);
        } else
            Toast.makeText(this, "Unsuccessful", Toast.LENGTH_SHORT).show();
        //DataBase userPass = new DataBase();
            *//*try {
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
            }*//*
    }*/
