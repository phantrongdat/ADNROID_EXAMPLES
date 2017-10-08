package vn.dat.sqlitedatabaseupdate;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    DatabaseHandler2 db;
    ArrayList<String> list;
    ArrayAdapter adapter;
    ListView lstAccount;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler2(this);
        lstAccount = (ListView) findViewById(R.id.lstAccount);
        loadAccount();
        updateDatabase();

    }

    public void updateDatabase()
    {
        countDownTimer=new CountDownTimer(2000,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                db.execute("DELETE FROM tblAccount WHERE username='alone'");
                loadAccount();
            }

            @Override
            public void onFinish() {
                db.copyDB2SDCard();
                loadAccount();
            }
        };
        countDownTimer.start();
    }

    public void loadAccount() {
        list = new ArrayList<String>();

//        db.execute("INSERT INTO tblAccount VALUES(null,'TaDuy','Chien')");
        Cursor c = db.rawQuery("SELECT * FROM tblAccount");
        c.moveToFirst();
        do {
            list.add(0, c.getString(1) + "   -   " + c.getString(2));
        } while (c.moveToNext());

        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_single_choice, list);
        lstAccount.setAdapter(adapter);
    }

}
