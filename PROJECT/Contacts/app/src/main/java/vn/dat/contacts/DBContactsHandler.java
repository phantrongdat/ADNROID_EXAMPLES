package vn.dat.contacts;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 05/06/2016.
 */
public class DBContactsHandler extends SQLiteOpenHelper {
    private Context dbContext;
    private SQLiteDatabase db;
    private static String DB_NAME = "dbcontacts.sqlite";
    private static String DB_PATH = "/data/data/vn.dat.contacts/databases/";
    private static int DB_VERSION = 1;

    final String PATH = DB_PATH + DB_NAME;

    // Phương thức khởi tạo thể hiện đối tượng lớp DatabaseHander.
    public DBContactsHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.dbContext = context;
        openDatabase();
    }

//     Phương thức kiểm tra sự tồn tại Database trả ra true hoặc false.
//    public boolean dbExists() {
//        SQLiteDatabase check = null;
//        try {
//            check = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
//        } catch (SQLiteException e) {
//            e.printStackTrace();
//        }
//        if (check != null) {
//            check.close();
//        }
//
//        return check != null ? true : false;
//    }

    public boolean dbExists() {
        File fcheck = new File(PATH);
        if (fcheck.exists()) {
            return true;
        } else return false;
    }

    // Phương thức copy Database sang bộ nhớ trong của điện thoại.
    public void copyDatabase() {
        db = getReadableDatabase();
        try {
            InputStream inputStream = dbContext.getAssets().open(DB_NAME);
            OutputStream outputStream = new FileOutputStream(new File(PATH));
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

    // Phương thức mở Database.
    public void openDatabase() {
        if (dbExists()) {
            try {
                db = SQLiteDatabase.openDatabase(PATH, null, SQLiteDatabase.OPEN_READWRITE);
            } catch (SQLiteException e) {
                e.printStackTrace();
                db.close();
            }
//            Toast.makeText(dbContext, "Open database successfully .!", Toast.LENGTH_SHORT).show();
        } else {
            copyDatabase();
//            Toast.makeText(dbContext, "Copy database to SDCard successfully .!", Toast.LENGTH_SHORT).show();
        }
    }

    // Phương thức đóng Database.
    public void closeDatabase() {
        db.close();
    }

    // Phương thức thực thi các câu lệnh (insert, update, delele...).
    public void execute(String sql) {
//        if (!db.isOpen()) {
//            openDatabase();
//        }
        openDatabase();
        db.execSQL(sql);
        closeDatabase();
    }

    // Phương thức truy vấn lấy dữ liệu từ Database.
    public Cursor rawQuery(String sql) {
        openDatabase();
//        if (!db.isOpen()) {
//            openDatabase();
//        }
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(sql, null);
        } catch (SQLiteException e) {
            e.printStackTrace();
//            cursor.close();
            db.close();
        }
//        closeDatabase();
        return cursor;
    }

    public void insertDetails(String name, String phoneNumber, String details,byte[] image) {
        openDatabase();
//        SQLiteDatabase db = this.getReadableDatabase();
        String insert = "INSERT INTO tblDetails VALUES(null,?,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(insert);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, phoneNumber);
        statement.bindString(3, details);
        statement.bindBlob(4, image);

        statement.executeInsert();
        statement.close();

        closeDatabase();
    }

    // Phương thức lấy ra số lượng bản ghi từ câu lệnh truy vấn.
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
    protected void finalize() throws Throwable {
        this.close();
        super.finalize();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

