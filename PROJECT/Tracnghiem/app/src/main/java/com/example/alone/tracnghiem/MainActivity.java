package com.example.alone.tracnghiem;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends ActionBarActivity {

    CheckBox teacher;
    RadioButton rdb24, rdbMale, rdbSleeping;
    Button back,next;
    int diem=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teacher=(CheckBox)findViewById(R.id.cbxTeacher);
        rdb24=(RadioButton)findViewById(R.id.rdb24);
        rdbMale=(RadioButton)findViewById(R.id.rdbMale);
        rdbSleeping=(RadioButton)findViewById(R.id.rdbSleeping);

        back=(Button)findViewById(R.id.btnBack);
        next=(Button)findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (teacher.isChecked())diem+=10;
                if (rdb24.isChecked())diem+=10;
                if (rdbMale.isChecked())diem+=10;
                if (rdbSleeping.isChecked())diem+=10;

                AlertDialog.Builder al=new AlertDialog.Builder(MainActivity.this);
                al.setTitle("Diem cua ban");
                al.setMessage("Ban duoc " + diem);
                al.create().show();
                diem=0;
            }
        });
    }
}
