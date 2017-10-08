package info.trongdat.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Alone on 2/17/2017.
 */

public class BatteryStateBCR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Battery is changing..",Toast.LENGTH_SHORT).show();
    }
}
