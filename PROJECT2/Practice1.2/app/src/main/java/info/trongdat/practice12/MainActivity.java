package info.trongdat.practice12;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    SeekBar seekBar;
    Bitmap bitmap;
    Canvas canvas;
    float seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seek = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.btnChoose:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
                break;
            case R.id.btnSave:
                saveImage();
                break;
            case R.id.btnRotate:
                imageView.setRotation(seek);
                break;
            case R.id.btnZoom:
                imageView.setScaleX(seek);
                imageView.setScaleY(seek);
                break;
            case R.id.btnContract:

                break;

        }
    }

    public void saveImage() {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        File file = new File(Environment.getExternalStorageDirectory().toString() + "/image_bitmap.jpg");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            Toast.makeText(this,file.toString(),Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            Uri uri = data.getData();
            String[] datas = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(uri, datas, null, null, null);
            cursor.moveToFirst();
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            Toast.makeText(this,path,Toast.LENGTH_SHORT).show();
            File file = new File(path);
            try {
                InputStream inputStream = new FileInputStream(file);
                Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap1);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
