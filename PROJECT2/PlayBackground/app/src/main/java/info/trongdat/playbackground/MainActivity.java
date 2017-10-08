package info.trongdat.playbackground;

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

    public void click(View v) {
        switch (v.getId())
        {
            case R.id.btnStart:
                Intent serviceIntent = new Intent(MainActivity.this,PlayService.class);
                serviceIntent.putExtra("UserID", "123456");
                startService(serviceIntent);
                break;
            case R.id.btnStop:
                Intent service = new Intent(MainActivity.this,PlayService.class);
                stopService(service);
        }
    }
}
