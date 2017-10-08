package vn.dat.quanlysinhvien;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtMaSV, edtHoTen, edtLop, edtGioiTinh, edtDiaChi;
    ListView lstSinhVien;
    ArrayList<String> list;
    ArrayAdapter adapter;
    DatabaseHandler2 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler2(this);
        try {
            db.copyDB2SDCard();
        } catch (IOException e) {
            e.printStackTrace();
        }

        db.openDB();

        edtMaSV = (EditText) findViewById(R.id.edtMaSV);
        edtHoTen = (EditText) findViewById(R.id.edtTenSV);
        edtLop = (EditText) findViewById(R.id.edtLop);
        edtGioiTinh = (EditText) findViewById(R.id.edtGioiTinh);
        edtDiaChi = (EditText) findViewById(R.id.edtQueQuan);

        lstSinhVien = (ListView) findViewById(R.id.lstSinhVien);

        getSinhVien();
    }

    public void getSinhVien() {
        list = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lstSinhVien.setAdapter(adapter);
        Cursor c = db.rawQuery("SELECT * FROM tblSinhVien");
        int masv, lop;
        String hoten, gioitinh, quequan;
        while (c.moveToNext()) {
            masv = c.getInt(0);
            hoten = c.getString(1);
            lop = c.getInt(2);
            gioitinh = c.getString(3);
            quequan = c.getString(4);
            SinhVien sv = new SinhVien(masv, hoten, lop, gioitinh, quequan);
            list.add(sv.toString());
        }
        adapter.notifyDataSetChanged();
    }

    public void them(View v) {
        if (db.getCount("SELECT * FROM tblSinhVien WHERE maSV='" + edtMaSV.getText() + "'") != 0) {
            Toast.makeText(MainActivity.this, "Ma sinh vien da ton tai", Toast.LENGTH_SHORT).show();
        } else {
            db.execute("INSERT INTO tblSinhVien VALUES('" + edtMaSV.getText() + "'," +
                    "'" + edtHoTen.getText() + "','" + edtLop.getText() + "'," +
                    "'" + edtGioiTinh.getText() + "','" + edtDiaChi.getText() + "')");
            Toast.makeText(MainActivity.this, "Them sinh vien thanh cong", Toast.LENGTH_SHORT).show();
            getSinhVien();
            edtMaSV.setText("");
            edtHoTen.setText("");
            edtLop.setText("");
            edtGioiTinh.setText("");
            edtDiaChi.setText("");
        }
    }

    public void sua(View v) {
        db.execute("UPDATE tblSinhVien SET hoTen='" + edtHoTen.getText() + "',lop='" + edtLop.getText() + "'," +
                "gioiTinh='" + edtGioiTinh.getText() + "',queQuan='" + edtDiaChi.getText() + "' WHERE maSV='" + edtMaSV.getText() + "'");
        Toast.makeText(MainActivity.this, "Cap nhat thong tin thanh cong", Toast.LENGTH_SHORT).show();
        getSinhVien();
        edtMaSV.setText("");
        edtHoTen.setText("");
        edtLop.setText("");
        edtGioiTinh.setText("");
        edtDiaChi.setText("");
    }

    public void xoa(View v) {
        db.execute("DELETE FROM tblSinhVien WHERE maSV='" + edtMaSV.getText() + "'");
        Toast.makeText(MainActivity.this, "Xoa sinh vien thanh cong", Toast.LENGTH_SHORT).show();
        getSinhVien();
        edtMaSV.setText("");
        edtHoTen.setText("");
        edtLop.setText("");
        edtGioiTinh.setText("");
        edtDiaChi.setText("");
    }
}
