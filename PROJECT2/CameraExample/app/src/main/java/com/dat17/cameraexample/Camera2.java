package com.dat17.cameraexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera2 extends AppCompatActivity {
    final static int CAMERA_RESULT = 0;
    ImageView imv;
    String imageFilePath;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        String date = sdf.format(new Date());

        String name = "/IMG_" + date + ".jpg";

        imageFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() +name;
        File imageFile = new File(imageFilePath);
        Uri imageFileUri = Uri.fromFile(imageFile);
        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageFileUri);
        startActivityForResult(i, CAMERA_RESULT);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
// Get a reference to the ImageView
            imv = (ImageView) findViewById(R.id.ReturnedImageView);
            Display currentDisplay = getWindowManager().getDefaultDisplay();
            int dw = currentDisplay.getWidth();
            int dh = currentDisplay.getHeight();
// Load up the image's dimensions not the image itself
            BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
            bmpFactoryOptions.inJustDecodeBounds = true;
            Bitmap bmp = BitmapFactory.decodeFile(imageFilePath, bmpFactoryOptions);
            int heightRatio = (int) Math.ceil(bmpFactoryOptions.outHeight / (float) dh);
            int widthRatio = (int) Math.ceil(bmpFactoryOptions.outWidth / (float) dw);

            Log.v("HEIGHTRATIO", "" + heightRatio);
            Log.v("WIDTHRATIO", "" + widthRatio);
// If both of the ratios are greater than 1,
// one of the sides of the image is greater than the screen
            if (heightRatio > 1 && widthRatio > 1) {
                if (heightRatio > widthRatio) {
// Height ratio is larger, scale according to it
                    bmpFactoryOptions.inSampleSize = heightRatio;
                } else {
// Width ratio is larger, scale according to it
                    bmpFactoryOptions.inSampleSize = widthRatio;
                }
            }
// Decode it for real
            bmpFactoryOptions.inJustDecodeBounds = false;
            bmp = BitmapFactory.decodeFile(imageFilePath, bmpFactoryOptions);
// Display it
            imv.setImageBitmap(bmp);
        }
    }
}
