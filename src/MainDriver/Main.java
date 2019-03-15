/* Main for the Entire Program*/

package MainDriver;

import LoginAndDataBase.Login;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        Login start = new Login();
        start.login();

    }
}
