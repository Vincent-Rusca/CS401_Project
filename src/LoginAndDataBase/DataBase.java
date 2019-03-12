package LoginAndDataBase;
/*
* A login menu and a database for storing the users and their information
* @author Daniel Glancey
* */

/*
* Username/password → leads into the menu
* Loading user and its appropriate account info stuff
* Loading the files like the user’s accounts and stuff
*/

import java.io.*;
import java.util.Scanner;

public class DataBase implements Serializable {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public DataBase()
    {
       this.fileInputStream = fileInputStream;
       this.fileOutputStream = fileOutputStream;
    }

    public DataBase(FileInputStream fIO, FileOutputStream fOS)
    {
        fileOutputStream = fOS;
        fileInputStream = fIO;
    }

    public void loadUserAccounts()
    {
        //File test = new File("src/database/useraccount.txt").getAbsoluteFile();

        try {
            File test = new File("src/database/useraccount.txt").getAbsoluteFile();
            Login testLog = new Login();
            DataBase testu = new DataBase();
            DataBase testp = new DataBase();
            //UserAccounts testua = new UserAccounts();
            Scanner test1 = new Scanner(test);
            test1.useDelimiter(":|\\n");
            while (test1.hasNext())
            {
                String username = test1.next();
                String password = test1.next();

            }
            test1.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args)
    {
        Login test = new Login();
        test.login();
    }
}
