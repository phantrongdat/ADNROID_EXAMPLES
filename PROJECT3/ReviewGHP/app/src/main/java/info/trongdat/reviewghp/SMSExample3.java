package info.trongdat.reviewghp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SMSExample3 extends AppCompatActivity {
    EditText edtNumber, edtText;
    Button btnSend;
    TextView txtMessage;
    BroadcastReceiver broadcastReceiver;
    static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsexample3);

        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtText = (EditText) findViewById(R.id.edtText);
        btnSend = (Button) findViewById(R.id.btnSend);
        txtMessage = (TextView) findViewById(R.id.txtMessage);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProcess();
            }
        });


        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (getResultCode() == RESULT_OK) {
                    receiveProcess(context, intent);
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter(ACTION_SMS_RECEIVED);
        registerReceiver(broadcastReceiver, intentFilter);

    }

    public void sendProcess() {
        String number = edtNumber.getText().toString();
        String text = edtText.getText().toString();

        if (number.equals("") || text.equals(""))
            Toast.makeText(SMSExample3.this, "Enter you phone number or message", Toast.LENGTH_SHORT).show();
        else {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, text,
                    PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(SMSExample3.ACTION_SMS_RECEIVED), 0),
                    PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(SMSExample3.ACTION_SMS_RECEIVED), 0));
        }
    }

    public void receiveProcess(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages;
        String message = "";
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            messages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                message += "Message from: " + messages[i].getOriginatingAddress()
                        + "\n" + messages[i].getMessageBody();

            }
            txtMessage.setText(message);
        }
    }
}
