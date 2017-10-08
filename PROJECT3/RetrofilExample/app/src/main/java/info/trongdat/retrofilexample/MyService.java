package info.trongdat.retrofilexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Alone on 3/21/2017.
 */

public interface MyService {
    @GET("webservice.asmx/getThongTinTaiKhoan")
    Call<List<ThongTinTaiKhoan>> getListTK();
}
