package nichetech.com.employeefullcrudwithlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by krunal on 6/4/16.
 */
public class Db_manager extends SQLiteOpenHelper {

    private static final int database_VERSION = 1;
    private static final String database_NAME = "userDB1";
    private static final String table_user = "users";
    private static final String user_ID = "user_Id";
    private static final String user_NAME = "user_Name";
    private static final String user_SIR_NAME = "user_Sir_Name";
    private static final String user_ADDRESS = "user_Address";
    private static final String user_MOBILE = "user_Mobile";
    private static final String user_EMAIL = "user_Email";
    private static final String user_PASSWORD = "user_Password";

    boolean status=false;


    public Db_manager(Context context) {

        super(context, database_NAME, null, database_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + table_user + "("
                + user_ID + " INTEGER PRIMARY KEY," + user_NAME + " TEXT,"
                + user_SIR_NAME + " TEXT," + user_ADDRESS + " TEXT,"
                + user_MOBILE + " TEXT," + user_EMAIL + " TEXT,"
                + user_PASSWORD + " TEXT" + ")";

        Log.e("HELLO", "table Created");

        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_user);
        onCreate(db);
    }

    public void addUser(UserRollPojo pojo) {

        Log.e("msg", "dao have pojo");

        Log.e("msge", pojo.getName());
        Log.e("msge", pojo.getSir_name());
        Log.e("msge", pojo.getAddress());
        Log.e("msge", pojo.getMobile());
        Log.e("msge", pojo.getEmail());
        Log.e("msge", pojo.getPassword());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(user_NAME, pojo.getName());
        values.put(user_SIR_NAME, pojo.getSir_name());
        values.put(user_ADDRESS, pojo.getAddress());
        values.put(user_MOBILE, pojo.getMobile());
        values.put(user_EMAIL, pojo.getEmail());
        values.put(user_PASSWORD, pojo.getPassword());


        db.insert(table_user, null, values);
        Log.e("HELLO", "VALUE INSERTED");
        db.close();
    }

    public boolean chackUsernameOrPasswordValidOrNot(String email,String pass)
    {

        String selectQuery = "SELECT  * FROM " + table_user;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {


                int emailIndex=cursor.getColumnIndex(user_EMAIL);
                int passlIndex=cursor.getColumnIndex(user_PASSWORD);

                String email1=cursor.getString(emailIndex);
                String pass1=cursor.getString(passlIndex);

                if (email1.equalsIgnoreCase(email) && pass1.equalsIgnoreCase(pass))
                {
                    status=true;
                    return  status;

                }


            } while (cursor.moveToNext());

        }

        return false;
    }

    public boolean chackImailAvailable(String email)
    {

        boolean status=false;
        String selectQuery = "SELECT  * FROM " + table_user;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {


                int emailIndex=cursor.getColumnIndex(user_EMAIL);
                String email1=cursor.getString(emailIndex);

                if (email1.equalsIgnoreCase(email))
                {
                    status=true;
                    return  status;

                }


            } while (cursor.moveToNext());

        }

        return false;
    }

    public boolean updatePassword(String email1, String pass1)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        String updateQuery = " UPDATE SET " + user_PASSWORD + " = " +pass1+ " WHERE "+ user_EMAIL + " = " + email1;
        db.execSQL(updateQuery);
        Log.e("HELLO", "VALUE DELETED");
        db.close();
        return true;

    }



}
