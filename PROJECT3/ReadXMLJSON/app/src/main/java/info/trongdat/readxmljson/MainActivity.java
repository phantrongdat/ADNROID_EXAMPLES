package info.trongdat.readxmljson;

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

    public void xmlClick(View view)
    {
        startActivity(new Intent(MainActivity.this,XMLActivity.class));
    }
    public void jsonClick(View view)
    {
        startActivity(new Intent(MainActivity.this,JSONActivity.class));
    }
}
