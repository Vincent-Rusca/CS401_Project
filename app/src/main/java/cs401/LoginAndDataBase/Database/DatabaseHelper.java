package cs401.LoginAndDataBase.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "test1.db";
    public static final String TABLE_NAME = "testt";
    public static final int DATABASE_VERSION = 1;
    public static final String COL_1 = "Username";
    public static final String COL_2 = "Password";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(Username TEXT, Password TEXT)");
        onCreate(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
