package vn.dat.contacts;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alone on 05/06/2016.
 */
public class Them extends ActionBarActivity {


    // Khai báo biến
    DataBaseHandler db = new DataBaseHandler(this);
    //Khai báo biến toàn cục
    ArrayList<String> arrList = null;
    ArrayAdapter<String> adap = null;
    String strMaSo = null;
    String strTen = null;
    String strSDT = null;
    EditText editID;
    EditText editTen;
    EditText editSDT;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them);

        //
        try {
            lv = (ListView) findViewById(R.id.listViewDanhBa);
            editID = (EditText) findViewById(R.id.edtID);
            editTen = (EditText) findViewById(R.id.edtTen);
            editSDT = (EditText) findViewById(R.id.edtSDT);

            //
            db.copyDB2SDCard();
            //Hiển thị dữ liệu từ CSDL lên ListVIew
            data2ListView();
            //
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String row = arrList.get(position);
                    String Mang[] = row.split("-");
                    editID.setText(Mang[0]);
                    editTen.setText(Mang[1]);
                    editSDT.setText(Mang[2]);

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phương thức 2: Load dữ liệu lên ListVIew
    public void data2ListView() {

        //Khởi tạo lại ArrayList
        arrList = new ArrayList<String>();
        //Lấy dữ liệu vào ArrayList
        Cursor c = db.getCursor("select * from tblContatcs");
//        c.moveToFirst();
        while (c.moveToNext()) {
            String row = c.getString(0) + "-" +c.getString(1) + "-" + c.getString(2);
            arrList.add(row);
        }
        //Set Adapter
        adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adap);
    }


    //Phương thức 3: Thêm CSDL
    public void Them(View v) {
        Cursor c = db.getCursor("select * from tblContatcs where ID ='" + editID.getText() + "' ");
        if (c.getCount() == 1) {
            Toast.makeText(Them.this, "Mã SDT đã tồn tại,Vui long nhập mã khác", Toast.LENGTH_LONG).show();
        } else {
            db.excuteSQL("Insert into tblContatcs values('" + editID.getText() + "','" + editTen.getText() + "','" + editSDT.getText() + "')");
            Toast.makeText(Them.this, "Đã thêm thành công!", Toast.LENGTH_LONG).show();
            data2ListView();
            //
            editID.setText("");
            editTen.setText("");
            editSDT.setText("");

        }
    }

