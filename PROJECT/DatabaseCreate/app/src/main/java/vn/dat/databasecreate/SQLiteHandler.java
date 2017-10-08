package vn.dat.databasecreate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Alone on 04/29/2016.
 */

public class SQLiteHandler extends SQLiteOpenHelper {

    Context dbContext;
    String dbPath = "/data/data/vn.dat.databasecreate/databases/";

    public SQLiteHandler(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        dbContext = context;
        checkDatabase(name);
    }

    public void checkDatabase(String name) {
        String path = dbPath + name;
        File dbCheck = new File(path);
        if (dbCheck.exists()) {
            Toast.makeText(dbContext, "Database is exists .!", Toast.LENGTH_SHORT).show();
        } else {
                Toast.makeText(dbContext, "Database created successfully .!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
