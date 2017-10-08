package com.example.alone.wifimanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alone on 04/02/2016.
 */
public class WIFI extends ActionBarActivity {

    Switch status;
    TextView txtList;
    ListView listAvailable;
    ArrayList<WifiName> arr = new ArrayList<WifiName>();
    AdapterWifi adapter;

    WifiManager wifiManager;
    WifiScanReceiver scanReceiver;
    List<ScanResult> wifiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (Switch) findViewById(R.id.switch1);

        txtList = (TextView) findViewById(R.id.txtListAvailable);
        listAvailable = (ListView) findViewById(R.id.lvwList);
        listAvailable.setCacheColorHint(Color.BLACK);
        adapter = new AdapterWifi(this, R.layout.wifi_list_available,arr);
        listAvailable.setAdapter(adapter);

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        scanReceiver = new WifiScanReceiver();
        registerReceiver(scanReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) on();
                else off();
            }
        });
    }

    public void on() {
        txtList.setText("Wifi List Available !");
        wifiManager.setWifiEnabled(true);
        scanWifi();
    }

    public void off() {
        wifiManager.setWifiEnabled(false);
        txtList.setText("Offline !");
        arr.clear();
        adapter.clear();
        wifiManager.disconnect();
    }

    public void scanWifi() {
        wifiManager.startScan();
        Toast.makeText(getApplicationContext(), "Starting Scan...", Toast.LENGTH_SHORT).show();
    }

    class WifiScanReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            wifiList = wifiManager.getScanResults();

            for (int i = 0; i < wifiList.size(); i++) {
                arr.add(new WifiName(wifiList.get(i).SSID,wifiList.get(i).capabilities));
            }
            adapter.notifyDataSetChanged();
        }
    }
}
