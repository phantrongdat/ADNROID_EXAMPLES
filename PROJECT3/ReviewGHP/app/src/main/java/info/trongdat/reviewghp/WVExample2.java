package info.trongdat.reviewghp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WVExample2 extends AppCompatActivity {
    EditText edtText;
    Button btnGo, btnS;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wvexample2);
        edtText = (EditText) findViewById(R.id.edtText);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnS = (Button) findViewById(R.id.btnStatic);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInternet()) {
                    webView.loadUrl(edtText.getText().toString());
                } else Toast.makeText(WVExample2.this, "No internet!", Toast.LENGTH_SHORT).show();

            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInternet()) {
                    webView.loadUrl("http://google.com");
                } else Toast.makeText(WVExample2.this, "No internet!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public boolean checkInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public class MyWebViewClient extends WebViewClient {

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


        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            Toast.makeText(WVExample2.this, "Error SLL, direction to google", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            Toast.makeText(WVExample2.this, "Error HTTP, direction to google", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Toast.makeText(WVExample2.this, "Error loading, direction to google", Toast.LENGTH_SHORT).show();
        }
    }
}