package info.trongdat.excerise1;

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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCanvas:
                startActivity(new Intent(MainActivity.this,CanvasExample.class));
                break;
            case R.id.btnAnimation:
                startActivity(new Intent(MainActivity.this,AnimationExample.class));
                break;
            case R.id.btnCircleRadius:
                startActivity(new Intent(MainActivity.this,CircleRadius.class));
                break;
        }
    }
}