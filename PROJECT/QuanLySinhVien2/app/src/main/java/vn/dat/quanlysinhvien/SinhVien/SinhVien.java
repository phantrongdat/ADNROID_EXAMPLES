package vn.dat.quanlysinhvien.SinhVien;

/**
 * Created by Alone on 05/02/2016.
 */
public class SinhVien {
    private String maLop, maSV, hoTen, ngaySinh, gioiTinh, queQuan, danToc, tonGiao;

    public SinhVien(String maLop, String maSV, String hoTen, String ngaySinh, String gioiTinh, String queQuan, String danToc, String tonGiao) {
        this.maLop = maLop;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.danToc = danToc;
        this.tonGiao = tonGiao;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public String getTonGiao() {
        return tonGiao;
    }
}
