package com.example.alone.phantrongdat;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MultiContextMenu extends ActionBarActivity {

    Button changeBackgound, changeTextColor;
    RelativeLayout relativeLayout;
    TextView txtReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_context_menu);

        txtReview=(TextView)findViewById(R.id.txtContextMenu);
        relativeLayout=(RelativeLayout)findViewById(R.id.layRelaytive);

        changeBackgound = (Button) findViewById(R.id.btnChangeBackground);
        changeTextColor = (Button) findViewById(R.id.btnChangeTextColor);

        registerForContextMenu(changeBackgound);
        registerForContextMenu(changeTextColor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.btnChangeBackground:
                getMenuInflater().inflate(R.menu.context_change_background, menu);
                break;
            case R.id.btnChangeTextColor:
                getMenuInflater().inflate(R.menu.context_change_text_color, menu);
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
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
        }

        return super.onContextItemSelected(item);
    }
}
