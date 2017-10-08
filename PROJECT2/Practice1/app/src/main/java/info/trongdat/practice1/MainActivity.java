package info.trongdat.practice1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Paint paint;
    Canvas canvas;
    ImageView imageView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        setBitmap();
    }

    public void setBitmap()
    {
        bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
//        bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        canvas = new Canvas(bitmap);
        imageView.setImageBitmap(bitmap);
    }
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btnTron:
                canvas.drawColor(Color.WHITE);
                canvas.drawCircle(200, 200, 100, paint);
                imageView.invalidate();
                break;
            case R.id.btnChuNhat:
                canvas.drawColor(Color.WHITE);
                canvas.drawRect(100,100,450,350,paint);
                imageView.invalidate();
                break;
            case R.id.btnVuong:
                canvas.drawColor(Color.WHITE);
                canvas.drawRect(100,100,350,350,paint);
                imageView.invalidate();
                break;
            case R.id.btnOval:
                canvas.drawColor(Color.WHITE);
                canvas.drawOval(100,100,450,350,paint);
                imageView.invalidate();
                break;
            case R.id.btnTamGiac:
                canvas.drawColor(Color.WHITE);
                canvas.drawLine(100,100,300,100,paint);
                canvas.drawLine(300,100,100,300,paint);
                canvas.drawLine(100,300,100,100,paint);
                imageView.invalidate();
                break;
            case R.id.btnThang:
                canvas.drawColor(Color.WHITE);
                canvas.drawLine(100,100,500,500,paint);
                imageView.invalidate();
                break;
        }
    }
}
