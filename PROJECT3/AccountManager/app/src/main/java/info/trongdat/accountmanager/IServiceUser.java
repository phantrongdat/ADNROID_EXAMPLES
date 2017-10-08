package info.trongdat.accountmanager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Alone on 4/27/2017.
 */

public interface IServiceUser {

    @GET("api/taikhoan")
    Call<ArrayList<User>> getUsers();

    @POST("api/taikhoan")
    Call<Boolean> addUser(@Body User user);

    @PUT("api/taikhoan/{id}")
    Call<Boolean> updateUser(@Path("id") int id, @Body User user);

    @DELETE("api/taikhoan/{id}")
    Call<Boolean> deleteUser(@Path("id") int id);

    @GET("api/taikhoan/{id}")
    Call<User> getUser(@Path("id") int id);

    @GET("api/taikhoan/check")
    Call<Boolean> checkUser(@Query("username") String username, @Query("password") String password);
}
