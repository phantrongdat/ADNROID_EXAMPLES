package com.trongdat.subject2review;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.trongdat.subject2review.Entities.Audio;

import java.io.IOException;
import java.util.ArrayList;

public class SubAudio extends AppCompatActivity {
    ListView lstAudio;
    Button btnPlay, btnPause;
    TextView txtAudio;

    ArrayList<Audio> audios;
    ArrayAdapter<Audio> adapter;
    final Uri URI = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

    MediaPlayer mediaPlayer;
    int playingIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_audio);
        initialize();
        loadAudio();
    }

    public void initialize() {
        txtAudio = (TextView) findViewById(R.id.txtAudio);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        lstAudio = (ListView) findViewById(R.id.lstAudio);
        audios = new ArrayList<>();
        adapter = new ArrayAdapter<Audio>(this, android.R.layout.simple_list_item_1, audios);
        lstAudio.setAdapter(adapter);
        lstAudio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                playingIndex = i;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                try {

                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(SubAudio.this, audios.get(i).getPath());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    txtAudio.setText(audios.get(i).getTitle());
                    btnPlay.setEnabled(false);
                    btnPause.setEnabled(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playingIndex != 0) {
                    mediaPlayer.start();
                    btnPlay.setEnabled(false);
                    btnPause.setEnabled(true);
                }
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if (playingIndex != 0) {
                                                if (mediaPlayer.isPlaying()) {
                                                    mediaPlayer.pause();
                                                    btnPause.setEnabled(false);
                                                    btnPlay.setEnabled(true);
                                                }

                                            }
                                        }
                                    }
        );
    }

    public void loadAudio() {
        String[] data = {MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DATA};
        String where = MediaStore.Audio.Media.IS_MUSIC + " =1";
        String orderBy = MediaStore.Audio.Media.TITLE + " ASC";
        Cursor cursor = getContentResolver().query(URI, data, where, null, orderBy);
        while (cursor.moveToNext()) {
            Audio audio = new Audio();
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            Uri path = Uri.parse(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)));
            audio.setTitle(title).setPath(path);
            audios.add(audio);
            adapter.notifyDataSetChanged();
        }
    }
}
