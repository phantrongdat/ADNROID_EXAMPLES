package info.trongdat.practice31;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView imageView;
    SeekBar seekBar;
    Paint paint;
    Canvas canvas;
    Bitmap bitmap;
    float preX = 0, preY = preX, curX = preX, curY = preX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {
        imageView = (ImageView) findViewById(R.id.imageView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                imageView.setRotation(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        imageView.setOnTouchListener(this);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            intent.putExtra(MediaStore.MEDIA_IGNORE_FILENAME, true);
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            startActivityForResult(intent, 1);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap bitmapData = (Bitmap) extras.get("data");
                bitmap = bitmapData.copy(Bitmap.Config.ARGB_8888, true);

                canvas = new Canvas(bitmap);
                imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 500,500, true));
            }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                preX = motionEvent.getX();
                preY = motionEvent.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                curX = motionEvent.getX();
                curY = motionEvent.getY();
                canvas.drawLine(preX, preY, curX, curY, paint);
                preX = curX;
                preY = curY;
                break;
        }

        imageView.invalidate();
        return true;
    }

}
