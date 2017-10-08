package com.trongdat.subject2review;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandler(View view) {
        switch (view.getId()) {
            case R.id.btnCanvas:
                startActivity(new Intent(MainActivity.this, SubCanvas.class));
                break;
            case R.id.btnAnimation:
                startActivity(new Intent(MainActivity.this, SubAnimation.class));
                break;
            case R.id.btnAudio:
                startActivity(new Intent(MainActivity.this, SubAudio.class));
                break;
            case R.id.btnVideo:
                startActivity(new Intent(MainActivity.this, SubVideo.class));
                break;
            case R.id.btnAppTest:
                startActivity(new Intent(MainActivity.this, AppTest.class));
                break;
        }
    }
}
