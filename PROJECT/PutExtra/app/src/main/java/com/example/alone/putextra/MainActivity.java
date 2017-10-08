package com.example.alone.putextra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    private EditText edName,edAge,edAddress,edPhone,edEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName=(EditText)findViewById(R.id.edHoTen);
        edAge=(EditText)findViewById(R.id.edNgaySinh);
        edAddress=(EditText)findViewById(R.id.edDiaChi);
        edPhone=(EditText)findViewById(R.id.edSoDienThoai);
        edEmail=(EditText)findViewById(R.id.edEmail);

        Button btSend=(Button)findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
        public  void onClick(View v)
            {
                Intent send=new Intent(MainActivity.this,Put.class);

                send.putExtra("name",edName.getText().toString());
                send.putExtra("age",edAge.getText().toString());
                send.putExtra("address",edAddress.getText().toString());
                send.putExtra("phone",edPhone.getText().toString());
                send.putExtra("email",edEmail.getText().toString());

                startActivity(send);
                Toast.makeText(MainActivity.this,"Success Sending..",Toast.LENGTH_LONG).show();
            }
        });
    }
}
