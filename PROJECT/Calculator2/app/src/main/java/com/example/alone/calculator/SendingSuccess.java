package com.example.alone.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Alone on 1/11/2016.
 */
public class SendingSuccess extends ActionBarActivity {
    TextView hoTen,soCMND,bangCap,soThich,thongTinThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_success);

        Toast.makeText(SendingSuccess.this,"ABC XYZ",Toast.LENGTH_LONG).show();
       /* hoTen=(TextView)findViewById(R.id.tvHoTenGui);
        soCMND=(TextView)findViewById(R.id.tvCMNDGui);
        bangCap=(TextView)findViewById(R.id.tvBangCapGui);
        soThich=(TextView)findViewById(R.id.tvSoThichGui);
        thongTinThem=(TextView)findViewById(R.id.tvThongTinThemGui);

        Bundle bd=getIntent().getExtras();
        hoTen.setText(hoTen.getText().toString()+bd.getString("hoTen"));
        soCMND.setText(soCMND.getText().toString()+bd.getString("soCMND"));
        bangCap.setText(bangCap.getText().toString()+bd.getString("bangCap"));
        soThich.setText(soThich.getText().toString()+bd.getString("soThich"));
        thongTinThem.setText(thongTinThem.getText().toString()+bd.getString("thongTinThem"));*/
    }
}
