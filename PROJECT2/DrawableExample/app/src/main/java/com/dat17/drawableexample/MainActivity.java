package com.dat17.drawableexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button choose, shape1,shape2,shape3,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choose=(Button)findViewById(R.id.btnChoose);
        shape1=(Button)findViewById(R.id.btnShape);
        shape2=(Button)findViewById(R.id.btnShape2);
        shape3=(Button)findViewById(R.id.btnShape3);
        btn2=(Button)findViewById(R.id.button2);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shape1.setEnabled(false);
                shape2.setEnabled(false);
                shape3.setEnabled(false);
            }
        });


        
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shape1.setEnabled(true);
                shape2.setEnabled(true);
                shape3.setEnabled(true);
            }
        });
    }
}
