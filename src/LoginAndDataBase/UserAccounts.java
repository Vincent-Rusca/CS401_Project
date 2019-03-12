package LoginAndDataBase;

import java.io.Serializable;
import java.util.Scanner;

public class UserAccounts implements Serializable {
    private String username;
    private String password;

    public UserAccounts(){
        this.username = "";
        this.password = "";
    }

    public UserAccounts(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Setters
    private void setUsername(String user) { username = user; }
    private void setPassword(String pass) { password = pass; }

    // Getters
    public String getUsername() {
        Scanner testUser = new Scanner(System.in);
        System.out.println("Username: ");
        username = testUser.next();
        return username;
    }
    public String getPassword() {
        Scanner testPass = new Scanner(System.in);
        System.out.println("Password: ");
        password = testPass.nextLine();
        return password;
    }

    public void addUser()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Your Desired Username: ");
        String setUser = input.nextLine();

        System.out.println("Please Enter Your Desired Password: ");
        String setPass = input.nextLine();

        setUsername(setUser);
        setPassword(setPass);
        // should save to useraccount.txt when made
    }

}
