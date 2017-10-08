package com.dat17.wservices;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alone on 6/14/2016.
 */
public class AdapterAccount extends ArrayAdapter<Account> {
    Activity context;
    ArrayList<Account> accounts;
    int layout;

    public AdapterAccount(Activity context, int resource, ArrayList<Account> objects) {
        super(context, resource, objects);
        this.context = context;
        accounts = objects;
        layout = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View v = layoutInflater.inflate(layout, null);

        ImageView imgAccount= (ImageView) v.findViewById(R.id.imgAccount);
        TextView txtUsername=(TextView)v.findViewById(R.id.txtUsername);
        TextView txtPassword=(TextView)v.findViewById(R.id.txtPassword);
        TextView txtEmail=(TextView)v.findViewById(R.id.txtEmail);

        txtUsername.setText(accounts.get(position).getUsername());
        txtPassword.setText(accounts.get(position).getPassword());
        txtEmail.setText(accounts.get(position).getEmail());

        String imgURL=accounts.get(position).getImgURL();
        Picasso.with(context)
                .load(imgURL)//url hình ảnh
                .placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher)         // Hiển thị hình ảnh lỗi nếu link ảnh không tồn tại
                .into(imgAccount);
        return v;
    }
}
