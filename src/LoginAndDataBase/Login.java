package LoginAndDataBase;

import menu.Menu;
import menu.text.TextMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Login implements Serializable {
    private UserAccounts username;
    private UserAccounts password;
    private String usr;
    private String pwd;
    // Constructor
    public Login()
    {
        this.usr = new String();
        this.pwd = new String();
        this.username = new UserAccounts();
        this.password = new UserAccounts();
    }

    // Setters
    public void setUsr(String user) { usr = user; }
    public void setPwd(String passwd) {
        pwd = passwd;
    }
    // Getters
    public String getUsr() { return usr; }
    public String getPwd() { return pwd; }

    /*This is the login menu for the users.
    * The user will be able to login, register a new account, or exit. */
    public void login() throws IOException {
        UserAccounts testua = new UserAccounts();
        int input;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Select Your Option:");
            System.out.println("1. Login");
            System.out.println("2. Register User");
            System.out.println("3. Exit");
            System.out.println("Selection: ");
            input = scanner.nextInt();

            if (input == 1)
            {
                validLogin();
            }
            else if ( input == 2) {
                testua.addUser();
            }
            else if ( input == 3)
            {
                System.out.println("Goodbye");
                break;
            }

            else {
                System.out.println("Invalid Input");
            }

        } while (input !=3 );
    }

    /*This validates the users login credentials.
    * If the user exists, it will load their user files and got to the menu.
    * If the user doesn't exist, it will ask them to register their account.
    * If the password is wrong they will have to try again.*/
    private void validLogin()
    {
        try {
            DataBase loadUserFile = new DataBase();
            UserAccounts testua = new UserAccounts();
            File test = new File("src/database/useraccount.txt").getAbsoluteFile();
            Scanner test1 = new Scanner(test);
            test1.useDelimiter(":|\\r\\n");
            boolean found = false;
            while (test1.hasNext() && !found)
            {
                String username = test1.next();
                String password = test1.next();
                setUsr(username);
                setPwd(password);
                if (testua.getUsername().equals(getUsr())) {
                    if (testua.getPassword().equals(getPwd())) {
                        System.out.println("Login Successful");
                        found = true;
                        loadUserFile.loadUserAccounts(username);
                        Menu menu = new TextMenu();
                        menu.start();

                    } else {
                        System.out.println("Wrong Password");
                        found = false;
                    }
                } else if (!testua.getUsername().equals(getUsr())) {
                    System.out.println("User Does NOT Exist. Please Register");
                    found = false;
                }
            }
            test1.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
