package com.dat17.wservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alone on 6/14/2016.
 */

public class AccountList extends AppCompatActivity
        implements AsyncResponse {
    ListView lstAccount;
    ArrayList<Account> arrayList;
    AdapterAccount adapter;
    TextView txtUser;
    String hiUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Bundle bundle=getIntent().getExtras();
        hiUser=bundle.getString("username");

        txtUser=(TextView)findViewById(R.id.hiUser);
        txtUser.setText("Hi! "+hiUser);
        lstAccount = (ListView) findViewById(R.id.lstAccount);
        lstAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent edit=new Intent(AccountList.this,AccountEdit.class);
                edit.putExtra("username",arrayList.get(position).getUsername());
                edit.putExtra("password",arrayList.get(position).getPassword());
                edit.putExtra("email",arrayList.get(position).getEmail());
                edit.putExtra("imgURL",arrayList.get(position).getImgURL());
                startActivity(edit);
            }
        });
    }

    @Override
    protected void onResume() {
        loadAccount();
        super.onResume();
    }

    public void loadAccount() {
        arrayList = new ArrayList<>();
        adapter = new AdapterAccount(this,R.layout.list_item_account, arrayList);
        lstAccount.setAdapter(adapter);

        HashMap dataPost=new HashMap();
        dataPost.put("action","get");
        PostResponseAsyncTask asyncTask = new PostResponseAsyncTask(this, dataPost);
        asyncTask.execute("http://devmobile.club/services/index.php");
    }

    @Override
    public void processFinish(String s) {
        Log.e("RESPONSE", "processFinish: "+s);
        try {
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                arrayList.add(
                        new Account(jsonObject.getString("username"), jsonObject.getString("password"),
                                jsonObject.getString("email"),jsonObject.getString("imageURL")));
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
