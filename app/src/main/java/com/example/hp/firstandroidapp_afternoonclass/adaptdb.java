package com.example.hp.firstandroidapp_afternoonclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;

/**
 * Created by hp on 10/1/2016.
 */
public class adaptdb {
    private dbhelper DBHELPER;

    public adaptdb(Context context) {
        DBHELPER = new dbhelper(context);
    }

    public int createAccount(dbopen acct) {

        SQLiteDatabase db = DBHELPER.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbopen.KEY_FIRSTNAME, acct.getfirstname);
        values.put(dbopen.KEY_LASTNAME, acct.getlastname);
        values.put(dbopen.KEY_USERNAME, acct.getusername);
        values.put(dbopen.KEY_EMAIL, acct.getemail);
        values.put(dbopen.KEY_PASSWORD, acct.getpassword);
        values.put(dbopen.KEY_DATECREATED, acct.getdatecreated);
        long acct_Id = db.insert(dbopen.TABLE, null, values);
        db.close();
        return (int) acct_Id;
    }
    public void delete(int acct_Id){

        SQLiteDatabase db = DBHELPER.getWritableDatabase();
        db.delete(dbopen.TABLE, dbopen.KEY_ID + "+ ?", new String[] {String.valueOf(acct_Id)});
        db.close();

    }

    public void update(dbopen acct){

        SQLiteDatabase db = DBHELPER.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(dbopen.KEY_EMAIL, acct.getemail);
        values.put(dbopen.KEY_PASSWORD, acct.getpassword);
        values.put(dbopen.KEY_DATECREATED, acct.getdatecreated);

        db.update(dbopen.TABLE, values, dbopen.KEY_ID + "= ?", new String[] {String.valueOf(acct.acct_ID)});
        db.close();

    }

    public boolean validateLogin(String email, String password){

        boolean res = false;
        HashMap<String, String> user = new HashMap<String, String>();

        String selectQuery = "SELECT " + dbopen.KEY_EMAIL + ", " + dbopen.KEY_PASSWORD  + ", " + dbopen.KEY_USERNAME + " FROM " + dbopen.TABLE + " WHERE " + dbopen.KEY_EMAIL + " = \"" + email.toString() +  "\"" + " OR " + dbopen.KEY_USERNAME + " = \"" + email.toString() + "\"" + " AND " + dbopen.KEY_PASSWORD + " = \"" + password.toString() +"\"";

        SQLiteDatabase db = DBHELPER.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            user.put(dbopen.KEY_EMAIL, cursor.getString(0));
            user.put(dbopen.KEY_PASSWORD, cursor.getString(1));
            res = true;
        }
        else
        {
            res = false;
        }

        cursor.close();
        db.close();
        return res;


    }
    public boolean isExisting (dbopen acct){


        boolean res = false;
        HashMap<String, String> user = new HashMap<String, String>();
        SQLiteDatabase db = DBHELPER.getWritableDatabase();
         String selectQuery = "SELECT " + dbopen.KEY_EMAIL + ", " + dbopen.KEY_USERNAME + " FROM " + dbopen.TABLE + " WHERE " + dbopen.KEY_EMAIL + " = \"" + acct.getemail + "\"" + " OR " + dbopen.KEY_USERNAME + " = \"" + acct.getusername + "\"";

        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            user.put(dbopen.KEY_EMAIL, cursor.getString(0));
            user.put(dbopen.KEY_USERNAME, cursor.getString(1));
            res = true;
        }
        else
        {
            res = false;
        }
        cursor.close();
        db.close();
        //
        return res;

    }
}