package com.trongdat.subject2review;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trongdat.subject2review.Entities.ContentSubject;

import java.util.ArrayList;

public class SubTest1View extends AppCompatActivity {
    ArrayList<ContentSubject> contents;
    DatabaseHandler db;
    int id, position = 0;
    String name;

    TextView txtContent, txtName;
    ImageView imgSubject;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_test1_view);
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        name = bundle.getString("name");
        initialize();
        loadContents();
        getContent(position);
    }

    public void initialize() {
        txtContent = (TextView) findViewById(R.id.txtContent);
        txtName = (TextView) findViewById(R.id.txtSubjectName);
        imgSubject = (ImageView) findViewById(R.id.imgSubject);

        txtName.setText(name);
    }

    public void clickHandler(View view) {
        switch (view.getId()) {
            case R.id.btnSpeak:
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
                break;
            case R.id.btnNext:
                position++;
                getContent(position);
                break;
            case R.id.btnPrevious:
                position--;
                getContent(position);
                break;
            case R.id.btnHome:
                startActivity(new Intent(SubTest1View.this, SubTest1.class));
                break;
        }
    }

    public void getContent(int index) {
        if (index == contents.size() - 1) index = position = 0;
        if (index == -1) index = position = contents.size() - 1;
        ContentSubject content = contents.get(index);
        txtContent.setText(content.getContent());

        int imgID = getResources().getIdentifier(content.getImage(), "drawable", getPackageName());
        imgSubject.setImageResource(imgID);

        Uri speakURI = Uri.parse("android:resource://" + getPackageName() + "/raw/" + content.getSpeak());
        mediaPlayer = MediaPlayer.create(this, speakURI);

    }

    public void loadContents() {
        Cursor cursor = db.rawQuery("SELECT * FROM tblNoiDung where idBaiHoc=" + id);
        while (cursor.moveToNext()) {
            ContentSubject content = new ContentSubject();
            content.setId(cursor.getInt(1))
                    .setContent(cursor.getString(2))
                    .setImage(cursor.getString(3))
                    .setSpeak(cursor.getString(4));
            contents.add(content);
        }
    }
}
