package info.trongdat.getmp3local;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Itemsong>lstfile;
   GetFile file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         file=new GetFile();
        lstfile=new ArrayList<Itemsong>();

    }
    public void Onclick1(View v){

        Intent intent=new Intent(MainActivity.this,ListSongs.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animation_right, R.anim.animation_left);
    }
}
