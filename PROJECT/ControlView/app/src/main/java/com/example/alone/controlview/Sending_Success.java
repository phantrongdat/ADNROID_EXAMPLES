package com.example.alone.controlview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sending_Success extends ActionBarActivity {
    TextView hoTen,soCMND,bangCap,soThich,thongTinThem;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending__success);

        Toast.makeText(Sending_Success.this, "Sending Sucess !", Toast.LENGTH_LONG).show();
        hoTen=(TextView)findViewById(R.id.tvHoTenGui);
        soCMND=(TextView)findViewById(R.id.tvCMNDGui);
        bangCap=(TextView)findViewById(R.id.tvBangCapGui);
        soThich=(TextView)findViewById(R.id.tvSoThichGui);
        thongTinThem=(TextView)findViewById(R.id.tvThongTinThemGui);

        Bundle bd=getIntent().getExtras();
        hoTen.setText(hoTen.getText().toString()+bd.getString("hoTen"));
        soCMND.setText(soCMND.getText().toString()+bd.getString("soCMND"));
        bangCap.setText(bangCap.getText().toString() + bd.getString("bangCap"));
        soThich.setText(soThich.getText().toString() + bd.getString("soThich"));
        thongTinThem.setText(thongTinThem.getText().toString() + bd.getString("thongTinThem"));

        back=(Button)findViewById(R.id.btQuayLai);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itBack=new Intent(Sending_Success.this,MainActivity.class);
                startActivity(itBack);
            }
        });
    }

}
