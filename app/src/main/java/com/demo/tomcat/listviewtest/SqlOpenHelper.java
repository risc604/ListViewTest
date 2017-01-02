package com.demo.tomcat.listviewtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import static android.database.sqlite.SQLiteDatabase.*;

/**
 * Created by tomcat on 2017/1/2.
 */

public class SqlOpenHelper extends SQLiteOpenHelper
{
    private final String    TAG = SqlOpenHelper.class.getSimpleName();

    public static final String DBNAME = Environment.getExternalStorageDirectory().
            getPath()+ "/mt24hr/mt24hr.db";

    public static final int VERSION = 1;
    public static final String TABLE_USER = "user";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String BIRTHDAY = "birthday";
    public static final String USER_UUID = "uuid";
    public static final String USER_CREATE_DATE = "created_date";
    public static final String USER01 = "user01";
    public static final String USER02 = "user02";
    public static final String USER03 = "user03";
    public static final String USER04 = "user04";
    public static final String SQL_USER_TABLE_CREATED = "CREATE TABLE " + TABLE_USER + "( " +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            NAME + " TEXT NOT NULL, " +
            BIRTHDAY + " TEXT NOT NULL, " +
            USER_UUID + " TEXT NOT NULL, " +
            USER_CREATE_DATE + " TEXT NOT NULL, " +
            USER01 + " TEXT NOT NULL, " +
            USER02 + " TEXT NOT NULL, " +
            USER03 + " TEXT NOT NULL, " +
            USER04 + " TEXT NOT NULL);";

    public static final String TABLE_TEMP = "temperature";
    public static final String TEMP_ID = "tmp_id";
    public static final String TEMP_START_TIME = "start_time";
    public static final String TEMP_DATA = "data";
    public static final String TEMP_END_TIME = "end_time";
    public static final String TEMP_UUID = "temp_uuid";
    public static final String TEMP_CREATE_DATE = "created_date";
    public static final String TEMP01 = "temp01";
    public static final String TEMP02 = "temp02";
    public static final String TEMP03 = "temp03";
    public static final String TEMP04 = "temp04";
    public static final String SQL_TEMP_TABLE_CREATED = "CREATE TABLE " + TABLE_TEMP + "( " +
            TEMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            TEMP_START_TIME + " TEXT NOT NULL, " +
            TEMP_DATA + " TEXT NOT NULL, " +
            TEMP_END_TIME + " TEXT NOT NULL, " +
            TEMP_UUID + " TEXT NOT NULL, " +
            TEMP_CREATE_DATE + "TEXT NOT NULL, " +
            TEMP01 + " TEXT NOT NULL, " +
            TEMP02 + " TEXT NOT NULL, " +
            TEMP03 + " TEXT NOT NULL, " +
            TEMP04 + " TEXT NOT NULL, FOREIGN KEY(" +
            TEMP_UUID + ") REFERENCES " + TABLE_USER + "(" + USER_UUID +"));";


    public SqlOpenHelper(Context context)
    {
        super(context, DBNAME, null, VERSION);
        Log.d(TAG, "SqlOpenHelper()");
    }


    public SqlOpenHelper(Context context, String name, CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        Log.d(TAG, "SqlOpenHelper() 2");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.d(TAG, "create DB.");
        createDataBase(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    private void createDataBase(SQLiteDatabase db)
    {
        db.execSQL(SQL_USER_TABLE_CREATED);
        Log.d(TAG, "create user Table OK.");

        db.execSQL(SQL_TEMP_TABLE_CREATED);
        Log.d(TAG, "create temp Table OK.");
    }


}
