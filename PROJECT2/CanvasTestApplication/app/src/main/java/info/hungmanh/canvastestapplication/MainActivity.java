package info.hungmanh.canvastestapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgShape;
    Bitmap bitmap;
    Paint paint;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);

        imgShape = (ImageView) findViewById(R.id.imgShape);
        if (imgShape.getWidth() > 0 && imgShape.getHeight() > 0)
            bitmap = Bitmap.createBitmap(imgShape.getWidth(), imgShape.getHeight(), Bitmap.Config.ARGB_8888);
        else
            bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imgShape.setImageBitmap(bitmap);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRecangle:
                // btn rectangle click handler here!
                canvas.drawColor(Color.WHITE);
                canvas.drawRect(20, 100, 220, 200, paint);

                imgShape.invalidate();

                break;
            case R.id.btnSquare:
                // btn square click handler here!
                canvas.drawColor(Color.WHITE);
                canvas.drawRect(100, 100, 200, 200, paint);
                imgShape.invalidate();

                break;
            case R.id.btnTriangle:
                // btn triangle click handler here!
                canvas.drawColor(Color.WHITE);
//                canvas.drawRect(20, 100, 220, 200, paint);
                canvas.drawLine(100, 100, 100, 200, paint);
                canvas.drawLine(100, 200, 200, 200, paint);
                canvas.drawLine(200, 200, 100, 100, paint);
                imgShape.invalidate();

                break;
        }
    }
}
