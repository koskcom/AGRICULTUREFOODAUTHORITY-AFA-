package co.ke.bsl.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ryanmunene on 12/6/2015.
 **/
public class DataBaseHandler {
    static final String DATABASE_NAME = "afa";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+"MEMBERS"+
            "( " +"ID"+" integer primary key autoincrement,"+ "FIRSTNAME  text,LASTNAME text,IDNUMBER number,PHYSICALADDRESS text,DATEOFBIRTH date); ";
    // Variable to hold the database instance
    public static SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public  DataBaseHandler(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public DataBaseHandler open () throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public static void close ()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String firstname, String lastname, String idnumber,String physicaladdress,String dateofbirth)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("FIRSTNAME", firstname);
        newValues.put("LASTNAME",lastname);
        newValues.put("IDNUMBER",idnumber);
        newValues.put("PHYSICALADDRESS",physicaladdress);
        newValues.put("DATEOFBIRTH",dateofbirth);

        // Insert the row into your table
        db.insert("MEMBERS", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry(String IDNumber)
    {
        //String id=String.valueOf(ID);
        String where="IDNUMBER=?";
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return db.delete("MEMBERS", where, new String[]{IDNumber});
    }
    public String getSinlgeEntry(String idnumber)
    {
        Cursor cursor=db.query ("MEMBERS", null, " IDNUMBER=?", new String[]{idnumber}, null, null, null);
        if(cursor.getCount()<1) // idnumber Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst ();
        String password= cursor.getString(cursor.getColumnIndex("IDNUMBER"));
        cursor.close();
        return idnumber;
    }
    public void  updateEntry(String firstname, String lastname, int idnumber,String physicaladdress,String dateofbirth)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("FIRSTNAME", firstname);
        updatedValues.put("LASTNAME",lastname);
        updatedValues.put("IDNUMBER",idnumber);
        updatedValues.put("PHYSICALADDRESS",physicaladdress);
        updatedValues.put ("DATEOFBIRTH", dateofbirth);

        String where="IDNUMBER = ?";
        db.update("MEMBERS",updatedValues, where, new String[]{String.valueOf (idnumber)});
    }

}
