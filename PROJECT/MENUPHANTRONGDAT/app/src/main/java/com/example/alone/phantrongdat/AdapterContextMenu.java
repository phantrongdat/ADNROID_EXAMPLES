package com.example.alone.phantrongdat;

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
 * Created by Alone on 03/21/2016.
 */
public class AdapterContextMenu extends ArrayAdapter<String> {
    ArrayList<String> arr = null;
    Activity context;
    int id;

    public AdapterContextMenu(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        arr = objects;
        this.context = (Activity) context;
        id = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(R.layout.context_menu_with_icon, null);
        TextView text = (TextView) convertView.findViewById(R.id.title);
        text.setText(arr.get(position));

        ImageView image = (ImageView) convertView.findViewById(R.id.icon);
        switch (position) {
            case 0:
                image.setImageResource(R.drawable.blue);
                break;
            case 1:
                image.setImageResource(R.drawable.red);
                break;
            case 2:
                image.setImageResource(R.drawable.white);
                break;
            case 3:
                image.setImageResource(R.drawable.yellow);
                break;
            case 4:
                image.setImageResource(R.drawable.green);
                break;
        }
        return convertView;
    }
}
