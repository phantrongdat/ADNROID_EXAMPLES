package info.trongdat.retrofilexample;

/**
 * Created by Alone on 3/21/2017.
 */

public class TaiKhoan {
String tenTK,matKhau;

    public TaiKhoan(String tenTK, String matKhau) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;

    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}

