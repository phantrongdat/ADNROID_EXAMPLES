package info.trongdat.reviewghp;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void connectivityManager() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetwork() != null) {
            Toast.makeText(this, "Activated", Toast.LENGTH_SHORT).show();
        }
    }

    private void smsManager() {
        SmsManager smsManager = SmsManager.getDefault();
    }

    private void location() {
        Location location;
//        location.getLatitude();
    }

    private void locationManager() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.addGpsStatusListener(new GpsStatus.Listener() {
            @Override
            public void onGpsStatusChanged(int event) {

            }
        });

//        locationManager.getGpsStatus();
        locationManager.getProvider("");
    }

    private void url() {
        try {
            URL url = new URL("aaa");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void urlConnection() {
        try {
            URLConnection urlConnection = new URL("a").openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void httpURLConnection() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("A").openConnection();
            httpURLConnection.getURL();
            httpURLConnection.getResponseMessage();
            //connect, disconnect,

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void intent() {
        Intent intent = new Intent();
        intent.setAction("A");
        intent.putExtra("a", "a");
        intent.getAction();
        intent.getExtras();
        intent.removeExtra("A");

    }

    private void service() {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
    }

    private void broadcastReceiver() {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephone.SMS_RECEIVED");

        registerReceiver(broadcastReceiver, intentFilter);
    }

    private void asyncTask() {
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute("aaaaaaaaa");

    }

    private void webView() {
        WebView webView=new WebView(this);
        webView.getSettings();

    }

    class MyWebViewClient extends WebViewClient{
        public MyWebViewClient() {
            super();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }
    }

    class MyAsyncTask extends AsyncTask<String, Integer, String> {

        @Override
        public String doInBackground(String... params) {
            try {
                URL url = new URL("a");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                Bitmap bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                return httpURLConnection.getResponseMessage().toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }

        public void onPostExecute(String s) {

        }
    }

}
