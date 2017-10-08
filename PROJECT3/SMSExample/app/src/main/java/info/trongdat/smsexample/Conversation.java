package info.trongdat.smsexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Conversation extends AppCompatActivity {
    LinearLayout layoutSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        initialize();

        ActionBar actionBar = getSupportActionBar();
        Bundle bundle = getIntent().getExtras();
        String phone = bundle.getString("phone");
        String message = bundle.getString("message");
        actionBar.setTitle(phone);

        TextView textView = new TextView(this);
        textView.setText("Send: " + message + "\n");
        layoutSMS.addView(textView);
        registerBroadCastReceivers();
    }


    public void initialize() {
        layoutSMS = (LinearLayout) findViewById(R.id.layoutSMS);
    }

    private void registerBroadCastReceivers() {

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        processReceived(arg0, arg1);

                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        break;
                    default:
                        break;
                }

            }
        }, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {

                    case Activity.RESULT_OK:

                        break;
                    case Activity.RESULT_CANCELED:

                        break;
                }
            }
        }, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));

    }

    public void processReceived(Context arg0, Intent arg1) {
        Bundle bundle = arg1.getExtras();
        SmsMessage[] msgs = null;
        String str = "";
        if (bundle != null) {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                str += "Received: " + msgs[i].getOriginatingAddress();
                str += " :";
                str += msgs[i].getMessageBody().toString();
                str += "n";
            }
            TextView textView = new TextView(this);
            textView.setText(str);
            layoutSMS.addView(textView);

        }
    }
}
