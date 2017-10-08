package utehy.fit.vntravel.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Admin on 4/2/2017.
 */

public class Vung implements Serializable {
    @SerializedName("IDVung")
    int idVung;
    @SerializedName("TenVung")
    String tenVung;

    public Vung() {
    }

    public Vung(int idVung, String tenVung) {
        this.idVung = idVung;
        this.tenVung = tenVung;
    }

    public int getIdVung() {
        return idVung;
    }

    public void setIdVung(int idVung) {
        this.idVung = idVung;
    }

    public String getTenVung() {
        return tenVung;
    }

    public void setTenVung(String tenVung) {
        this.tenVung = tenVung;
    }
}
