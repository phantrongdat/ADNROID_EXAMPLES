package com.example.alone.basiclistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtList=(EditText)findViewById(R.id.edtListView);
        final TextView tvListView=(TextView)findViewById(R.id.tvListView);

        final int[] viTri = new int[1];

        final ArrayList<String> arr=new ArrayList<String>();
        final ArrayAdapter<String>  adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        ListView lvList=(ListView)findViewById(R.id.lvListView);
        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viTri[0] = position;
                tvListView.setText("Đã chọn: "+arr.get(viTri[0]));
            }
        });


        Button btThem=(Button)findViewById(R.id.btThem);

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.add(edtList.getText().toString());
                adapter.notifyDataSetChanged();
                edtList.setText("");
                tvListView.setText("Chọn để sửa|xóa: ");
            }
        });

        Button btSua=(Button)findViewById(R.id.btSua);
        btSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.set(viTri[0], edtList.getText().toString());
                adapter.notifyDataSetChanged();
                edtList.setText("");
                tvListView.setText("Chọn để sửa|xóa: ");
            }
        });
        Button btXoa=(Button)findViewById(R.id.btXoa);
        btXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.remove(viTri[0]);
                adapter.notifyDataSetChanged();
                tvListView.setText("Chọn để sửa|xóa: ");
            }
        });

    }
}
