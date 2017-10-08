package com.example.alone.sending;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    EditText hoTen,soCMND,thongTinThem;
    CheckBox docSach,docBao,docCoding;
    RadioButton trungCap,caoDang,daiHoc;
    Button guiThongTin;
    String bangCap="",soThich="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setTitle("GUI THONG TIN");
        hoTen=(EditText)findViewById(R.id.edHoTen);
        soCMND=(EditText)findViewById(R.id.edCMND);
        thongTinThem=(EditText)findViewById(R.id.edThongTin);

        trungCap=(RadioButton)findViewById(R.id.rdTrungCap);
        caoDang=(RadioButton)findViewById(R.id.rdCaoDang);
        daiHoc=(RadioButton)findViewById(R.id.rdDaiHoc);

        trungCap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) bangCap=trungCap.getText().toString();
            }
        });
        caoDang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) bangCap=caoDang.getText().toString()+" ";
            }
        });
        daiHoc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) bangCap = daiHoc.getText().toString();
            }
        });




        docBao=(CheckBox)findViewById(R.id.cbDocBao);
        docSach=(CheckBox)findViewById(R.id.cbDocSach);
        docCoding=(CheckBox)findViewById(R.id.cbDocCoding);

        docBao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) soThich = soThich + (docBao.getText().toString());
            }
        });
        docSach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) soThich = soThich + docSach.getText().toString();
            }
        });
        docCoding.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) soThich = soThich + docCoding.getText().toString();
            }
        });

        guiThongTin=(Button)findViewById(R.id.btGuiThongTin);
        guiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder al=new AlertDialog.Builder(MainActivity.this);
                al.setTitle("Thong tin vua nhap !");
                al.setMessage("Ho Ten: " + hoTen.getText() + "\n" +
                        "So CMND: " + soCMND.getText() + "\n" +
                        "So Thich: " + soThich + "\n" +
                        "Bang cap: " + bangCap + "\n" +
                        "Thong tin bo xung: "+thongTinThem.getText());
                al.create().show();
//                Intent gui=new Intent(MainActivity.this,Sending_Success.class);
//                gui.putExtra("hoTen",hoTen.getText().toString());
//                gui.putExtra("soCMND",soCMND.getText().toString());
//                gui.putExtra("bangCap",bangCap);
//                gui.putExtra("soThich",soThich);
//                gui.putExtra("thongTinThem",thongTinThem.getText().toString());
//
//                startActivity(gui);

            }
        });


    }
}
