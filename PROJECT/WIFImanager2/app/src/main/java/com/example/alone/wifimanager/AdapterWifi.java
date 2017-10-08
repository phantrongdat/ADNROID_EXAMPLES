package com.example.alone.wifimanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alone on 04/02/2016.
 */
public class AdapterWifi extends ArrayAdapter {
    Activity context=null;
    ArrayList<WifiName> arrayList=null;
    int layoutID;

    public AdapterWifi( Activity context, int resource, ArrayList<WifiName> objects) {
        super(context, resource,objects);
        this.context= context;
        arrayList=objects;
        layoutID=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        convertView=inflater.inflate(R.layout.wifi_list_available,null);
        TextView name= (TextView) convertView.findViewById(R.id.txtWifiName);
        TextView status= (TextView) convertView.findViewById(R.id.txtStatus);

        name.setText(arrayList.get(position).getName());
        status.setText(arrayList.get(position).getStatus());


        return convertView;
    }
}
