package vn.dat.quanlysinhvien.Lop;

/**
 * Created by Alone on 05/02/2016.
 */
public class Lop {
    private String maLop, tenLop;
    private int siSo;

    public Lop(String maLop, String tenLop, int siSo) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.siSo = siSo;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public int getSiSo() {
        return siSo;
    }
}
