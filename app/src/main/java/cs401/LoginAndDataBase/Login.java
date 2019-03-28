package cs401.LoginAndDataBase;
/*This class is used to handle all of the login for the program.
* It prompts the user with a menu and then validates their credentials*/

import cs401.menu.Menu;
import cs401.menu.text.TextMenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;
/*FILE REPLACED WITH LOGINACTIVITY IN HW2*/
public class Login implements Serializable {

    /*This is the login menu for the users.
     * The user will be able to login, register a new account, or exit. */
    public void login() throws IOException {
        UserAccounts createUser = new UserAccounts();
        int input;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Select Your Option:");
            System.out.println("1. Login");
            System.out.println("2. Register User");
            System.out.println("3. Exit");
            System.out.println("Selection: ");
            input = scanner.nextInt();
            if (input == 1) {
                validLogin();
            } else if (input == 2) {
                createUser.addUser();
            } else if (input == 3) {
                System.out.println("Goodbye");
                break;
            } else {
                System.out.println("Invalid Input");
            }

        } while (input != 3);
    }

    /*This validates the users login credentials.
     * If the user exists, it will load their user files and got to the main menu.
     * If the user doesn't exist, it will ask them to register their account. */
    public void validLogin() {
        DataBase userPass = new DataBase();
        try {
            Menu menu = new TextMenu();
            UserAccounts user = new UserAccounts();
            userPass.loadUserAccounts();
            Set<UserAccounts> userAccountsSet = userPass.getUserAccounts();
            String username = user.getUsername();
            String password = user.promtPassword();
            UserAccounts newAccount = new UserAccounts(username, password);
            if (userAccountsSet.contains(newAccount)) {
                System.out.println("Login Successful");
                userPass.loadUserData(username);
                menu.start();
            } else {
                System.out.println("Wrong password or User account doesn't exist." +
                        " Please register if the user account doesn't exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}