package com.example.alone.audiocapture;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity {
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;

    String outPut;
    Button record,stop,play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        record=(Button)findViewById(R.id.btRecord);
        stop=(Button)findViewById(R.id.btStop);
        play=(Button)findViewById(R.id.btPlay);

        setMediaRecorder();

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaRecorder.prepare();
                    mediaRecorder.start();
                }
                catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                stop.setEnabled(true);
                play.setEnabled(false);
                record.setEnabled(false);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                mediaRecorder.release();
                stop.setEnabled(false);
                play.setEnabled(true);
                record.setEnabled(true);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Audio playing...", Toast.LENGTH_LONG).show();

                try {
                    setMediaPlayer();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                setMediaRecorder();
                record.setEnabled(true);
            }
        });
    }

    public void setMediaRecorder()
    {
        outPut= Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";
        mediaRecorder=new MediaRecorder();

        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(outPut);
        stop.setEnabled(false);
        play.setEnabled(false);
    }

    public void setMediaPlayer() throws IOException {
        mediaPlayer=new MediaPlayer();

        mediaPlayer.setDataSource(outPut);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }
}
