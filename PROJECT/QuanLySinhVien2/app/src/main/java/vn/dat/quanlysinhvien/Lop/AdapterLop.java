package vn.dat.quanlysinhvien.Lop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.dat.quanlysinhvien.R;

/**
 * Created by Alone on 05/02/2016.
 */
public class AdapterLop extends ArrayAdapter<Lop> {
    Activity context;
    ArrayList<Lop> lops;
    int resource;

    public AdapterLop(Activity context, int resource, ArrayList<Lop> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        lops = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(resource, null);

        TextView tenLop = (TextView) v.findViewById(R.id.txtTenLop);
        TextView maLop = (TextView) v.findViewById(R.id.txtMaLop);
        TextView soSV = (TextView) v.findViewById(R.id.txtSoSV);

        tenLop.setText(lops.get(position).getTenLop());
        maLop.setText(lops.get(position).getMaLop());
        soSV.setText(lops.get(position).getSiSo()+"");

        return v;
    }
}