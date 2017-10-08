package info.trongdat.readxmljson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static info.trongdat.readxmljson.Constants.JSON_DATA;

public class JSONActivity extends AppCompatActivity {
    ArrayList<Product> products;
    ArrayAdapter<Product> adapter;
    ListView lstProduct;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        init();
        loadData();
    }

    public void init() {
        products = new ArrayList<>();
        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products);
        lstProduct = (ListView) findViewById(R.id.lstProduct);
        lstProduct.setAdapter(adapter);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void loadData() {
        try {
            String data = readJSONFromAsset(JSON_DATA);
            textView.setText(data);
            Log.d("datt", "loadData: " + data);
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = (JSONObject) jsonArray.get(i);
                String name = object.getString("Name");
                int id = object.getInt("Id");
                int price = object.getInt("Price");
                products.add(new Product(id, name, price));
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readJSONFromAsset(String data) {
        String json = null;
        try {
            InputStream is = getAssets().open(data);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
