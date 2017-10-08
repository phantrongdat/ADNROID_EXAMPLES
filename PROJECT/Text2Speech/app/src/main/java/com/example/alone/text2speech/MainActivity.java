package com.example.alone.text2speech;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


public class MainActivity extends Activity {

    TextToSpeech textToSpeech;
    Button tts;
    EditText edtText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText=(EditText)findViewById(R.id.edtT2S);
        tts=(Button)findViewById(R.id.btT2S);

        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status!=TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(edtText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

}