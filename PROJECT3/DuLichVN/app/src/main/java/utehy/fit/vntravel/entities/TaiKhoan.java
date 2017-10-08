package utehy.fit.vntravel.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Admin on 4/6/2017.
 */

public class TaiKhoan implements Serializable {
    @SerializedName("IDUser")
    int IDUser;
    @SerializedName("SoDienThoai")
    String TaiKhoan;
    @SerializedName("MatKhau")
    String MatKhau;
    @SerializedName("HoTen")
    String HoTen;
    @SerializedName("DiaChi")
    String DiaChi;
    @SerializedName("SoDienThoai")
    String SoDienThoai;
    @SerializedName("Email")
    String Email;

    public TaiKhoan(){}
    public TaiKhoan(int IDUser, String taiKhoan, String matKhau, String hoTen, String diaChi, String soDienThoai, String email) {
        this.IDUser = IDUser;
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
        HoTen = hoTen;
        DiaChi = diaChi;
        SoDienThoai = soDienThoai;
        Email = email;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
