package info.trongdat.camnangamthuc.model;

import java.io.Serializable;

/**
 * Created by Alone on 4/24/2017.
 */

public class MonAn implements Serializable {
    int id;
    String ten, anh, chiTiet, link;

    public MonAn(int id, String ten, String anh, String chiTiet, String link) {
        this.id = id;
        this.ten = ten;
        this.anh = anh;
        this.chiTiet = chiTiet;
        this.link = link;
    }

    public MonAn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
