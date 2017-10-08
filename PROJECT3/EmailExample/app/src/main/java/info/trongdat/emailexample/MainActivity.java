package info.trongdat.emailexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtAddress, edtSubject, edtBody;
    Button btnSend, btnSendNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        edtSubject = (EditText) findViewById(R.id.edtSubject);
        edtBody = (EditText) findViewById(R.id.edtBody);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnSendNow = (Button) findViewById(R.id.btnSendNow);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        btnSendNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNow();
            }
        });

    }

    public void send() {
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        intent.setData(Uri.parse("mailto:"));
        intent.setType("message/rfc822");

        String[] address = edtAddress.getText().toString().split(";");
        intent.putExtra(Intent.EXTRA_EMAIL, address);
        intent.putExtra(Intent.EXTRA_SUBJECT, edtSubject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, edtBody.getText().toString());

//        startActivity(intent);
        startActivity(Intent.createChooser(intent, "Send email with..."));
        finish();
    }

    public void sendNow() {


    }
}
