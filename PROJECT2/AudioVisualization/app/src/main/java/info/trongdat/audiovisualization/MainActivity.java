package info.trongdat.audiovisualization;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.support.v7.app.AppCompatActivity;

import info.trongdat.audiovisualization.audiovisualization.AudioVisualization;
import info.trongdat.audiovisualization.audiovisualization.DbmHandler;
import info.trongdat.audiovisualization.audiovisualization.SpeechRecognizerDbmHandler;

public class MainActivity extends AppCompatActivity {
    AudioVisualization audioVisualization;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioVisualization = (AudioVisualization) findViewById(R.id.visualizer_view);
        SpeechRecognizerDbmHandler handler = DbmHandler.Factory.newSpeechRecognizerHandler(this);
        handler.innerRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {

            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });
        audioVisualization.linkTo(handler);
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
}
