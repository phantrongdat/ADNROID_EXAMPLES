package info.trongdat.mp3play;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView txtSong;
    RecyclerView lstSong;
    SeekBar seekBar;
    FloatingActionButton fabPlay;
    ImageView imgNext, imgPrevious, imgRepeat, imgShuffle;

    SongAdapter songAdapter;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setupAction();

    }

    public void initialize() {
        mediaPlayer = new MediaPlayer();

        txtSong = (TextView) findViewById(R.id.txtSong);
        lstSong = (RecyclerView) findViewById(R.id.lstSong);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lstSong.setLayoutManager(linearLayoutManager);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        fabPlay = (FloatingActionButton) findViewById(R.id.fabPlay);
        imgNext = (ImageView) findViewById(R.id.next);
        imgPrevious = (ImageView) findViewById(R.id.previous);
        imgRepeat = (ImageView) findViewById(R.id.repeat);
        imgShuffle = (ImageView) findViewById(R.id.shuffle);

    }

    public void setupAction() {

        // Load danh sách bài hát và hiển thị lên RecycleView (Advance ListView).
        final LoadSong loadSong = new LoadSong(new SongLoadListener() {
            @Override
            public void SongLoadListener(ArrayList<SongItem> list) {
                songAdapter = new SongAdapter(MainActivity.this, list);
                lstSong.setAdapter(songAdapter);
            }
        });
        loadSong.execute("http://mp3.zing.vn/bang-xep-hang/bai-hat-Viet-Nam/IWZ9Z08I.html");

        // Xử lý sự kiện click các điều khiển.
        fabPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!MusicService.playPause(MainActivity.this))
                    fabPlay.setImageResource(R.drawable.ic_play_vector);
                else
                    fabPlay.setImageResource(R.drawable.ic_pause_vector);
            }
        });
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicService.nextClick(MainActivity.this);
            }
        });

        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicService.previousClick(MainActivity.this);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    // Lớp thực thi load danh sách bài hát -> return list bài hát.
    private class LoadSong extends AsyncTask<String, SongItem, ArrayList<SongItem>> {
        SongLoadListener songLoadListener;

        MyService myService;

        // Phương thức khởi tạo.
        public LoadSong(SongLoadListener songLoadListener) {
            this.songLoadListener = songLoadListener;

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.mp3.zing.vn/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myService = retrofit.create(MyService.class);

        }

        // Phương thức xử lý trong quá trình thực thi.
        @Override
        protected ArrayList<SongItem> doInBackground(String... params) {
            final ArrayList<SongItem> list = new ArrayList<>();
            try {
                // Dùng JSoup và kết nối tới link danh sách bài hát để lấy về mã của các bài hát.
                Connection con = Jsoup.connect(params[0])
                        .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                        .timeout(10000);
                Connection.Response resp = con.execute();

                Document doc = null;
                if (resp.statusCode() == 200) {
                    doc = con.get();

                    Elements els = doc.getElementsByClass("e-item");

                    for (Element el : els) {

                        final SongItem song = new SongItem();
                        Elements s = el.getElementsByClass("title-item");
                        String url = "";
                        for (Element m : s) {
                            // Lấy địa chỉ của bài hát.
                            url = m.select("a").attr("href");
                        }

                        // Tách lấy mã bài hát từ địa chỉ của bài hát.
                        String[] tmps = url.split("/");
                        String songID = tmps[tmps.length - 1].replace(".html", "");


                        // Get các thông tin của bài hát tương ứng với mã bài hát (qua API Zing cung cấp ).
                        final String id = "{\"id\":\"" + songID + "\"}";
                        myService.getSong(id).enqueue(new Callback<SongItem>() {

                            @Override
                            public void onResponse(Call<SongItem> call, Response<SongItem> response) {

                                song.update(response.body());
                                Log.e("DAT", response.body().getSongName() + "\n" + response.body().getSource().getS128()
                                        + "\n" + response.body().getSource().getS320()
                                        + "\n" + response.body().getSource().getLossless()
                                        + "\n" + call.request().url());
                            }

                            @Override
                            public void onFailure(Call<SongItem> call, Throwable t) {
//                                Log.e("DAT", t.getMessage());
                            }
                        });

                        // Thêm bài hát vừa lấy được vào danh sách.
                        list.add(song);
                    }
                }
                return list;

            } catch (IOException e) {
                // return danh sách sau khi hoàn thành.
                return list;
            }

        }

        // Phương thức xử lý sau khi quá trình xử lý hoàn thành ( kết thúc).
        @Override
        protected void onPostExecute(ArrayList<SongItem> result) {
            songLoadListener.SongLoadListener(result);
        }
    }
}
