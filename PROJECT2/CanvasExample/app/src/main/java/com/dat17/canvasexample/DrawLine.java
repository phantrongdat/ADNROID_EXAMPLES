package com.dat17.canvasexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Alone on 9/23/2016.
 */
public class DrawLine extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_line);
    }

}
class Dpaint extends View {

    Paint paint;
    Path path;
    float px, py;
    Canvas canvas;

    public Dpaint(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(50);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        path.moveTo(50, 50);
        path.lineTo(100, 100);
        path.lineTo(100, 150);
        path.lineTo(200, 250);

        canvas.drawTextOnPath("Hello  text", path, 0, 0, paint);

        canvas.drawPath(path, paint);
    }

    public void drawUp(float x, float y) {

    }
    private void drawMove(float x, float y) {
        canvas.drawLine(px,py,x,y,paint);
        px = x;
        py = y;
        invalidate();
    }

    public void drawDown(float x, float y)
    {
        path.reset();
        path.moveTo(x,y);
        px=x;
        py=y;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Log.e("x"+x,"y"+y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                drawUp(x,y);
                break;
            case MotionEvent.ACTION_DOWN:
                drawDown(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                drawMove(x,y);
                break;
        }
        return true;
    }
}
