package com.example.alone.sqlitecreate;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AccountManagement extends ActionBarActivity {

    MyDatabase mydb = new MyDatabase(this);
    Button btAdd, btUpdate, btDelete;
    TextView tvAccount;
    EditText edtUser, edtPassword;
    ListView lvAccount;
    ArrayList<String> arr;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);

        tvAccount = (TextView) findViewById(R.id.tvAccount);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        lvAccount = (ListView) findViewById(R.id.lvAccount);

        loadData();

        lvAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] acc = arr.get(position).split(" ");
                edtUser.setText(acc[0]);
            }
        });
    }

    public void loadData() {
        arr = new ArrayList<String>();
        Cursor c = mydb.getData("SELECT*FROM Account");
        while (c.moveToNext()) {
            arr.add(c.getString(0) + " - " + c.getString(1));
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lvAccount.setAdapter(adapter);
        edtUser.setText("");
        edtPassword.setText("");
    }

    public void addAccount(View view) {
        try {
            mydb.queryData("INSERT INTO Account VALUES('" + edtUser.getText().toString() + "','" + edtPassword.getText().toString() + "')");
        } catch (Exception e) {
            Toast.makeText(AccountManagement.this, "Tai khoan da ton tai", Toast.LENGTH_LONG).show();
        }
        loadData();
        //adapter.notifyDataSetChanged();
    }

    public void updateAccount(View view) {
        try {
            if (mydb.isExists(edtUser.getText().toString())) {
                mydb.queryData("UPDATE Account SET password='" + edtPassword.getText() + "' WHERE user='" + edtUser.getText() + "'");
            } else {
                Toast.makeText(AccountManagement.this, "Tai khoan nay khong ton tai !", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            AlertDialog.Builder al = new AlertDialog.Builder(AccountManagement.this);
            al.setTitle("Error !");
            al.setMessage("Khong the cap nhat tai khoan !");
            al.create().show();
        }
        loadData();
        //adapter.notifyDataSetChanged();
    }

    public void deleteAccount(View view) {
        try {
            if (mydb.isExists(edtUser.getText().toString())) {
                mydb.queryData("DELETE FROM Account WHERE user='" + edtUser.getText() + "'");
            } else {
                Toast.makeText(AccountManagement.this, "Tai khoan nay khong ton tai !", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            AlertDialog.Builder al = new AlertDialog.Builder(AccountManagement.this);
            al.setTitle("Error !");
            al.setMessage("Khong the xoa tai khoan !");
            al.create().show();
        }
        loadData();
        //adapter.notifyDataSetChanged();
    }

    public void searchAccount(View view) {
        ArrayList<String> result = new ArrayList<String>();
        Cursor cur = mydb.getData("SELECT*FROM Account WHERE user LIKE '%"+edtUser.getText()+"%'");
        while (cur.moveToNext()) {
            result.add(cur.getString(0) + " - " + cur.getString(1));
        }
        ArrayAdapter adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, result);
        lvAccount.setAdapter(adap);
    }

}
