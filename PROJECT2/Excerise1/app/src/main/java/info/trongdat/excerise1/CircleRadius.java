package info.trongdat.excerise1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class CircleRadius extends AppCompatActivity implements View.OnTouchListener {
    ImageView imageView;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    float preX, preY, curX, curY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_radius);
        preX = preY = curX = curY = 0;
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnTouchListener(this);
        initialize();

    }

    public void initialize() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (imageView.getWidth() > 0 && imageView.getHeight() > 0)
            bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        else
            bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imageView.setImageBitmap(bitmap);

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                curX = motionEvent.getX();
                curX = motionEvent.getY();

                break;
            case MotionEvent.ACTION_UP:
//                if (preX != 0.0 && preY != 0.0) {
                canvas.drawLine(preX, preY, curX, curY, paint);
                imageView.invalidate();
//                }
                preX = curX;
                preY = curY;

                break;
        }
        return true;
    }
}
