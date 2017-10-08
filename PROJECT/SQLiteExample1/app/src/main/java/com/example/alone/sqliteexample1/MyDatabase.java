package com.example.alone.sqliteexample1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alone on 03/11/2016.
 */
public class MyDatabase extends SQLiteOpenHelper {

    private SQLiteDatabase db = getWritableDatabase();

    public MyDatabase(Context context) {
        super(context, "UTEHY.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getData(String sql) {
        return db.rawQuery(sql, null);
    }

    public void queryData(String sql) {
        db.execSQL(sql);
    }

    public boolean svExists(String masv) {
        int count = getData("SELECT *FROM Sinhvien WHERE maSV='" + masv + "'").getCount();
        if (count > 0) return true;

        return false;
    }
}
