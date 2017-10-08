package com.example.alone.batterynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Alone on 3/10/2017.
 */

public class BatteryListenerBCR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String state="";
        String title="Battery state: ";
        // process ACTION.
        switch (intent.getAction())
        {
            case "android.intent.action.ACTION_POWER_CONNECTED":
                title+="Connected";
                state="Power is connected! \n Do not remove adapter .....";
                break;
            case "android.intent.action.ACTION_POWER_DISCONNECTED":
                title+="Disconnected";
                state="Power is disconnected! \n Do not remove adapter .....";
                break;
            case "android.intent.action.BATTERY_CHANGED":
                title+="Changed";
                state="Battery is changed! \n Do not remove adapter .....";
                break;
            case "android.intent.action.BATTERY_LOW":
                title+="Low";
                state="Battery is Low! \n Please connect to adapter .....";
                break;
            case "android.intent.action.BATTERY_OKEY":
                title+="Full";
                state="Battery is Full! \n Disconnect adapter .....";
                break;
        }
        NotificationManager notif=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification.Builder
                (context).setContentTitle("Battery State ").setContentText(state).
                setContentTitle(title).setSmallIcon(R.drawable.ic_launcher).build();
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.notify(0, notify);
    }
}
