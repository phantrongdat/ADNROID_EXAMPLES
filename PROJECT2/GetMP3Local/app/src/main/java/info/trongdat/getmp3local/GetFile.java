package info.trongdat.getmp3local;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

/**
 * Created by Qui96hy on 8/22/2016.
 */
public class GetFile {

    public ArrayList<Itemsong> arrayFile(Context context) {
        Uri uri;
        uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ArrayList<Itemsong> lstsong = new ArrayList<Itemsong>();
        String[] data = {MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.DURATION};
        Cursor cursor = context.getContentResolver().query(uri, data, MediaStore.Audio.Media.IS_MUSIC + "=1", null,
                MediaStore.Audio.Media.TITLE + " ASC");
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            String style, artist, data1, album;
            int duration;
            style = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            data1 = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));

            Itemsong song = new Itemsong(style, artist, data1, album, duration);
            lstsong.add(song);
        }
        return lstsong;
    }
}
