package cs401.LoginAndDataBase;
/*
* This class is used to prompt the user for their username and password.
* It is also used to create a new user and a file for them if they do not exist.
* It also contains overrides so the hashSet will work properly.*/

import java.io.*;
import java.util.Scanner;

public class UserAccounts implements Serializable {
    private String username;
    private String password;

    // Constructors
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

    // Getters
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }

    /*Promps the user to input their login name and its checked in the validLogin function.*/
    /*public String promptUsername() {
        Scanner testUser = new Scanner(System.in);
        System.out.println("Username: ");
        username = testUser.next();
        return username;
    }*/

    /*Promps the user to input their password and its checked in the validLogin function.*/
    public String promtPassword() {
        Scanner testPass = new Scanner(System.in);
        System.out.println("Password: ");
        password = testPass.nextLine();
        return password;
    }

    /* Needed to override the hashcode function because the hash was not generating correctly
    * so it would not call the equals function properly. Since the hash's were not equal that's
    * why it needed to be overrode with XOR*/
    @Override
    public int hashCode()
    {
        return username.hashCode() ^ password.hashCode();
    }

    /* Had to override the equal function so it would compare the two objects rather than treating
    * it as ==.*/
    @Override
    public boolean equals(Object other)
    {
        final UserAccounts user = (UserAccounts) other;
        return username.equals(user.getUsername()) && password.equals(user.getPassword());
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
        File uaFile = new File("app/src/main/java/cs401/database/useraccount.txt").getAbsoluteFile();
        BufferedWriter saveUser = new BufferedWriter(new FileWriter(uaFile,true));
        /*ON MAC/LINUS REMOVE \r. \r IS ONLY ON WINDOWS SYSTEMS*/
        String save = setUser +":"+setPass+"\r\n";
        saveUser.write(save);
        saveUser.close();
        newFile.loadUserData(setUser);
        System.out.println("User Created");
    }

}
