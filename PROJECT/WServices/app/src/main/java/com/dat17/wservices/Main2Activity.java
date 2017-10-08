package com.dat17.wservices;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity
        implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        HashMap hashMap = new HashMap();
        hashMap.put("action", "get");
        PostResponseAsyncTask asyncTask =
                new PostResponseAsyncTask(this, hashMap);
        asyncTask.execute("http://devmobile.club/services/index.php");
    }

    @Override
    public void processFinish(String s) {
        Log.e("JSONzzz", s);
        String user = "";
        try {
            JSONArray jsonArray = new JSONArray(s);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                user += jsonObject.getString("username");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("JSONzzz", user);
    }
}
