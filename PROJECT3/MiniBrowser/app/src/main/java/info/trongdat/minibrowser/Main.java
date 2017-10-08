package info.trongdat.minibrowser;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    EditText edtURL;
    Button btnGo;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        if (!checkInternet()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("No internet :3");
            builder.setMessage("Please connect to your internet and try again!!!");
            builder.create().show();
        }
    }

    public void initialize() {
        edtURL = (EditText) findViewById(R.id.edtURL);
        btnGo = (Button) findViewById(R.id.btnGo);
        webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new AppWebViewClients());

        webView.getSettings().setJavaScriptEnabled(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(edtURL.getText().toString());
            }
        });
    }

    public class AppWebViewClients extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
        }
    }


//    public void loadURL()
//    {
//        String url=edtURL.getText().toString();
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl(url);
//
//    }

    public boolean checkInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() &&
                cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
