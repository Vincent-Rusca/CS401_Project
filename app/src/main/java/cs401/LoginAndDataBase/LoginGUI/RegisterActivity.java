package cs401.LoginAndDataBase.LoginGUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import cs401.LoginAndDataBase.Database.DatabaseHelper;
import cs401.LoginAndDataBase.Database.User;
import cs401.R;

/* The purpose of this class is so that user's are able to create accounts for themselves.
* The will have the Registration activity pop up if the choose it from the login screen.*/

public class RegisterActivity extends AppCompatActivity {
    private Button signup;
    private EditText username, password, password2;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        /*Username and Password Text boxes*/
        username = (EditText) findViewById(R.id.regusername);
        password = (EditText) findViewById(R.id.regpassword);
        /*SignUp button*/
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
                    String userCheck = databaseHelper.searchUser(user);
                    // Checks to see if the username already exists
                    if(user.equals(userCheck)){
                        Toast nopass = Toast.makeText(RegisterActivity.this, "User Already Exists", Toast.LENGTH_SHORT);
                        nopass.show();
                    }

                    // Checks to see if the passwords are equal
                    else if (!pass.equals(pass2)) {
                        Toast nopass = Toast.makeText(RegisterActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                        nopass.show();
                    }
                    // Adds the username and password to the database
                    else {
                        User u = new User();
                        u.setUsername(user);
                        u.setPassword(pass);
                        databaseHelper.addUser(u);
                        Intent returnToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(returnToLogin);
                    }

                }
            }
        });

    }

}

