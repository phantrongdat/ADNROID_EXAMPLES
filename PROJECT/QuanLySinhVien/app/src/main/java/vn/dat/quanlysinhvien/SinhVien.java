package vn.dat.quanlysinhvien;

/**
 * Created by Alone on 04/27/2016.
 */
public class SinhVien {
    private int maSV, maLop;
    private String hoTen, gioiTinh, queQuan;

    public SinhVien(int maSV, String hoTen, int maLop, String gioiTinh, String queQuan) {
        this.maSV = maSV;
        this.maLop = maLop;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
    }

    public int getMaSV() {
        return maSV;
    }

    public int getMaLop() {
        return maLop;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    @Override
    public String toString() {
        return maSV + "\n" + hoTen + " - " + gioiTinh + " - " + maLop + "\n" + queQuan;
    }
}
