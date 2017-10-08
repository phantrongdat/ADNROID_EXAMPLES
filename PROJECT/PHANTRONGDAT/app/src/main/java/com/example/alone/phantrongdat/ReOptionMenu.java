package com.example.alone.phantrongdat;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ReOptionMenu extends Activity {
    RelativeLayout relativeLayout;
    TextView txtReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_option_menu);

        txtReview = (TextView) findViewById(R.id.txtOptionMenu);
        relativeLayout = (RelativeLayout) findViewById(R.id.layOptionMenu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itmBlue:
                relativeLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itmRed:
                relativeLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.itmYellow:
                relativeLayout.setBackgroundColor(Color.YELLOW);
                break;

            case R.id.itmTextBlue:
                txtReview.setTextColor(Color.BLUE);
                break;
            case R.id.itmTextRed:
                txtReview.setTextColor(Color.RED);
                break;
            case R.id.itmTextYellow:
                txtReview.setTextColor(Color.YELLOW);
                break;
            case R.id.itmTextWhite:
                txtReview.setTextColor(Color.WHITE);
                break;
            case R.id.itmTextGreen:
                txtReview.setTextColor(Color.GREEN);
                break;
            case R.id.itmTextGray:
                txtReview.setTextColor(Color.GRAY);
                break;
            case R.id.itmTextCyan:
                txtReview.setTextColor(Color.CYAN);
                break;
            case R.id.itmTextOrange:
                txtReview.setTextColor(Color.YELLOW);
                break;
            case R.id.itmAbout:
                AlertDialog.Builder al=new AlertDialog.Builder(this);
                al.setTitle("About");
                al.setMessage("Working with Option menu");
                al.create().show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
