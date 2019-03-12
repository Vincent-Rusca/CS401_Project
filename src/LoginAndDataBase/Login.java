package LoginAndDataBase;

import java.io.Serializable;
import java.util.Scanner;

public class Login implements Serializable {
    private UserAccounts username;
    private UserAccounts password;
    private String usr;
    private String pwd;

    public Login()
    {
        this.usr = new String();
        this.pwd = new String();
        this.username = new UserAccounts();
        this.password = new UserAccounts();
    }
    public Login(DataBase usr, DataBase pwd, UserAccounts username, UserAccounts password)
    {
        usr = usr;
        pwd = pwd;
        username = username;
        password = password;
    }

    public void setUsr(DataBase usr) {
        usr = usr;
    }

    public void setPwd(DataBase pwd) {
        pwd = pwd;
    }

    public String getUsr(String user) {
        usr = user;
        return usr;
    }

    public String getPwd(String pass) {
        pwd = pass;
        return pwd;
    }

    public void login()
    {
        String dataTest = "";
        DataBase testFiles = new DataBase();
        testFiles.loadUserAccounts();
        UserAccounts testua = new UserAccounts();
        Login test = new Login();
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

                if(testua.getUsername().equals(test.getUsr(usr))  ) {
                    if(testua.getPassword().equals(test.getPwd(pwd)))
                    {
                        System.out.println("Login Successful");
                    }
                    else {
                        System.out.println("Wrong Password");
                    }
                }
                else if (!testua.getUsername().trim().equals(test.getUsr(usr)))
                {
                    System.out.println("User Does NOT Exist. Please Register");
                }

            }
            else if ( input == 2) {
                // Create User Function Here
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

}
