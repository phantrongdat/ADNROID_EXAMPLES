package com.example.alone.mediaplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import java.io.IOException;

public class VideoWithMP extends AppCompatActivity {


    VideoView videoView;
    private int position = 0;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_with_mp);

        videoView = (VideoView) findViewById(R.id.vidDemo);
        try {
            mediaPlayer.setDataSource(this, Uri.parse("http://trongdat.info/wildlife.mp4"));
            mediaPlayer.prepare();
            mediaPlayer.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
