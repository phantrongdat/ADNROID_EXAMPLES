package utehy.fit.vntravel.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Admin on 4/2/2017.
 */

public class DiaDiem implements Serializable {
    @SerializedName("IDDiaDiem")
    int idDiaDiem;
    @SerializedName("IDDTinh")
    int idTinh;
    @SerializedName("TenDiaDiem")
    String tenDiaDiem;
    @SerializedName("TieuDe")
    String tieuDe;
    @SerializedName("GioiThieu")
    String gioiThieu;
    @SerializedName("Anh")
    String anh;
    @SerializedName("KinhDo")
    float kinhDo;
    @SerializedName("ViDo")
    float viDo;
    @SerializedName("Loai")
    int loai;

    public DiaDiem() {
    }

    public DiaDiem(int idDiaDiem, int idTinh, String tenDiaDiem, String tieuDe, String gioiThieu, String anh, float kinhDo, float viDo) {
        this.idDiaDiem = idDiaDiem;
        this.idTinh = idTinh;
        this.tenDiaDiem = tenDiaDiem;
        this.tieuDe = tieuDe;
        this.gioiThieu = gioiThieu;
        this.anh = anh;
        this.kinhDo = kinhDo;
        this.viDo = viDo;
    }

    public int getIdTinh() {
        return idTinh;
    }

    public void setIdTinh(int idTinh) {
        this.idTinh = idTinh;
    }

    public int getIdDiaDiem() {
        return idDiaDiem;
    }

    public void setIdDiaDiem(int idDiaDiem) {
        this.idDiaDiem = idDiaDiem;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public float getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(float kinhDo) {
        this.kinhDo = kinhDo;
    }

    public float getViDo() {
        return viDo;
    }

    public void setViDo(float viDo) {
        this.viDo = viDo;
    }
}
