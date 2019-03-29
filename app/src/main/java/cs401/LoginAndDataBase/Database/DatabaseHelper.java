package cs401.LoginAndDataBase.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*The purpose of this class is to help manipulate the database.
* This will have all of the functions to create, check or add to the database*/

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_TEST = "testCase";
    private static final String DATABASE_NAME = "testLogin";
    private static final String TABLE_NAME = "testLog";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ID = "id";
    private static final String COL_1 = "Username";
    private static final String COL_2 = "Password";
    SQLiteDatabase db;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    /*Used to create the database, if it does exist it will not create it.
    * This prevents the table from being recreated and overriding previous work.
    * In our case it will save any users to the local database on their emulator*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + "(" + TABLE_ID + " INTEGER PRIMARY KEY,"
                + COL_1 + " TEXT," + COL_2 + " TEXT" +")";
        db.execSQL(CREATE_TABLE);
        this.db = db;
    }
    /*Will create a new database if it does not exist*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    /*Will add a new user to the database*/
    public void addUser(User user) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, user.getUsername());
        contentValues.put(COL_2, user.getPassword());
        db.insert(TABLE_NAME,null, contentValues);
        db.close();

    }
    /*Used to check and see if the user's password is correct*/
    public String searchPass(String user){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT Username, Password FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String uname, pword;
        pword = "not found";
        /*This will start out in the first colum to check the username, if it exists it will break
        * and check it with what the user has entered where its called*/
        if(cursor.moveToFirst())
        {
            do {
                uname = cursor.getString(0);
                if(uname.equals(user)) {
                    pword = cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        return pword;
    }

    /*This is used for making sure there are no duplicate usernames in the database.*/
    public String searchUser(String user){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT Username, Password FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String uname;
        uname = "not found";
        /*This will start out in the first colum to check the username, if it exists it will break
         * and check it with what the user has entered where its called*/
        if(cursor.moveToFirst())
        {
            do {
                uname = cursor.getString(0);
                if(uname.equals(user)) {
                    uname = cursor.getString(0);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return uname;
    }
}
