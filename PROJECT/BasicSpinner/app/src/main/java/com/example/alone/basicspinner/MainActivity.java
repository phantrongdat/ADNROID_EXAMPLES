package com.example.alone.basicspinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtSpinner=(EditText)findViewById(R.id.edtSpinner);
        final TextView tvSpinner=(TextView)findViewById(R.id.tvSpinner);

        final int[] viTri = new int[1];

        final ArrayList<String> arr=new ArrayList<String>();
        arr.add("Phan Trong Dat");
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        Spinner spSpinner =(Spinner)findViewById(R.id.spSpinner);
        spSpinner.setAdapter(adapter);
        spSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viTri[0] = position;
                tvSpinner.setText("Đã chọn: "+arr.get(viTri[0]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button btThem=(Button)findViewById(R.id.btThem);

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.add(edtSpinner.getText().toString());
                adapter.notifyDataSetChanged();
                edtSpinner.setText("");
                tvSpinner.setText("Chọn để sửa|xóa: ");
            }
        });

        Button btSua=(Button)findViewById(R.id.btSua);
        btSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.set(viTri[0], edtSpinner.getText().toString());
                adapter.notifyDataSetChanged();
                edtSpinner.setText("");
                tvSpinner.setText("Chọn để sửa|xóa: ");
            }
        });
        Button btXoa=(Button)findViewById(R.id.btXoa);
        btXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.remove(viTri[0]);
                adapter.notifyDataSetChanged();
                tvSpinner.setText("Chọn để sửa|xóa: ");
            }
        });

    }
}

