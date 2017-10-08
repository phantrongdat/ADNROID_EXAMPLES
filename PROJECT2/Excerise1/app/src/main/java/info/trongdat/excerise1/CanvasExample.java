package info.trongdat.excerise1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class CanvasExample extends AppCompatActivity implements View.OnTouchListener {
    ImageView imageView;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;

    boolean isDraw = false;

    float preX, preY, X, Y;

    int rotate = 0;
    float zoom=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_example);
        preX = preY = X = Y = 0;
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnTouchListener(this);

        initialize();

    }

    public void initialize() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        if (imageView.getWidth() > 0 && imageView.getHeight() > 0)
            bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        else
            bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCricle:
                canvas.drawColor(Color.WHITE);
                isDraw = false;
                canvas.drawCircle(200, 200, 100, paint);
                imageView.invalidate();

                break;
            case R.id.btnSquare:
                canvas.drawColor(Color.WHITE);
                isDraw = false;
                canvas.drawRect(100, 100, 300, 300, paint);
                imageView.invalidate();

                break;
            case R.id.btnRectangle:
                canvas.drawColor(Color.WHITE);
                isDraw = false;
                canvas.drawRect(100, 100, 400, 250, paint);
                imageView.invalidate();

                break;

            case R.id.btnDraw:
                canvas.drawColor(Color.WHITE);
                paint.setColor(Color.RED);
                isDraw = true;
                imageView.invalidate();
                break;

            case R.id.btnRotate:
//                canvas.drawColor(Color.WHITE);
                isDraw = false;
                rotate += 90;
                imageView.setRotation(rotate);
                imageView.invalidate();
                break;
            case R.id.btnZoomIn:
//                canvas.drawColor(Color.WHITE);
                isDraw = false;
                zoom = zoom / 2;
                if (zoom > 0.25) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setScaleX(zoom);
                    imageView.setScaleY(zoom);
                }
                imageView.invalidate();
                break;
            case R.id.btnZoomOut:
//                canvas.drawColor(Color.WHITE);
                isDraw = false;
                zoom++;
                if (zoom <3) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setScaleX(zoom);
                    imageView.setScaleY(zoom);
                }
                imageView.invalidate();
                break;

        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isDraw) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    preX = event.getX();
                    preY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    X = event.getX();
                    Y = event.getY();

                    canvas.drawLine(preX, preY, X, Y, paint);
                    imageView.invalidate();

                    preX = X;
                    preY = Y;
                    break;
            }

        }
        return true;
    }

}
