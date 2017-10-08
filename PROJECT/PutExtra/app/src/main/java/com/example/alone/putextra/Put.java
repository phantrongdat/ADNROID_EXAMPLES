package com.example.alone.putextra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Put extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put);

        TextView tvName=(TextView)findViewById(R.id.tvHoTen);
        TextView tvAge=(TextView)findViewById(R.id.tvNgaySinh);
        TextView tvAddress=(TextView)findViewById(R.id.tvDiaChi);
        TextView tvPhone=(TextView)findViewById(R.id.tvSoSienThoai);
        TextView tvEmail=(TextView)findViewById(R.id.tvEmail);

        Bundle bd=getIntent().getExtras();
        String name=bd.getString("name");
        String age=bd.getString("age");
        String address=bd.getString("address");
        String phone=bd.getString("phone");
        String email=bd.getString("email");

        tvName.setText(tvName.getText().toString()+name);
        tvAge.setText(tvAge.getText().toString()+age);
        tvAddress.setText(tvAddress.getText().toString()+address);
        tvPhone.setText(tvPhone.getText().toString()+phone);
        tvEmail.setText(tvEmail.getText().toString()+email);

        Button back=(Button)findViewById(R.id.btBack);
        back.setOnClickListener(new View.OnClickListener()
        {
                                    @Override
                               public void onClick(View v)
                                   {
                                       Intent back=new Intent(Put.this,MainActivity.class);
                                       startActivity(back);
                                   }
        }
        );

    }
}
