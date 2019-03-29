package cs401.LoginAndDataBase.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;
/*Setting up for Android JUnit Test Cases for GroupHW3*/
@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {
    private SQLiteDatabase db;
    private DatabaseHelper dbH;
    Context context;


    @Before
    public void setUp() throws Exception{

    }
    @After
    public void closeDB(){
        dbH.close();
    }

    @Test
    public void notNull(){
        assertNotNull(db);
        assertNotNull(dbH);
    }
    @Test
    public void isOpen(){
        assertTrue(db.isOpen());
    }

    @Test
    public void addUser() {

    }

    @Test
    public void searchPass() {
    }

    @Test
    public void searchUser() {
    }
}