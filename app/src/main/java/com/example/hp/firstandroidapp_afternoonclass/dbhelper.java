package com.example.hp.firstandroidapp_afternoonclass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 10/1/2016.
 */
public class dbhelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "account.db";

    public dbhelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        //Latest edit
        String CREATE_TABLE_ACCOUNT = "CREATE TABLE " + dbopen.TABLE + "("
                + dbopen.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + dbopen.KEY_FIRSTNAME + " TEXT,"
                + dbopen.KEY_LASTNAME + " TEXT,"
                + dbopen.KEY_USERNAME + " TEXT UNIQUE,"
                + dbopen.KEY_EMAIL + " TEXT UNIQUE, "
                + dbopen.KEY_PASSWORD + " TEXT, "
                + dbopen.KEY_DATECREATED + " TEXT)";
        //
        db.execSQL(CREATE_TABLE_ACCOUNT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + dbopen.TABLE);

        onCreate(db);
    }
}


