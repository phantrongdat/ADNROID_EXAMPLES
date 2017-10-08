package com.example.alone.customlisview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alone on 03/20/2016.
 */
public class AdapterCustom extends ArrayAdapter<String> {
    Activity context=null;
    ArrayList<String> arr;
    int layoutID;

    public AdapterCustom(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context= (Activity) context;
        this.layoutID=resource;
        this.arr=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        convertView=inflater.inflate(R.layout.list_custom,null);
        TextView name=(TextView)convertView.findViewById(R.id.txtList);
        String list=arr.get(position);
        name.setText(list.toString());
        ImageView icon=(ImageView)convertView.findViewById(R.id.imgList);
        switch (position)
        {
            case 0: icon.setImageResource(R.drawable.iconsearch);break;
            case 1: icon.setImageResource(R.drawable.iconsearchfocus);break;
            case 2: icon.setImageResource(R.drawable.iconnew);break;
            case 3: icon.setImageResource(R.drawable.iconnewfocus);break;
            case 4: icon.setImageResource(R.drawable.iconnotification);break;
            case 5: icon.setImageResource(R.drawable.iconnotificationfocus);break;
        }
        return convertView;
    }
}
