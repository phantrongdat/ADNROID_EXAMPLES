package com.trongdat.subject2review;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AppTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_test);
    }

    public void clickHandler(View view) {
        switch (view.getId()) {
            case R.id.btnApp1:
                startActivity(new Intent(AppTest.this, SubTest1.class));
                break;
            case R.id.btnApp2:
                startActivity(new Intent(AppTest.this, SubTest2.class));
                break;
            case R.id.btnApp3:
                startActivity(new Intent(AppTest.this, SubTest3.class));
                break;
        }
    }
}
