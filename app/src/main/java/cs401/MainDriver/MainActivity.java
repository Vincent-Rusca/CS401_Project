package cs401.MainDriver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import cs401.LoginAndDataBase.Database.DatabaseHelper;
import cs401.LoginAndDataBase.Database.User;
import cs401.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper db = new DatabaseHelper(this);

        Log.d("Adding:", "Adding...");
        db.addLogin(new User("Juan","pablo"));
        db.addLogin(new User("Test","user"));
        db.addLogin(new User("Fabio","dog"));
        db.addLogin(new User("Neil","diamond"));
        db.addLogin(new User("Lord", "fabio"));

        Log.d("Reading:", "Reading...");
        List<User> userList = db.getAllLogins();

        for (User usr: userList){
            String log = "ID: " + usr.getId() + " ,Username: " + usr.getUsername() + " ,Password"
                    + usr.getPassword();
            Log.d("Name: ",log);
        }
    }
}
