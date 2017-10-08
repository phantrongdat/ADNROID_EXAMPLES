package info.trongdat.visualization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.cleveroad.audiovisualization.AudioVisualization;
import com.cleveroad.audiovisualization.DbmHandler;
import com.cleveroad.audiovisualization.GLAudioVisualizationView;

public class MainActivity extends AppCompatActivity {
    AudioVisualization audioVisualization;
    FrameLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity_main = (FrameLayout) findViewById(R.id.activity_main);

        audioVisualization = new GLAudioVisualizationView.Builder(this)
                .setBubblesSize(R.dimen.bubble_size)
                .setBubblesRandomizeSize(true)
                .setWavesHeight(R.dimen.wave_height)
                .setWavesFooterHeight(R.dimen.footer_height)
                .setWavesCount(7)
                .setLayersCount(5)
                .setBackgroundColorRes(R.color.av_color_bg)
                .setLayerColors(R.array.av_colors)
                .setBubblesPerLayer(50)
                .build();
        audioVisualization.linkTo(DbmHandler.Factory.newVisualizerHandler(this, 0));
        activity_main.addView(
                new GLAudioVisualizationView.Builder(this)
                        .setBubblesSize(R.dimen.bubble_size)
                        .setBubblesRandomizeSize(true)
                        .setWavesHeight(R.dimen.wave_height)
                        .setWavesFooterHeight(R.dimen.footer_height)
                        .setWavesCount(7)
                        .setLayersCount(5)
                        .setBackgroundColorRes(R.color.av_color_bg)
                        .setLayerColors(R.array.av_colors)
                        .setBubblesPerLayer(50)
                        .build()
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        audioVisualization.onResume();
    }

    @Override
    public void onPause() {
        audioVisualization.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        audioVisualization.release();
        super.onDestroy();
    }
}
