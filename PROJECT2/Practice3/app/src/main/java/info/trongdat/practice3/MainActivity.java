package info.trongdat.practice3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    Paint paint;
    Canvas canvas;
    ImageView imageView;
    Bitmap bitmap;

    String draw = "";
    float preX = 0, preY = preX, curX = preX, curY = preX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {
        imageView = (ImageView) findViewById(R.id.imageView);
        bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
//        bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        canvas = new Canvas(bitmap);
        imageView.setImageBitmap(bitmap);
        imageView.setOnTouchListener(this);
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.btnCircle:
                draw = "circle";
                break;
            case R.id.btnLine:
                draw = "line";
                break;
            case R.id.btnPolyLine:
                draw = "polyline";
                break;
            case R.id.btnRectangle:
                draw = "rectangle";
                break;
            case R.id.btnColor:
                paint.setColor(Color.BLUE);
                break;
            case R.id.btnClear:
                canvas.drawColor(Color.WHITE);
                imageView.invalidate();
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // lệnh thực thi khi bắt đầu chạm tay
                preX = motionEvent.getX();
                preY = motionEvent.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                // Lệnh thực thi khi người dùng di chuyển ngón tay

                if (draw.equals("polyline")) {
                    curX = motionEvent.getX();
                    curY = motionEvent.getY();
                    canvas.drawLine(preX, preY, curX, curY, paint);
                    preX = curX;
                    preY = curY;
                }
                break;
            case MotionEvent.ACTION_UP:
                // Lệnh thực thi khi người dùng rời tay khỏi màn hình
                curX = motionEvent.getX();
                curY = motionEvent.getY();
                if (draw.equals("line")) {
                    canvas.drawLine(preX, preY, curX, curY, paint);
                }
                if (draw.equals("circle")) {
                    float radius = (float) Math.sqrt(Math.pow((curX - preX), 2) + Math.pow((curY - preY), 2));
                    canvas.drawCircle(preX, preY, radius, paint);
                }
                if (draw.equals("rectangle")) {
                    canvas.drawRect(preX, curY, curX, preY, paint);
                }
                break;
            default:
                break;
        }

        imageView.invalidate();
        return true;
    }
}
