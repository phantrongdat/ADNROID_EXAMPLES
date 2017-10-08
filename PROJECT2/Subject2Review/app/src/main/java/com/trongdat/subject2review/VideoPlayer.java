package com.trongdat.subject2review;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    private VideoView vidView;
    private Uri path;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Bundle bundle = getIntent().getExtras();
        path = Uri.parse(bundle.getString("path"));
        initialize();
    }

    public void initialize() {
        vidView = (VideoView) findViewById(R.id.vidView);
        vidView.setVideoURI(path);
        vidView.start();
        mediaController = new MediaController(this);
        vidView.setMediaController(mediaController);
    }
}
