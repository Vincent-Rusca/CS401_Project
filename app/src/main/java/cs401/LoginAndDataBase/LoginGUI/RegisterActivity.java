package cs401.LoginAndDataBase.LoginGUI;

import android.app.Activity;
import android.content.ContentValues;
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

import cs401.LoginAndDataBase.Database.DatabaseHelper;
import cs401.LoginAndDataBase.Database.User;
import cs401.R;

public class RegisterActivity extends AppCompatActivity {
    private Button signup;
    private EditText username, password, password2;
    Boolean EditTextEmptyHolder;
    String SQLiteDBQueryHolder;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.regusername);
        password = (EditText) findViewById(R.id.regpassword);
        signup = (Button) findViewById(R.id.signupbtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.signupbtn) {

                    username = (EditText) findViewById(R.id.regusername);
                    password = (EditText) findViewById(R.id.regpassword);
                    password2 = (EditText) findViewById(R.id.regpassword2);

                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    String pass2 = password2.getText().toString();

                    // Checks to see if the passwords are equal
                    if (!pass.equals(pass2)) {
                        Toast nopass = Toast.makeText(RegisterActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                        nopass.show();
                    }
                    else {
                        // Add user to database
                        User u = new User();
                        u.setUsername(user);
                        u.setPassword(pass);
                        databaseHelper.addUser(u);
                        Intent returnToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(returnToLogin);
                    }

                }
                /*String user = username.getText().toString();
                String pass = password.getText().toString();
                User u = new User();
                u.setUsername(user);
                u.setPassword(pass);*//*
                //databaseHelper.addLogin(new User(user,pass));
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                Intent returnlogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(returnlogin);*/

            }
        });

    }

}


/*
        username = (EditText) findViewById(R.id.regusername);
        password = (EditText) findViewById(R.id.regpassword);
        signup = (Button) findViewById(R.id.signupbtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*String user = username.getText().toString();
                String pass = password.getText().toString();
                User u = new User();
                u.setUsername(user);
                u.setPassword(pass);*//*
                //databaseHelper.addLogin(new User(user,pass));
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                Intent returnlogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(returnlogin);

            }
        });*/
