package LoginAndDataBase;

import java.io.*;
import java.util.Scanner;

public class UserAccounts implements Serializable {
    private String username;
    private String password;
    // Constructor
    public UserAccounts(){
        this.username = "";
        this.password = "";
    }
    public UserAccounts(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Setters
    public void setUsername(String user) { username = user; }
    public void setPassword(String pass) { password = pass; }

    /*Promps the user to input their login name and its checked in the validLogin function.*/
    public String getUsername() {
        Scanner testUser = new Scanner(System.in);
        System.out.println("Username: ");
        username = testUser.next();
        return username;
    }
    /*Promps the user to input their password and its checked in the validLogin function.*/
    public String getPassword() {
        Scanner testPass = new Scanner(System.in);
        System.out.println("Password: ");
        password = testPass.nextLine();
        return password;
    }
    /*This adds a new user to the useraccount text file.
    * This will also create a file with them that will automatically load when they
    * login. */
    public void addUser() throws IOException {
        DataBase newFile = new DataBase();
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Your Desired Username: ");
        String setUser = input.nextLine();
        System.out.println("Please Enter Your Desired Password: ");
        String setPass = input.nextLine();

        setUsername(setUser);
        setPassword(setPass);
        File uaFile = new File("src/database/useraccount.txt").getAbsoluteFile();
        BufferedWriter saveUser = new BufferedWriter(new FileWriter(uaFile,true));
        String save = setUser +":"+setPass+"\r\n";
        saveUser.write(save);
        saveUser.close();
        newFile.loadUserAccounts(setUser);
        System.out.println("User Created");
    }

}
