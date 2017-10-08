package info.trongdat.smsexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by Alone on 2/24/2017.
 */

public class MReceivedSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        SmsMessage[] msgs = null;
        String str = "";
        String number="";
        if (bundle != null) {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                number += "Received: " + msgs[i].getOriginatingAddress();

                str += msgs[i].getMessageBody().toString();

        }

            // process string sms str//
            NotificationManager notif=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notify=new Notification.Builder
                    (context).setContentTitle("SMS Received").setContentText(str).
                    setContentTitle(number).setSmallIcon(R.drawable.ic_launcher).build();
            notify.flags |= Notification.FLAG_AUTO_CANCEL;
            notif.notify(0, notify);
        }
    }
}
