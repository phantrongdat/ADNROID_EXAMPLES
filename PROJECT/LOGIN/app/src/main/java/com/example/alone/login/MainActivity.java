package com.example.alone.login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    Button login;
    EditText user,password;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=(TextView)findViewById(R.id.txtDisplay);
        user=(EditText)findViewById(R.id.edtUser);
        password=(EditText)findViewById(R.id.edtPassword);

        login=(Button)findViewById(R.id.btLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equalsIgnoreCase("tk12.5")&&password.getText().toString().equals("fit"))
                {
                    display.setText("DANG NHAP THANH CONG !");
                }
                else {
                    display.setText("DANG NHAP THAT BAI !");
                }
            }
        });
    }
}
