package LoginAndDataBase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserAccountsTest {
    UserAccounts test = new UserAccounts();
    String username = "Steve";
    String password = "eve";


    @Test
    public void getUsername() {
        test.setUsername(username);
        assertEquals("Steve",test.getUsername());
        assertNotEquals("Doug",test.getUsername());
    }

    @Test
    public void getPassword() {
        test.setPassword(password);
        assertEquals("eve",test.getPassword());
        assertNotEquals("sfdsafd",test.getPassword());
    }
}