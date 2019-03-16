package LoginAndDataBase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DataBaseTest {
    Set<UserAccounts> set1 = new HashSet<>();
    Set<UserAccounts> set2 = new HashSet<>();
    Set<UserAccounts> set3 = new HashSet<>();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void loadUserAccounts() {
        String username1 = "Cheif";
        String password1 = "Master";
        set1.add(new UserAccounts(username1,password1));
        String username2 = "Cheif";
        String password2 = "Master";
        set2.add(new UserAccounts(username2,password2));
        String username3 = "Dog";
        String password3 = "Woof";
        set3.add(new UserAccounts(username3,password3));

        Assert.assertEquals(set1,set2);
        Assert.assertNotEquals(set1,set3);
    }

    @Test
    public void getUserAccounts() {
        loadUserAccounts();
        Assert.assertEquals(set1,set2);
        Assert.assertNotEquals(set2,set3);
    }
}