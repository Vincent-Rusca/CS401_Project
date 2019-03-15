package LoginAndDataBase;


/*
* Username/password → leads into the menu
* Loading user and its appropriate account info stuff
* Loading the files like the user’s accounts and stuff
*/

import java.io.*;

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

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
    /*Loads the users file specific to their username.
    * If their file doesn't exist it will create one for them
    * and automatically load it for them*/
    public void loadUserAccounts(String user)
    {
        File test = new File("src/database/"+user+".txt").getAbsoluteFile();
        try {
            if(test.isFile()) {
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



    public static void main(String[] args) throws IOException {
        Login test = new Login();
        test.login();
    }
}
