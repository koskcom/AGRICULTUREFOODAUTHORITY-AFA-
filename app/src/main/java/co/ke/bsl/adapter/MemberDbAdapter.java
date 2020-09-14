package co.ke.bsl.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ryanmunene on 12/15/2015.
 **/
public class MemberDbAdapter {
    public static final String KEY_ROWID = "rowid";
    public static final String KEY_FNAME = "firstname";
    public static final String KEY_LNAME = "lastname";
    public static final String KEY_IDNUMBER = "idnumber";
    public static final String KEY_ADDRESS = "physicaladdress";
    public static final String KEY_DOB = "dob";
    public static final String KEY_SEARCH = "searchData";

    private static final String TAG = "MemberDbAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "sisdo.db";
    private static final String FTS_VIRTUAL_TABLE = "MemberInfo";
    private static final int DATABASE_VERSION = 1;

    //Create a FTS3 Virtual Table for fast searches
    private static final String DATABASE_CREATE =
            "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE + " USING fts3(" +
                    KEY_FNAME + "," +
                    KEY_LNAME + "," +
                    KEY_IDNUMBER + "," +
                    KEY_ADDRESS + "," +
                    KEY_DOB + "," +
                    KEY_SEARCH + "," +
                    " UNIQUE (" + KEY_IDNUMBER + "));";


    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
            onCreate(db);
        }
    }

    public MemberDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public MemberDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }


    public long createMember(String firstname, String lastname, Integer idnumber, String physicaladdress, String dob) {

        ContentValues initialValues = new ContentValues();
        String searchValue =     firstname + " " +
                lastname + " " +
                idnumber + " " +
                physicaladdress + " " +
                dob ;
        initialValues.put(KEY_FNAME, firstname);
        initialValues.put(KEY_LNAME, lastname);
        initialValues.put(KEY_IDNUMBER, idnumber);
        initialValues.put(KEY_ADDRESS, physicaladdress);
        initialValues.put(KEY_DOB, dob);
        initialValues.put(KEY_SEARCH, searchValue);

        return mDb.insert(FTS_VIRTUAL_TABLE, null, initialValues);
    }


    public Cursor searchMember(String inputText) throws SQLException {
        Log.w(TAG, inputText);
        String query = "SELECT docid as _id," +
                KEY_FNAME + "," +
                KEY_LNAME + "," +
                KEY_IDNUMBER + "," +
                KEY_ADDRESS + "," +
                KEY_DOB + "," +
                " from " + FTS_VIRTUAL_TABLE +
                " where " +  KEY_SEARCH + " MATCH '" + inputText + "';";
        Log.w (TAG, query);
        Cursor mCursor = mDb.rawQuery(query,null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }


    public boolean deleteAllMembers() {

        int doneDelete = 0;
        doneDelete = mDb.delete(FTS_VIRTUAL_TABLE, null , null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

}