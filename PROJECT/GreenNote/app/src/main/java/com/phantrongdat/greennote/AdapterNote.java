package com.phantrongdat.greennote;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alone on 04/11/2016.
 */
public class AdapterNote extends ArrayAdapter<Note>{
    ArrayList<Note> arrayNote=new ArrayList<Note>();
    Activity context;
    int layout;
    public AdapterNote(Context context, int resource, ArrayList<Note> objects) {
        super(context, resource, objects);
        this.context= (Activity) context;
        arrayNote=objects;
        layout=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View noteView=inflater.inflate(layout, null);
        TextView titleView =(TextView)noteView.findViewById(R.id.txtTitleView);
        TextView contentView =(TextView)noteView.findViewById(R.id.txtContentView);
        ImageView imgContent=(ImageView)noteView.findViewById(R.id.imgContent);

        titleView.setText(arrayNote.get(position).getTitle().toString());
        contentView.setText(arrayNote.get(position).getContent().toString());
//        imgContent
        return noteView;
    }
}
