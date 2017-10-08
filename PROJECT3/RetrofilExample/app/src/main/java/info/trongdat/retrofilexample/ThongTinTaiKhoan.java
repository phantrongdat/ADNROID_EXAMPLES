package info.trongdat.retrofilexample;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alone on 3/21/2017.
 */

public class ThongTinTaiKhoan {

    @SerializedName(value = "TenTK")
    String tenTK;
    @SerializedName(value = "HoTen")
    String hoTen;
    @SerializedName(value = "GioiTinh")
    Boolean gioiTinh;
    @SerializedName(value = "NgaySinh")
    Date ngaySinh;
    @SerializedName(value = "DiaChi")
    String diaChi;
    @SerializedName(value = "Email")
    String email;
    @SerializedName(value = "SDT")
    String soDienThoai;

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        if (gioiTinh) return "Nam";
        return "Nữ";
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh.toString();
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return getTenTK()+" "+ getHoTen();
    }
}
