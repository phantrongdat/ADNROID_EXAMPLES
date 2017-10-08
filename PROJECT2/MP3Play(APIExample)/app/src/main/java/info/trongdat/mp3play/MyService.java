package info.trongdat.mp3play;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alone on 11/12/2016.
 */

public interface MyService {

    @GET("api/mobile/song/getsonginfo?")
    Call<SongItem> getSong(@Query("requestdata") String requetData);
}
