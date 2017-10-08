package com.example.alone.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 03/08/2016.
 */
public class MyDatabase extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private Context dbContext;
    private static final String dbPath="data/data/com.example.alone.myapplication/databases/UTEHYaccount.sqlite";
    private static final String dbName="UTEHYaccount.sqlite";
    private static int dbVersion=1;

    public MyDatabase(Context context) {
        super(context, dbName,null,dbVersion);
        this.dbContext=context;
    }

    public void openDB()
    {
        db=SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDB()
    {
        db.close();
    }

    public void executeDB(String sql)
    {
        openDB();
        db.execSQL(sql);
        closeDB();
    }

    public Cursor getCursor(String sql)
    {
        openDB();
        Cursor c=db.rawQuery(sql,null);
        closeDB();
        return c;
    }

    public int getCount(String sql)
    {
        openDB();
        int count=db.rawQuery(sql,null).getCount();
        closeDB();
        return count;
    }

    public void copyDB2SDCard()
    {
        try {
            SQLiteDatabase check = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
//            if (check != null) check.close();
//            else {
//                //// copy to sdcard
//                InputStream input=dbContext.getAssets().open(dbName);
//                OutputStream output=new FileOutputStream(dbPath);
//
//                byte[]buffer=new byte[1024];
//                int length;
//                while ((length=input.read(buffer))>0)
//                {
//                    output.write(buffer,0,length);
//                }
//                input.close();
//                output.flush();
//                output.close();
//            }
        }catch
                (Exception e)
        {
            throw new Error("Error !");
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
