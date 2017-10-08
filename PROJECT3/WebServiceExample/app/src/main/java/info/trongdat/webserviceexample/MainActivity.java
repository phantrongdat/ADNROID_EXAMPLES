package info.trongdat.webserviceexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtTenTK;
    TextView txtHoTen, txtGioiTinh, txtNgaySinh, txtDiaChi, txtEmail, txtSoDT;
    Button btnLayTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTenTK = (EditText) findViewById(R.id.edtTenTK);
        txtHoTen = (TextView) findViewById(R.id.txtHoTen);
        txtGioiTinh = (TextView) findViewById(R.id.txtGioiTinh);
        txtNgaySinh = (TextView) findViewById(R.id.txtNgaySinh);
        txtDiaChi = (TextView) findViewById(R.id.txtDiaChi);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtSoDT = (TextView) findViewById(R.id.txtSoDT);
        btnLayTT = (Button) findViewById(R.id.btnLayTT);
        btnLayTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layThongTin();
            }
        });
    }

    public void layThongTin() {
        MyAsyncTask layTTTK = new MyAsyncTask(new TaiKhoanListener() {
            @Override
            public void TaiKhoanListener(ThongTinTaiKhoan tttk) {
                txtHoTen.setText(tttk.getHoTen());
                txtGioiTinh.setText(tttk.getGioiTinh());
                txtNgaySinh.setText(tttk.getNgaySinh());
                txtDiaChi.setText(tttk.getDiaChi());
                txtEmail.setText(tttk.getEmail());
                txtSoDT.setText(tttk.getSoDienThoai());
            }
        }, edtTenTK.getText().toString());
        // thực hiện lấy thông tin tài khoản với tenTK đưuọc nhập từ edittext.
        layTTTK.execute();
    }
}
