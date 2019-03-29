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

import cs401.LoginAndDataBase.Database.DatabaseHelper;
import cs401.R;

public class RegisterActivity extends AppCompatActivity {
    private Button signup;
    private EditText username, password;
    String UserHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    String SQLiteDBQueryHolder;
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;
    Cursor cursor;
    String F_Result = "Not Found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.regusername);
        password = (EditText) findViewById(R.id.regpassword);
        signup = (Button) findViewById(R.id.signupbtn);
        //sqLiteOpenHelper = new SQLiteHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                addUser(user,pass);
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                Intent returnlogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(returnlogin);

            }
        });
    }
    public void addUser(String user, String pass)
    {




        /*db = openHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COL_1,user);
        cv.put(DatabaseHelper.COL_2,pass);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, cv);*/

    }
}
