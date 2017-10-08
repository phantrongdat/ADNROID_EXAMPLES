package info.trongdat.materialaniamationsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class PlayPause extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_pause2);

        final PlayPauseView view = (PlayPauseView) findViewById(R.id.play_pause_view);
        view.set
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.toggle();
                if (view.isPlay()) Toast.makeText(getApplicationContext(),"Play",Toast.LENGTH_SHORT).show();
                else  Toast.makeText(getApplicationContext(),"Pause",Toast.LENGTH_LONG).show();
            }
        });
    }
}
