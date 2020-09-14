package co.ke.bsl.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ryanmunene on 12/10/2015.
 **/
public class SQLController {
    private MyDbHelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLController(Context c) {
        ourcontext = c;
    }

    public SQLController open() throws SQLException {
        dbhelper = new MyDbHelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;

    }

    public void close() {
        dbhelper.close();
    }

    public void insertData(String name, String lname, String amount,String phone,String date ) {

        ContentValues cv = new ContentValues ();
        cv.put(MyDbHelper.FIRSTNAME, name);
        cv.put(MyDbHelper.LASTNAME, lname);
        cv.put(MyDbHelper.AMOUNT, amount);
        cv.put(MyDbHelper.PHONE, phone);
        cv.put(MyDbHelper.DATE, date);
                database.insert (MyDbHelper.TRANSACTIONS, null, cv);

    }

    public Cursor readEntry() {

        String[] allColumns = new String[] { MyDbHelper.ID, MyDbHelper.FIRSTNAME,
                MyDbHelper.LASTNAME,MyDbHelper.AMOUNT,MyDbHelper.PHONE,MyDbHelper.DATE };

        Cursor c = database.query(MyDbHelper.TRANSACTIONS, allColumns, null, null, null,
                null, null);

        if (c != null) {
            c.moveToFirst();
        }
        return c;

    }

}