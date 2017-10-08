package info.trongdat.imageupload;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import static android.graphics.Bitmap.CompressFormat.PNG;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    private ImageView imageView;
    private TextView textRes;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.imgDemo);
        textRes = (TextView) findViewById(R.id.text);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent image = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // startActivityForResult(image, 8888);

                Intent pickIMG = new Intent(Intent.ACTION_PICK);
                pickIMG.setType("image/*");
                startActivityForResult(pickIMG, 6666);

            }
        });
    }

    public void upload(View v) {
        HashMap dataPost = new HashMap();
        dataPost.put("action", "upload-image");

        dataPost.put("image", getImageBase64());

        PostResponseAsyncTask asyncTask = new PostResponseAsyncTask(this, dataPost);
        asyncTask.execute("http://trongdat.info/images/upload.php");

    }


    //handling the image chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


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


    public String getImageBase64() {
         /*
         * Convert the image to a string
         * */
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream); //compress to which format you want.
        byte[] byte_arr = stream.toByteArray();
        String image_str = Base64.encodeToString(byte_arr, Base64.DEFAULT);
        Log.d("datt", "getImageBase64: " + image_str);
        return image_str;
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


    //method to get the file path from uri
    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }


    @Override
    public void processFinish(String s) {
        Log.d("datt", "processFinish: " + s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            textRes.setText("URL: "+jsonObject.getString("image_url"));
            Toast.makeText(this, "URL: " + jsonObject.getString("image_url"), Toast.LENGTH_SHORT).show();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }
}
