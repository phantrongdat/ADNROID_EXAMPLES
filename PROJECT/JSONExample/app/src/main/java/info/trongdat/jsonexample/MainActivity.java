package info.trongdat.jsonexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView txtJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtJSON = (TextView) findViewById(R.id.textView);
        try {
            String s = new MyAsync().execute("http://hmqdulich.somee.com/api/travel/laydstinh/?idvung=2").get();
            String res = "";
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++) {


                JSONObject object = jsonArray.getJSONObject(i);
                res += "\nTỉnh: " + object.get("TenTinh");
            }
String s="<Products>\n" +
        "\t<Product>\n" +
        "\t   <Id>1</Id>\n" +
        "\t   <Name>Pen</Name>\n" +
        "\t   <Price>10000</Price>\n" +
        "\t</Product>\n" +
        "\t<Product>\n" +
        "\t   <Id>2</Id>\n" +
        "\t   <Name>Apple</Name>\n" +
        "\t   <Price>20000000</Price>\n" +
        "\t</Product>\n" +
        "\t<Product>\n" +
        "\t   <Id>3</Id>\n" +
        "\t   <Name>IPhone</Name>\n" +
        "\t   <Price>100000000</Price>\n" +
        "\t</Product>\n" +
        "</Products>";
            txtJSON.setText(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class MyAsync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            StringBuffer content = new StringBuffer();
            try {

                URL url = new URL(params[0]);
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new
                        InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}

