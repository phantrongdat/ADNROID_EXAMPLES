package com.example.alone.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends ActionBarActivity{

    private EditText hoTen,soCMND,thongTinThem;
    private CheckBox docSach,docBao,docCoding;
    private RadioButton trungCap,caoDang,daiHoc;
    private Button guiThongTin;
    private String bangCap="",soThich="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);
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
                if (isChecked) bangCap=caoDang.getText().toString();
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
                if (isChecked) soThich+=docBao.getText().toString();
            }
        });
        docSach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) soThich += docSach.getText().toString();
            }
        });
        docCoding.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) soThich += docCoding.getText().toString();
            }
        });

        guiThongTin=(Button)findViewById(R.id.btGuiThongTin);
        guiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gui = new Intent(MainActivity.this, SendingSuccess.class);
                /*gui.putExtra("hoTen",hoTen.getText().toString());
                gui.putExtra("soCMND",soCMND.getText().toString());
                gui.putExtra("bangCap",bangCap);
                gui.putExtra("soThich",soThich);
                gui.putExtra("thongTinThem",thongTinThem.getText().toString());
*/
                startActivity(gui);

            }
        });
    }

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        ListView list=(ListView)findViewById(R.id.listHD);
        ArrayList<String> a=new ArrayList<String>();

        a.add("myuser");
        a.add("phantrongdat");
        a.add("datphan");

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,a);

        list.setAdapter(adapter);

    }*/

   /* private LinearLayout loginBackground;
    private Button ok;
    private EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ok=(Button)findViewById(R.id.ok1);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checkBox = new Intent(MainActivity.this, CheckBox1.class);
                startActivity(checkBox);
            }
        });

        //Intent calculator=new Intent(MainActivity.this,Calculator.class);
        //startActivity(calculator);

    }
*/
}
