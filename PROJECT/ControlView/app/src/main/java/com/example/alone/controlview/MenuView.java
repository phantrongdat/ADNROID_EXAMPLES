package com.example.alone.controlview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuView extends ActionBarActivity {
    private TextView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);
        gv=(TextView)findViewById(R.id.tvGV);
        getSupportActionBar().setTitle("OptionMenu");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chon_gv,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.itemNMQuy:
                gv.setText("NGUYỄN MINH QUÝ");
                break;
            case R.id.itemNVHau:
                gv.setText("NGUYỄN VĂN HẬU");
                break;
            case R.id.itemHQViet:
                gv.setText("HOÀNG QUỐC VIỆT");
            break;
            case R.id.itemNTHNang:
                gv.setText("NGUYỄN THỊ HẢI NĂNG");
            break;
            case R.id.itemNTHuyen:
                gv.setText("NGÔ THANH HUYỀN");
                break;
            case R.id.itemNHDiep:
                gv.setText("NGUYỄN HOÀNG ĐIỆP");
                break;
            case R.id.itemNHDong:
                gv.setText("NGUYỄN HỮU ĐÔNG");
                break;
            case R.id.itemBTHong:
                gv.setText("BÙI THẾ HỒNG");
                break;
            case R.id.itemPMChuan:
                gv.setText("PHẠM MINH CHUẨN");
                break;
            case R.id.itemVXThang:
                gv.setText("VŨ XUÂN THẮNG");
            break;
            case R.id.itemPQHung:
                gv.setText("PHẠM QUỐC HÙNG");
                break;
            case R.id.itemNVHanh:
                gv.setText("NGUYỄN VĂN HẠNH");
                break;
            case R.id.itemPNHung:
                gv.setText("PHẠM NGỌC HƯNG");
                break;
            case R.id.itemCBThanh:
                gv.setText("CHU BÁ THÀNH");
            break;
            case R.id.itemTTPhuong:
                gv.setText("TRẦN THỊ PHƯƠNG");
                break;
            case R.id.itemVTGiang:
                gv.setText("VŨ THỊ GIANG");
                break;
            case R.id.itemNVHau1:
                gv.setText("NGUYỄN VĂN HẬU");
                break;
            case R.id.itemHQViet1:
                gv.setText("HOÀNG QUỐC VIỆT");
                break;
        }

        return true;
    }
}
