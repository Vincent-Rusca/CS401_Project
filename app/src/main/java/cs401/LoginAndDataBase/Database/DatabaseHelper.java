package cs401.LoginAndDataBase.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "testLogin";
    public static final String TABLE_NAME = "testLog";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_ID = "id";
    public static final String COL_1 = "Username";
    public static final String COL_2 = "Password";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + "(" + TABLE_ID + " INTEGER PRIMARY KEY,"
                + COL_1 + " TEXT," + COL_2 + " TEXT" +")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addLogin(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, user.getUsername());
        contentValues.put(COL_2, user.getPassword());

        db.insert(TABLE_NAME,null, contentValues);
        db.close();
    }

    User getUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{TABLE_ID,COL_1,COL_2}, TABLE_ID + "=?",
                new String[] {String.valueOf(id)},null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();
        User user = new User(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
        return user;
    }

    public List<User> getAllLogins(){
        List<User> logins = new ArrayList<User>();

        String selectQuery = "SELECT * FROM "  + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setUsername(cursor.getString(1));
                user.setPassword(cursor.getString(2));

                logins.add(user);
            }while (cursor.moveToNext());
        }
        return logins;
    }
}
