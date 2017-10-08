package info.trongdat.uploadimagetoserver;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.emitter.Emitter;

import static android.graphics.Bitmap.CompressFormat.PNG;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView2;
    io.socket.client.Socket socket;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imgDemo);
        imageView2 = (ImageView) findViewById(R.id.imgRes);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent image = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // startActivityForResult(image, 8888);

//                Intent pickIMG = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(pickIMG, 9999);


                Intent pickIMG = new Intent(Intent.ACTION_PICK);
                pickIMG.setType("image/*");
                startActivityForResult(pickIMG, 6666);

            }
        });

        try {
            socket = IO.socket("http://ptdcloud.com/");
            socket.connect();
            socket.on("resuploadimage", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    imageHandler(args[0]);
                }
            });


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void imageHandler(Object obj) {
        Log.d("dattt", "imageHandler: " + obj);
        byte[] bytes = (byte[]) obj;
        final Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//        JSONObject object = (JSONObject) obj;
        //            final String imageName = object.getString("imageName");
//            Log.d("datt", "imageHandler: " + imageName);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imageView2.setImageBitmap(bitmap);
//                    Toast.makeText(getApplicationContext(), "" + imageName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void upload(View view) {
        if (bitmap != null)
            socket.emit("requploadimage", getArrayBitmap(bitmap));
    }

    public byte[] convertToArray(ImageView imgv) {
        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public byte[] getArrayBitmap(Bitmap bm) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm.compress(PNG, 100, stream);
        return stream.toByteArray();
    }

    private static Bitmap resize(Bitmap image, int maxWidth, int maxHeight) {
        if (maxHeight > 0 && maxWidth > 0) {
            int width = image.getWidth();
            int height = image.getHeight();
            float ratioBitmap = (float) width / (float) height;
            float ratioMax = (float) maxWidth / (float) maxHeight;

            int finalWidth = maxWidth;
            int finalHeight = maxHeight;
            if (ratioMax > 1) {
                finalWidth = (int) ((float) maxHeight * ratioBitmap);
            } else {
                finalHeight = (int) ((float) maxWidth / ratioBitmap);
            }
            image = Bitmap.createScaledBitmap(image, finalWidth, finalHeight, true);
            return image;
        } else {
            return image;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 8888 && resultCode == RESULT_OK) {
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == 6666 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            InputStream is = null;
            try {
                is = getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            bitmap = BitmapFactory.decodeStream(is);
            bitmap = resize(bitmap, 500, 500);
            imageView.setImageBitmap(bitmap);

        }

    }

}
