package info.trongdat.keyword;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2, edt3, edt4, edt5, edt6, edt7, edt8, edt9, edt10, edt11, edt12, edt13;
    ListView lstKeyWord;
    ArrayList<String> keys;
    ArrayAdapter adapter;
    SQLiteHandler db;
    //    String t1 = "", t2 = "", t3 = "", t4 = "", t5 = "", t6 = "", t7 = "", t8 = "", t9 = "", t10 = "", t11 = "", t12 = "", t13 = "";
    static String[] strs = new String[13];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        db = new SQLiteHandler(this);
        for (int i = 0; i < strs.length; i++) strs[i] = "";
        init();
        loadData();
    }

    public void loadData() {
        keys = new ArrayList<>();
        for (int i = 0; i < strs.length; i++)
            if (strs == null || strs[i].equals("")) {
                strs[i] = "_";
                if (i == strs.length) {
                    strs[i] = "%";
                }
            }

        String where = "where key like '" + strs[0] + strs[1] + strs[2] + strs[3] + strs[4] + strs[5]
                + strs[6] + strs[7] + strs[8] + strs[9] + strs[10] + strs[11] + strs[12] + "'";

        String sql = "select * from keyword ";
        String sort = " order by length asc";
        Cursor cursor = db.rawQuery(sql + where + sort);
        Log.d("datt", "loadData: " + sql + where + sort + "\n size: " + cursor.getCount());
//        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            String key = cursor.getString(1).trim().length() + "  " + cursor.getString(1);
            keys.add(key);
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, keys);
        lstKeyWord.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        edt1.setText(null);
        edt2.setText(null);
        edt3.setText(null);
        edt4.setText(null);
        edt5.setText(null);
        edt6.setText(null);
        edt7.setText(null);
        edt8.setText(null);
        edt9.setText(null);
        edt10.setText(null);
        edt11.setText(null);
        edt12.setText(null);
        edt13.setText(null);
        loadData();
        return super.onOptionsItemSelected(item);
    }

    public void init() {

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.edt3);
        edt4 = (EditText) findViewById(R.id.edt4);
        edt5 = (EditText) findViewById(R.id.edt5);
        edt6 = (EditText) findViewById(R.id.edt6);
        edt7 = (EditText) findViewById(R.id.edt7);
        edt8 = (EditText) findViewById(R.id.edt8);
        edt9 = (EditText) findViewById(R.id.edt9);
        edt10 = (EditText) findViewById(R.id.edt10);
        edt11 = (EditText) findViewById(R.id.edt11);
        edt12 = (EditText) findViewById(R.id.edt12);
        edt13 = (EditText) findViewById(R.id.edt13);
        lstKeyWord = (ListView) findViewById(R.id.lstKeyWord);

        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Log.d("datt", "beforeTextChanged: before");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[0] = s.toString();
                loadData();
                Log.d("datt", "onTextChanged: change");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("datt", "afterTextChanged: after");
            }
        });
        edt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[1] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[2] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[3] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[4] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[5] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[6] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[7] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[8] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[9] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[10] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[11] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt13.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strs[12] = s.toString();
                loadData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
