package utehy.fit.vntravel.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Admin on 4/2/2017.
 */

public class NhaHangKhachSan implements Serializable {
    @SerializedName("IDNHKS")
    int idNHKS;
    @SerializedName("IDDiaDiem")
    int idDiaDiem;
    @SerializedName("Loai")
    int loai;
    @SerializedName("TenNHKS")
    String tenNHKS;
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
    @SerializedName("IDUser")
    int idUser;

    public NhaHangKhachSan() {
    }

    public NhaHangKhachSan(int idNHKS, int idDiaDiem, int loai, String tenNHKS, String tieuDe, String gioiThieu, String anh, float kinhDo, float viDo, int idUser) {
        this.idNHKS = idNHKS;
        this.idDiaDiem = idDiaDiem;
        this.loai = loai;
        this.tenNHKS = tenNHKS;
        this.tieuDe = tieuDe;
        this.gioiThieu = gioiThieu;
        this.anh = anh;
        this.kinhDo = kinhDo;
        this.viDo = viDo;
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdNHKS() {
        return idNHKS;
    }

    public void setIdNHKS(int idNHKS) {
        this.idNHKS = idNHKS;
    }

    public int getIdDiaDiem() {
        return idDiaDiem;
    }

    public void setIdDiaDiem(int idDiaDiem) {
        this.idDiaDiem = idDiaDiem;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getTenNHKS() {
        return tenNHKS;
    }

    public void setTenNHKS(String tenNHKS) {
        this.tenNHKS = tenNHKS;
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
