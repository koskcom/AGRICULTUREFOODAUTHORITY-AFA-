package co.ke.bsl.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ryanmunene on 12/10/2015.
 **/
public class MyDbHelper extends SQLiteOpenHelper{
    // TABLE INFORMATTION
    public static final String TRANSACTIONS = "transactions";
    public static final String ID = "_id";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String AMOUNT = "amount";
    public static final String PHONE= "phone";
    public static final String DATE= "date";


    // DATABASE INFORMATION
    static final String DB_NAME = "sisdo.db";
    static final int DB_VERSION = 1;

    // TABLE CREATION STATEMENT

     static final String CREATE_TABLE = "create table "+"TRANSACTIONS"+
            "( " +"ID"+" integer primary key autoincrement,"+ "FIRSTNAME  text,LASTNAME text,PHONE number,AMOUNT number,DATE date); ";
    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(MyDbHelper.CREATE_TABLE);
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TRANSACTIONS);
        onCreate(db);

    }

}
