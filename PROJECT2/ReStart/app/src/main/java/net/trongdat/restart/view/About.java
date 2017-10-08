package net.trongdat.restart.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import net.trongdat.restart.R;
import net.trongdat.restart.databinding.ActivityAboutBinding;

/**
 * Created by Alone on 8/10/2016.
 */
public class About extends AppCompatActivity {
    ActivityAboutBinding  aboutBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aboutBinding= DataBindingUtil.setContentView(this, R.layout.activity_about);

        aboutBinding.txtAbout.setText("PHAN TRONG DAT");
    }
}

// ActivityAboutBinding aboutBinding=DataBindingUtil.setContentView(this,R.layout.activity_about);

