package vn.dat.quanlysinhvien.DatabaseHandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 05/02/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private Context dbContext;
    private SQLiteDatabase db;
    private static final String dbPath = "/data/data/vn.dat.quanlysinhvien/databases/";
    private static final String dbName = "dbsinhvien.sqlite";
    private static final int dbVersion = 1;

    public DatabaseHandler(Context context) {
        super(context, dbName, null, dbVersion);
        this.dbContext = context;
        openDB();
    }

    public boolean checkDB() {
        try {
            File file = new File(dbPath + dbName);
            if (file.exists()) return true;
        } catch (Exception io) {
            io.printStackTrace();
            return false;
        }
        return false;
    }

    public void copyDB2SDCard() {

        try {
            this.getReadableDatabase();

            InputStream myInput = dbContext.getAssets().open(dbName);
            String outFileName = dbPath;
            OutputStream myOutput = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();

        } catch (Exception ex) {
//            throw new Error("Lỗi không copy được database");
            ex.printStackTrace();
        }
    }

    public void openDB() {
        if (checkDB()) {
            db = SQLiteDatabase.openDatabase(dbPath+dbName, null,
                    SQLiteDatabase.OPEN_READWRITE);
            Toast.makeText(dbContext, "Kết nối CSDL thành công !", Toast.LENGTH_SHORT).show();
        } else {
            copyDB2SDCard();
            Toast.makeText(dbContext, "Copy CSDL sang SDCard thành công", Toast.LENGTH_SHORT).show();
        }
    }

    public void closeDB() {
        db.close();
    }

    public Cursor rawQuery(String strSQL) {
//        openDB();
        Cursor c = db.rawQuery(strSQL, null);
        return c;
    }


    public void execute(String sql) {
//        openDB();
        db.execSQL(sql);
//        closeDB();
    }

    public int getCount(String sql) {
        Cursor c = null;
        try {
            c = rawQuery(sql);
            if (c == null) {
                return 0;
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
            c.close();
            db.close();
        }
        return c.getCount();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}