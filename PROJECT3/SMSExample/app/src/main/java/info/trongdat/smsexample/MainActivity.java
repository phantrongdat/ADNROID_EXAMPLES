package info.trongdat.smsexample;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtPhone, edtMessage;
    Button btnSend;

    public static final String SMS_SENT_ACTION = "SMS_SENT_ACTION";
    public static final String SMS_DELIVERED_ACTION = "SMS_DELIVERED_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void initialize() {
        edtPhone = (EditText) findViewById(R.id.edtPhoneNumber);
        edtMessage = (EditText) findViewById(R.id.edtMessage);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    public void sendSMS() {
        String phone = edtPhone.getText().toString();
        String message = edtMessage.getText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, message, PendingIntent.getBroadcast(
                    getApplicationContext(), 0, new Intent(SMS_SENT_ACTION), 0), PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(SMS_DELIVERED_ACTION), 0));
            Toast.makeText(getApplicationContext(), "Sending success!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, Conversation.class);
            intent.putExtra("phone", phone);
            intent.putExtra("message", message);
            startActivity(intent);

        } catch (Exception e) {

        }
    }
}
