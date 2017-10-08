package utehy.fit.vntravel.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Admin on 4/6/2017.
 */

public class Comment implements Serializable {
    @SerializedName("IDUser")
    int IDUser;
    @SerializedName("IDDiaDiem")
    int IDDiaDiem;
    @SerializedName("NoiDung")
    String NoiDung;
    @SerializedName("ThoiGian")
    String ThoiGian;

    public Comment() {
    }

    public Comment(int IDUser, int IDDiaDiem, String noiDung, String thoiGian) {
        this.IDUser = IDUser;
        this.IDDiaDiem = IDDiaDiem;
        NoiDung = noiDung;
        ThoiGian = thoiGian;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public int getIDDiaDiem() {
        return IDDiaDiem;
    }

    public void setIDDiaDiem(int IDDiaDiem) {
        this.IDDiaDiem = IDDiaDiem;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }
}
