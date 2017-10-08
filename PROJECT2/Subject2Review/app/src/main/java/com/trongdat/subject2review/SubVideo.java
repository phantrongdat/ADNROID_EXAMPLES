package com.trongdat.subject2review;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.trongdat.subject2review.Entities.Video;

import java.util.ArrayList;

public class SubVideo extends AppCompatActivity {
    ListView lstVideo;
    ArrayList<Video> videos;
    ArrayAdapter<Video> adapter;
    final Uri URI = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_video);
        initialize();
        loadVideo();
    }

    public void initialize() {
        lstVideo = (ListView) findViewById(R.id.lstVideo);
        videos = new ArrayList<>();
        adapter = new ArrayAdapter<Video>(this, android.R.layout.simple_list_item_1, videos);
        lstVideo.setAdapter(adapter);
        lstVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SubVideo.this, VideoPlayer.class);
                intent.putExtra("path", videos.get(i).getPath().toString());
                startActivity(intent);
            }
        });
    }

    public void loadVideo() {
        String[] data = {MediaStore.Video.Media.TITLE, MediaStore.Video.Media.DATA};
        Cursor cursor = getContentResolver().query(URI, data, null, null, null);
        while (cursor.moveToNext()) {
            Video video = new Video();
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.TITLE));
            Uri path = Uri.parse(cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA)));
            video.setTitle(title).setPath(path);
            videos.add(video);
            adapter.notifyDataSetChanged();
        }
    }
}
