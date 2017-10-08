package com.example.alone.mainslide7;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class Spinner extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        //Spinner sp=(Spinner)findViewById(R.id.spSpinner);

        ArrayList<String> list=new ArrayList<String>();
        list.add("Ga");
        list.add("Vit");
        list.add("Ca");

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //sp.setAdapter(adapter);

        //sp.setOnItemSelectedListenner(new OnItemSelectedListenner(

        // ));



    }
}
