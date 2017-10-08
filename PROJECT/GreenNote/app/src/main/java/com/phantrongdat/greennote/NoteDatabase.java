package com.phantrongdat.greennote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 04/11/2016.
 */
public class NoteDatabase extends SQLiteOpenHelper {
    SQLiteDatabase db = null;
    Context dbContext = null;
    static String dbName = "NoteDatabase.sqlite";
    static String dbPath = "/data/data/com.phantrongdat.greennote/databases/";
    static int dbVersion = 1;
    String path = dbPath + dbName;

    public NoteDatabase(Context context) {
        super(context, dbName, null, dbVersion);
        dbContext = context;
        openDB();
    }


    public boolean checkDB() {
        SQLiteDatabase check = null;

        try {
            check = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        if (check != null) check.close();
        return check == null ? false : true;
    }

    public void copyDB() {
        try {
            InputStream inputStream = dbContext.getAssets().open(dbName);
            OutputStream outputStream = new FileOutputStream(new File(path));

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDB() {
        if (checkDB()) {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
            Toast.makeText(dbContext,"Open Database successfuly !",Toast.LENGTH_LONG).show();
        } else {
            this.getReadableDatabase();
            copyDB();
            Toast.makeText(dbContext,"Copy database successfuly ! !",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
