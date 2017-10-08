package com.example.alone.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends Activity {

    BluetoothAdapter BA;
    Button btVisible, btDevices;
    Switch swtBluetooth;
    ListView lvwList;
    Set<BluetoothDevice> pairedDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btVisible = (Button) findViewById(R.id.btGetvisible);
        btDevices = (Button) findViewById(R.id.btDeviceslist);
        swtBluetooth = (Switch) findViewById(R.id.swtBluetooth);

        BA = BluetoothAdapter.getDefaultAdapter();
        lvwList = (ListView) findViewById(R.id.livDevices);

        swtBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)on();
                else off();
            }
        });
    }

    public void on()
    {
        if (!BA.isEnabled())
        {
            BA.enable();
//            Intent turnOn=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(turnOn,0);
            Toast.makeText(getApplicationContext(),"Turned On",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Already On",Toast.LENGTH_SHORT).show();
        }
    }
    public void off(){
        BA.disable();
        Toast.makeText(getApplicationContext(), "Turned Off", Toast.LENGTH_SHORT).show();
    }

    public void visible(View view)
    {
        if (BA.isEnabled())
        {
        Intent getVisible=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
        }
        else {
            BA.enable();
            swtBluetooth.setChecked(true);
        }
    }
    public void getAvailable()
    {
        if (BA.isEnabled())
        {
//            Intent getAvailable=new Intent(BluetoothAdapter)
        }
    }

    public void listPaired(View view)
    {
//        Intent listDevices=new Intent(getApplicationContext(),DevicesAvailableList.class);
//        startActivity(listDevices);
        pairedDevices=BA.getBondedDevices();
        ArrayList list=new ArrayList();
        for (BluetoothDevice bd:pairedDevices)
        {
            list.add(bd.getName()+"\n"+bd.getAddress());

        }
        Toast.makeText(getApplicationContext(), "Showing Paired Devices", Toast.LENGTH_SHORT).show();
        ArrayAdapter adp=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1);
        lvwList.setAdapter(adp);
    }
}