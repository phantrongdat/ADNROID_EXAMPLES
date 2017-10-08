package info.trongdat.readdata;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ReadJSON extends AppCompatActivity {
    final String URL = "http://ptdcloud.com/jsonproducts";
    ListView lstData;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_json);
        lstData = (ListView) findViewById(R.id.lstData);

        new MyAsyncTask().execute(URL);
    }

    class MyAsyncTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            String data = "";
            try {
                URL url = new URL(params[0]);
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader =
                        new BufferedReader(
                                new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    data += line;
                }
                bufferedReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            txtData.setText(s);
            list = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = (JSONObject) jsonArray.get(i);
                    int id = object.getInt("Id");
                    String name = object.getString("Name");
                    int price = object.getInt("Price");
                    list.add(id + "\n" + name + "\n" + price);
                }
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(ReadJSON.this, android.R.layout.simple_list_item_1, list);
                lstData.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("datttttt", "onPostExecute: " + s);
        }
    }
}
