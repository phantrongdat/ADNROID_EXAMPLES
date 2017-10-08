package com.dat17.application;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class AccountManager extends AppCompatActivity {
    TabHost tabHost;
    SQLiteHandler db;
    EditText edtUsername, edtPassword;

    ListView lstAccount;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_manager);
        db = new SQLiteHandler(this);
//        db.openDatabase();
        tabHost = (TabHost) findViewById(R.id.tabHost2);
        tabHost.setup();
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        lstAccount = (ListView) findViewById(R.id.lstAccount);
        lstAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] user = arrayList.get(position).split(" - ");

                edtUsername.setText(user[0].toString());
                edtPassword.setText(user[1].toString());
                tabHost.setCurrentTab(0);
            }
        });

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("MANAGER");
        tabSpec.setIndicator("Manager");
        tabSpec.setContent(R.id.contentManager);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("ACCOUNTS");
        tabSpec.setIndicator("Accounts");
        tabSpec.setContent(R.id.contentListAccount);
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

        loadAccount();
    }

    public void loadAccount() {
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lstAccount.setAdapter(adapter);
        Cursor c = db.executeQuery("SELECT * FROM tblAccount");

        while (c.moveToNext()) {
            arrayList.add(c.getString(1) + " - " + c.getString(2));
        }

        adapter.notifyDataSetChanged();
    }

    public void addUser(View view) {
        if (db.executeQuery("SELECT*FROM tblAccount WHERE username='" + edtUsername.getText() + "'").getCount() > 0) {
            Toast.makeText(AccountManager.this, "Username is exists.", Toast.LENGTH_SHORT).show();
        } else {
            String sql = "INSERT INTO tblAccount VALUES(null,'" + edtUsername.getText() + "','" + edtPassword.getText() + "')";
            db.execute(sql);
            edtUsername.setText("");
            edtPassword.setText("");
            loadAccount();
            tabHost.setCurrentTab(1);
        }
    }

    public void updateUser(View view) {
        if (db.executeQuery("SELECT*FROM tblAccount WHERE username='" + edtUsername.getText() + "'").getCount() > 0) {
            String sql = "UPDATE tblAccount SET password='" + edtPassword.getText() + "' WHERE username='" + edtUsername.getText() + "'";
            db.execute(sql);
            Toast.makeText(AccountManager.this, "Update succsessfuly!", Toast.LENGTH_SHORT).show();
            edtUsername.setText("");
            edtPassword.setText("");
            loadAccount();
            tabHost.setCurrentTab(1);
        } else {
            Toast.makeText(AccountManager.this, "Username is not exists.", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteUser(View view) {
        if (db.executeQuery("SELECT*FROM tblAccount WHERE username='" + edtUsername.getText() + "'").getCount() > 0) {
            String sql = "DELETE FROM tblAccount WHERE username='" + edtUsername.getText() + "'";
            db.execute(sql);
            Toast.makeText(AccountManager.this, "Deleted " + edtUsername.getText() + " !", Toast.LENGTH_SHORT).show();
            edtUsername.setText("");
            edtPassword.setText("");
            loadAccount();
            tabHost.setCurrentTab(1);
        } else {
            Toast.makeText(AccountManager.this, "Username is not exists.", Toast.LENGTH_SHORT).show();
        }
    }
}
