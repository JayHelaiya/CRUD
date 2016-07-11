package nichetech.com.employeefullcrudwithlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krunal on 7/4/16.
 */
public class Employee_db extends SQLiteOpenHelper {

    private static final int database_VERSION = 1;
    private static final String database_NAME = "employeeDB22";
    private static final String table_EMP = "employee";
    private static final String emp_ID = "emp_Id";
    private static final String emp_NAME = "emp_Name";
    private static final String emp_DESIGNATION = "emp_Designation";
    private static final String emp_DEPT = "emp_department";
    private static final String emp_EMAIL = "emp_Email";



    public Employee_db(Context context) {

        super(context, database_NAME, null, database_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + table_EMP + "("
                + emp_ID + " INTEGER PRIMARY KEY," + emp_NAME + " TEXT,"
                + emp_DESIGNATION + " TEXT," + emp_DEPT + " TEXT," + emp_EMAIL + ")";

        Log.e("HELLO", "table Created");

        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_EMP);
        onCreate(db);
    }

    public void addEmployee(Employee employee)
    {

        Log.e("msg", "dao have pojo");

        Log.e("msge", employee.getName());
        Log.e("msge", employee.getDesignation());
        Log.e("msge", employee.getDepartment());
        Log.e("msge", employee.getEmail());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(emp_NAME, employee.getName());
        values.put(emp_DESIGNATION, employee.getDesignation());
        values.put(emp_DEPT, employee.getDepartment());
        values.put(emp_EMAIL, employee.getEmail());



        db.insert(table_EMP, null, values);
        Log.e("HELLO", "VALUE INSERTED");
        db.close();

    }


    public boolean updateAll(Employee pojo, int idForUpdate) {

        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("Dao", "pojo in Dao");

        Log.e("Dao", pojo.getName());
        Log.e("Dao", pojo.getEmail());

        ContentValues values = new ContentValues();
        values.put(emp_NAME, pojo.getName());
        values.put(emp_DESIGNATION, pojo.getDesignation());
        values.put(emp_DEPT, pojo.getDepartment());
        values.put(emp_EMAIL, pojo.getEmail());

        return db.update(table_EMP, values, emp_ID + "=" + idForUpdate, null) > 0;
    }

    public Employee displayById(int idForUpdate) {
        Employee pojo=new Employee();
        List<Employee> empList = new ArrayList<Employee>();
        String selectQuery = "SELECT  * FROM " + table_EMP + " WHERE " + emp_ID + "=" + idForUpdate;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                pojo.setName(cursor.getString(1));
                pojo.setDesignation(cursor.getString(2));
                pojo.setDepartment(cursor.getString(3));
                pojo.setEmail(cursor.getString(4));

            } while (cursor.moveToNext());
        }

        return pojo;
    }

    public List<Employee> displayAll() {

        List<Employee> empList = new ArrayList<Employee>();
        String selectQuery = "SELECT  * FROM " + table_EMP;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                Employee pojo = new Employee();

                pojo.setId(Integer.parseInt(cursor.getString(0)));
                pojo.setName(cursor.getString(1));
                pojo.setDesignation(cursor.getString(2));
                pojo.setDepartment(cursor.getString(3));
                pojo.setEmail(cursor.getString(4));

                empList.add(pojo);
            } while (cursor.moveToNext());
        }

        return empList;

    }

    public void deleteById(int idFordelete)
    {
        Integer v = new Integer(idFordelete);
        Log.e("DB", v.toString());
        SQLiteDatabase db = this.getWritableDatabase();

        String deleteQuery = " DELETE FROM " + table_EMP + " WHERE " + emp_ID + " = " + idFordelete;
        db.execSQL(deleteQuery);
        Log.e("HELLO", "VALUE DELETED");
        db.close();

    }



}
