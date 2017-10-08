package utehy.fit.vntravel.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Admin on 4/2/2017.
 */

public class Tinh implements Serializable {
    @SerializedName("IDTinh")
    int idTinh;
    @SerializedName("IDVung")
    int idVung;
    @SerializedName("TenTinh")
    String tenTinh;

    public Tinh() {
    }

    public Tinh(int idTinh, int idVung, String tenTinh) {
        this.idTinh = idTinh;
        this.idVung = idVung;
        this.tenTinh = tenTinh;
    }

    public int getIdVung() {
        return idVung;
    }

    public void setIdVung(int idVung) {
        this.idVung = idVung;
    }

    public int getIdTinh() {
        return idTinh;
    }

    public void setIdTinh(int idTinh) {
        this.idTinh = idTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }
}
