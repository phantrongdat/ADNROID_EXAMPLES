package com.dat17.canvasexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Alone on 9/9/2016.
 */
public class Geometry extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CanvasView canvasView=new CanvasView(this);
        setContentView(canvasView);
    }
}

class CanvasView extends View {
    public CanvasView(Context context) {

        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Create and setup paint object.
        Paint paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);


        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(200,150,100,paint);

        canvas.drawRect(100, 300, 300, 500,paint);


        paint.setTextSize(30);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Graphics Rotation", 100, 980, paint);

        canvas.drawLine(200,600,100,750,paint);
        canvas.drawLine(200,600,300,750,paint);
        canvas.drawLine(100,750,300,750,paint);
    }


}

class Circle extends View{

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint =new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);

        canvas.drawCircle(120,120,100,paint);
    }
}

class Rectangle extends View{

    public Rectangle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint =new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);

        canvas.drawRect(20, 20, 220, 220,paint);
    }
}

class Triangle extends View{

    public Triangle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint =new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);

        canvas.drawLine(120,0,20,150,paint);
        canvas.drawLine(120,0,220,150,paint);
        canvas.drawLine(20,150,220,150,paint);
    }
}
