package com.example.alone.phantrongdat;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OptinonMenuStyle extends Activity {
    TextView txtReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optinon_menu_style);
        txtReview=(TextView)findViewById(R.id.txtOption);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_change_text_color,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
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
        }
        return super.onOptionsItemSelected(item);
    }
}
