package com.trongdat.subject2review;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class SubCanvas extends AppCompatActivity {
    ImageView imgShape;
    Bitmap bitmap;
    Paint paint;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_canvas);
        initialize();
    }

    public void initialize() {
        imgShape = (ImageView) findViewById(R.id.imgShape);

        // init paint object;
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);

        // init bitmap, canvas.
        bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imgShape.setImageBitmap(bitmap);
        imgShape.invalidate();

    }

    public void clickHandler(View view) {

        canvas.drawColor(Color.WHITE);
        switch (view.getId()) {
            case R.id.btnRectangle:
                canvas.drawRect(100, 100, 300, 200, paint);
                break;
            case R.id.btnSquare:
                canvas.drawRect(100, 100, 300, 300, paint);
                break;
            case R.id.btnCircle:
                canvas.drawCircle(150, 150, 100, paint);
                break;
            case R.id.btnOval:
                canvas.drawOval(100, 100, 300, 200, paint);
                break;
            case R.id.btnTriangle:
                canvas.drawLine(100, 50, 300, 250, paint);
                canvas.drawLine(300, 250, 300, 50, paint);
                canvas.drawLine(300, 50, 100, 50, paint);
                break;
        }
        imgShape.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_color, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itmWhite:
                canvas.drawColor(Color.WHITE);
                break;
            case R.id.itmRed:
                canvas.drawColor(Color.RED);
                break;
            case R.id.itmBlue:
                canvas.drawColor(Color.BLUE);
                break;
            case R.id.itmGreen:
                canvas.drawColor(Color.GREEN);
                break;
            case R.id.itmYellow:
                canvas.drawColor(Color.YELLOW);
                break;
        }
        imgShape.invalidate();
        return super.onOptionsItemSelected(item);
    }
}
