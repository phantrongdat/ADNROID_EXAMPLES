package utehy.fit.vntravel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import utehy.fit.vntravel.entities.Comment;
import utehy.fit.vntravel.entities.DiaDiem;
import utehy.fit.vntravel.entities.NhaHangKhachSan;
import utehy.fit.vntravel.entities.Rate;
import utehy.fit.vntravel.entities.TaiKhoan;
import utehy.fit.vntravel.entities.Tinh;


/**
 * Created by Admin on 4/2/2017.
 */

public interface MyService {

    ////////////

//    @GET("/api/vung")
//    Call<ArrayList<Vung>> layDSVung();

    ////////////

    @GET("api/tinh")
    Call<ArrayList<Tinh>> layDSTinh(@Query("idvung") int idvung);

    @GET("api/tinh/timtinh")
    Call<ArrayList<Tinh>> timTinh(@Query("tentinh") String tenTinh);

    ////////////

    @GET("api/diadiem/chitiet")
    Call<DiaDiem> layDiaDiem(@Query("iddiadiem") int iddiadiem);

    @GET("api/diadiem/chitietdd")
    Call<DiaDiem> layCTDiaDiem(@Query("tieude") String tieude);

    @GET("api/diadiem")
    Call<ArrayList<DiaDiem>> layDSDD();

    @GET("api/diadiem")
    Call<ArrayList<DiaDiem>> layDSDiaDiem(@Query("idtinh") int idtinh);

    @GET("api/diadiem/timdiadiem")
    Call<ArrayList<DiaDiem>> timDiaDiem(@Query("tendiadiem") String tendiadiem);

    @POST("api/diadiem")
    Call<Boolean> themDiaDiem(@Body DiaDiem diaDiem);

    @PUT("api/diadiem/{0}")
    Call<Boolean> suaDiaDiem(@Path("id") int iddiadiem, @Body DiaDiem diaDiem);

    @DELETE("api/diadiem/{0}")
    Call<Boolean> xoaDiaDiem(@Path("id") int iddiadiem);

    ///////////

    @GET("api/nhahangkhachsan/chitiet")
    Call<NhaHangKhachSan> layNHKS(@Query("id") int idNHKS);

    @GET("api/nhahangkhachsan")
    Call<ArrayList<NhaHangKhachSan>> layDSNHKS(@Query("iddiadiem") int iddiadiem);

    @GET("api/nhahangkhachsan/timnhks")
    Call<ArrayList<NhaHangKhachSan>> timNHKS(@Query("tendiadiem") String tendiadiem);

    @POST("api/nhahangkhachsan")
    Call<Boolean> themNHKS(@Body NhaHangKhachSan nhaHangKhachSan);

    @PUT("api/nhahangkhachsan/{0}")
    Call<Boolean> suaNHKS(@Path("id") int idnhks, @Body NhaHangKhachSan nhaHangKhachSan);

    @DELETE("/api/nhahangkhachsan/{0}")
    Call<Boolean> xoaNHKS(@Path("id") int idnhks);

    //////////////

    @GET("api/taikhoan")
    Call<Boolean> checkUser(@Query("taikhoan") String taikhoan, @Query("matkhau") String matkhau);

    @GET("api/taikhoan")
    Call<TaiKhoan> layTTTK(@Query("id") int iduser);

    @POST("api/taikhoan")
    Call<Boolean> themTK(@Body TaiKhoan taiKhoan);

    ///////////

    @GET("api/binhluan")
    Call<ArrayList<Comment>> layDSBinhLuan(@Query("iddiadiem") int iddiadiem);

    @POST("api/binhluan")
    Call<Boolean> themBinhLuan(@Body Comment comment);

    @PUT("api/binhluan/{0}")
    Call<Boolean> suaBinhLuan(@Path("id") int id, @Body Comment comment);

    @DELETE("api/binhluan/{0}")
    Call<Boolean> xoaBinhLuan(@Path("id") int id);

    //////////////

    @GET("api/danhgia")
    Call<ArrayList<Rate>> layDSDanhGia(@Query("iddiadiem") int iddiadiem);

    @POST("api/danhgia")
    Call<Boolean> themDanhGia(@Body Rate rate);


    //////////////


}
