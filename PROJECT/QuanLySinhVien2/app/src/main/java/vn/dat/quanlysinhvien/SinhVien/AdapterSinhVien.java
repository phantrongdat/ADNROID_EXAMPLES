package vn.dat.quanlysinhvien.SinhVien;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.dat.quanlysinhvien.R;

/**
 * Created by Alone on 05/02/2016.
 */

public class AdapterSinhVien extends ArrayAdapter<SinhVien> {
    Activity context;
    ArrayList<SinhVien> sinhViens;
    int resource;

    public AdapterSinhVien(Activity context, int resource, ArrayList<SinhVien> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        sinhViens=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(resource,null);

        TextView maSV =(TextView)v.findViewById(R.id.txtMaSV);
        TextView maLop =(TextView)v.findViewById(R.id.txtMaLop);
        TextView hoTen =(TextView)v.findViewById(R.id.txtHoTen);
        ImageView imgGioiTinh=(ImageView)v.findViewById(R.id.imgGioiTinh);

        maSV.setText(sinhViens.get(position).getMaSV());
        maLop.setText(sinhViens.get(position).getMaLop());
        hoTen.setText(sinhViens.get(position).getHoTen());

        if (sinhViens.get(position).getGioiTinh().equalsIgnoreCase("nam"))
        {
            imgGioiTinh.setImageResource(R.drawable.large_ic_attachment);
        }else
        {
            imgGioiTinh.setImageResource(R.drawable.large_ic_audio);
        }
        return v;
    }
}
