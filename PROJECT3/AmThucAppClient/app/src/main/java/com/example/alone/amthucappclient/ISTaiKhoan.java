package com.example.alone.amthucappclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Alone on 4/27/2017.
 */

public interface ISTaiKhoan {
    @GET("api/taikhoan")
    @FormUrlEncoded
    Call<List<TaiKhoan>> layDSTK();

    @POST("api/taikhoan")
    @FormUrlEncoded
    Call<Boolean> themTaiKhoan(@Body TaiKhoan taiKhoan);

    @PUT("api/taikhoan/{0}")
    @FormUrlEncoded
    Call<Boolean> suaTaiKhoan(@Path("id") int id, @Body TaiKhoan taiKhoan);

    @DELETE("api/taikhoan/{0}")
    @FormUrlEncoded
    Call<Boolean> suaTaiKhoan(@Path("id") int id);

}
