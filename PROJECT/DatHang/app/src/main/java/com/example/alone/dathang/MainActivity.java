package com.example.alone.dathang;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private CheckBox coffe, kem, bimbim, suachua, suaChuaNep;
    private Button datHang;
    private TextView tongTien;
    EditText edtCoffe, edtKem, edtBimbim, edtSuachua, edtSuaChuaNep;
    int giaCoffe = 20000, giaKem = 10000, giaBimbim = 5000, giaSuachua = 6000, giaSuaChuaNep = 12000;
    private int sum = 0;
    int soCoffe = 1, soBimBim = 1, soKem = 1, soSuaChua = 1, soSuaChuaNep = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("CheckBox");


        coffe = (CheckBox) findViewById(R.id.cbxCoffe);
        kem = (CheckBox) findViewById(R.id.cbxKem);
        bimbim = (CheckBox) findViewById(R.id.cbxbimbim);
        suachua = (CheckBox) findViewById(R.id.cbxSuaChua);
        suaChuaNep = (CheckBox) findViewById(R.id.cbxSuaChuaNepCam);

        edtCoffe = (EditText) findViewById(R.id.edtCoffe);
        edtKem = (EditText) findViewById(R.id.edtKem);
        edtBimbim = (EditText) findViewById(R.id.edtBim);
        edtSuachua = (EditText) findViewById(R.id.edtSua);
        edtSuaChuaNep = (EditText) findViewById(R.id.edtSuaNep);

        tongTien = (TextView) findViewById(R.id.txtTien);

        coffe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sum += giaCoffe * soCoffe;
                    tongTien.setText("" + sum);
                    edtCoffe.setText("1");
                } else {
                    sum -= giaCoffe * soCoffe;
                    tongTien.setText("" + sum);
                    edtCoffe.setText("0");
                }
            }
        });

        edtCoffe.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {

                }
                return false;
            }
        });

        edtCoffe.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                soCoffe = Integer.parseInt(v.getText().toString());
                sum += giaCoffe * soCoffe;

                tongTien.setText("" + sum);
                return false;
            }
        });


        if (coffe.isChecked()) {
            edtCoffe.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    soCoffe = Integer.parseInt(v.getText().toString());
                    sum += giaCoffe * soCoffe;

                    tongTien.setText("" + sum);

                    return false;
                }
            });
        }

        kem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    sum -= 10000 * soKem;
                    tongTien.setText("" + sum);
                    edtKem.setText("0");
                }
            }
        });
        edtKem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                soKem = Integer.parseInt(edtKem.getText().toString());
                if (coffe.isChecked()) {
                    sum += 10000 * soKem;
                }
                tongTien.setText("" + sum);

                return false;
            }
        });

        bimbim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    sum -= 5000 * soBimBim;
                    tongTien.setText("" + sum);
                    edtBimbim.setText("0");
                }
            }
        });

        edtBimbim.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                soBimBim = Integer.parseInt(edtBimbim.getText().toString());
                if (coffe.isChecked()) {
                    sum += 5000 * soBimBim;
                }
                tongTien.setText("" + sum);

                return false;
            }
        });

        suachua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    sum -= 6000 * soSuaChua;
                    tongTien.setText("" + sum);
                    edtSuachua.setText("0");
                }
            }
        });

        edtSuachua.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                soSuaChua = Integer.parseInt(edtSuachua.getText().toString());
                if (coffe.isChecked()) {
                    sum += 6000 * soSuaChua;
                }
                tongTien.setText("" + sum);

                return false;
            }
        });


        suaChuaNep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    sum -= 12000 * soSuaChuaNep;
                    tongTien.setText("" + sum);
                    edtSuaChuaNep.setText("0");
                }
            }
        });

        edtSuaChuaNep.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                soSuaChua = Integer.parseInt(edtSuaChuaNep.getText().toString());
                if (coffe.isChecked()) {
                    sum += 12000 * soSuaChuaNep;
                }
                tongTien.setText("" + sum);

                return false;
            }
        });
    }
}
