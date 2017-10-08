package info.trongdat.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Alone on 2/17/2017.
 */

public class MyBCR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String strData = intent.getStringExtra("message");
        Toast.makeText(context,"Data received: " +strData, Toast.LENGTH_SHORT).show();
    }
}
