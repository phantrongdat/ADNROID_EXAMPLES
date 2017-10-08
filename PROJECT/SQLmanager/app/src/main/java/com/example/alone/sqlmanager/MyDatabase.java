package com.example.alone.sqlmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 04/05/2016.
 */
public class MyDatabase extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Context dbContext;
    static String dbName="DAT";
    static String dbPath="/data/data/com.example.alone.sqlmanager/databases/";
    static int dbVersion=2;

    public MyDatabase(Context context) {
        super(context, dbName, null, dbVersion);
        dbContext=context;
        openDatabase();
    }


    public boolean checkDatabase()
    {

        SQLiteDatabase checkDB=null;
        try
        {
            checkDB=SQLiteDatabase.openDatabase(dbPath+dbName,null,SQLiteDatabase.OPEN_READONLY);
        }
        catch (SQLiteException e)
        {
        }

        if (checkDB!=null)
        {
            checkDB.close();
        }

        return checkDB!=null?true:false;
    }

    public void copyDatabase()
    {
        try {
            InputStream myInput =dbContext.getAssets().open(dbName);

            OutputStream myOutput=new FileOutputStream(dbPath+dbName);

            byte[] buffer=new byte[1024];
            int length;
            while ((length=myInput.read(buffer))>0)
            {
                myOutput.write(buffer,0,length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();

        } catch (IOException e) {

//            throw new Error("Khong the copy database!");
            Toast.makeText(dbContext,"Khong the copy database",Toast.LENGTH_LONG);
        }
    }

    public void openDatabase()
    {
        boolean dbExist=checkDatabase();

        if (dbExist)
        {
            try {
                db = SQLiteDatabase.openDatabase(dbPath + dbName, null, SQLiteDatabase.OPEN_READWRITE);
            }catch (SQLiteException sql)
            {
                throw new Error(sql);
            }
        }
        else
        {
            this.getReadableDatabase();
            copyDatabase();
        }
    }

    public void execute(String sql)
    {
        db.execSQL(sql);
    }

    public int getRow(String sql)
    {
        return executeQuery(sql).getCount();
    }

    public Cursor executeQuery(String sql)
    {
        Cursor c=db.rawQuery(sql,null);
        return c;
    }

    @Override
    public synchronized void close() {
        if (db!=null)
        {
            db.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
