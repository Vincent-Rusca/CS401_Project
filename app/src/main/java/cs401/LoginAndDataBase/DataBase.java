package cs401.LoginAndDataBase;


/*This class is used to create user files and load user files once they are logged in.
* The data isn't saved to the files yet but that will be implemented
* in another assignment (save function).*/

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DataBase extends Activity implements Serializable {
    private Set<UserAccounts> set = new HashSet<>();

    /*Loads the users file specific to their username.
    * If their file doesn't exist it will create one for them
    * and automatically load it for them.
    * This will eventually load the users data that they have saved.
    * This was put in for future functionality for the project. */
    public void loadUserData(String user)
    {
        File test = new File("app/src/main/assets/"+user+".txt").getAbsoluteFile();
        try {
            if(test.isFile()) {
                /*This will eventually load the users data that they have saved.
                * This was put in for future functionality for the project.
                * This is used when a new user */
                BufferedReader fileRead = new BufferedReader(new FileReader(test));
            }
            else if(!test.isFile())
            {
                test.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*This is used to load the useraccounts.txt file into a hashSet so we are able
    * to compare it for the validLogin function in the Login class*/
    public void loadUserAccounts() throws IOException {
        InputStream inputStream = getAssets().open("useraccount.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //File test = new File("app/src/main/assets/useraccount.txt").getAbsoluteFile();
        Scanner userdata = new Scanner(bufferedReader);
        userdata.useDelimiter(":|\\r\\n");
        while (userdata.hasNext()){
            String username = userdata.nextLine();
            String password = userdata.nextLine();
            set.add(new UserAccounts(username,password));
        }

    }
    /*Used to get the useraccounts hashSet*/
    public Set<UserAccounts> getUserAccounts() { return set; }
}
