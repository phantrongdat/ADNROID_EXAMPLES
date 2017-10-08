package info.trongdat.mp3playexample.Presenters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

import info.trongdat.mp3playexample.Models.Entities.Album;
import info.trongdat.mp3playexample.Models.Entities.Artist;
import info.trongdat.mp3playexample.Models.Entities.Composer;
import info.trongdat.mp3playexample.Models.Entities.Song;
import info.trongdat.mp3playexample.Models.Entities.SongType;

/**
 * Created by Alone on 10/4/2016.
 */

public class SongPresenter {
    Context context;
    SQLiteHandler db;

    private ArrayList<Song> songs;
    private ArrayList<Album> albums;
    private ArrayList<Artist> artists;
    private ArrayList<Composer> composers;
    private ArrayList<SongType> types;
    private final Uri URI_SONG = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    private final Uri URI_ALBUM = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;

    public SongPresenter(Context context) {
        this.context = context;
        db = new SQLiteHandler(context);
        songs = new ArrayList<>();
        albums = new ArrayList<>();
        artists = new ArrayList<>();
        composers = new ArrayList<>();
        types = new ArrayList<>();
        initialize();
    }

    public void initialize() {
//        initAlbums();
//        initArtists();
//        initComposers();
//        initTypes();
    }

    public ArrayList<Song> getSongs() {
        String displayName, title, path, typeName, artistName, albumName, composerName;
        int duration, typeID, artistID, albumID, composerID;
        ArrayList<Song> songs = new ArrayList<>();
        String[] data = {MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.MIME_TYPE, MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.COMPOSER};

        Cursor cursor = context.getContentResolver().query(URI_SONG, data, MediaStore.Audio.Media.IS_MUSIC + "=1", null,
                MediaStore.Audio.Media.TITLE + " ASC");

        while (cursor.moveToNext()) {
            title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            displayName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
            path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            typeName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE));
            composerName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.COMPOSER));
            artistName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            albumName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            Song song = new Song();
            song.setSongName(title);
            song.setPath(path);
            song.setDuration(duration);
            song.setPlay(false);
            songs.add(song);
        }
        return songs;
    }
//
//    public void initSongs() {
//        String displayName, title, path, typeName, artistName, albumName, composerName;
//        int duration, typeID, artistID, albumID, composerID;
//
//        String[] data = {MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DATA,
//                MediaStore.Audio.Media.MIME_TYPE, MediaStore.Audio.Media.DURATION,
//                MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.COMPOSER};
//
//        Cursor cursor = context.getContentResolver().query(URI_SONG, data, MediaStore.Audio.Media.IS_MUSIC + "=1", null,
//                MediaStore.Audio.Media.TITLE + " ASC");
//
//        while (cursor.moveToNext()) {
//            title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
//            displayName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
//            path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
//            duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
//            typeName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE));
//            composerName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.COMPOSER));
//            artistName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
//            albumName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
//
//            displayName=displayName.replaceAll("'","");
//            path=path.replaceAll("'","");
////            artistID = artists.get(artists.lastIndexOf(artistName)).getId();
////            typeID = types.get(types.indexOf(typeName)).getTypeID();
//            db.execute("INSERT INTO Songs VALUES(null,'" + title + "',' ',null,' '," + duration + ",'" + path + "')");
//        }
//    }
//
//    public void initAlbums() {
//        String albumName, albumArt;
//        int id;
//        String[] data = {MediaStore.Audio.Albums.ALBUM,MediaStore.Audio.Albums.ALBUM_ID, MediaStore.Audio.Albums.ALBUM_ART};
//        Cursor cursor = context.getContentResolver().query(URI_ALBUM, data, null, null, MediaStore.Audio.Albums.ALBUM + " ASC");
//        while (cursor.moveToNext()) {
//            id=cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ID));
//            albumName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM));
//            albumArt = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART));
//            System.out.println(id+" "+albumName+" "+ albumArt);
//            db.execute("INSERT INTO Albums VALUES("+id+", '" + albumName + "',' ','" + albumArt + "')");
//        }
//
////        Bitmap bm= BitmapFactory.decodeFile(thisArt);
////        ImageView image=(ImageView)findViewById(R.id.image);
////        image.setImageBitmap(bm);
//    }
//
//    public void initTypes() {
//        String typeName;
//        String[] data = {MediaStore.Audio.Media.MIME_TYPE};
//        Cursor cursor = context.getContentResolver().query(URI_SONG, data,
//                MediaStore.Audio.Media.IS_MUSIC + "=1", null, MediaStore.Audio.Media.MIME_TYPE + " ASC");
//        while (cursor.moveToNext()) {
//            typeName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE));
//            System.out.println(typeName+ "type");
//            db.execute("INSERT INTO Types VALUES(null, '" + typeName + "')");
//        }
//    }
//
//    public void initComposers() {
//        String composerName;
//        int id;
//        String[] data = {MediaStore.Audio.Media.COMPOSER};
//        Cursor cursor = context.getContentResolver().query(URI_SONG, data,
//                MediaStore.Audio.Media.IS_MUSIC + "=1", null, MediaStore.Audio.Media.COMPOSER + " ASC");
//        while (cursor.moveToNext()) {
//            composerName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.COMPOSER));
//            System.out.println(composerName+" composer");
//            db.execute("INSERT INTO Composers VALUES(null, '" + composerName + "',null,null,null,null)");
//        }
//    }
//
//    public void initArtists() {
//        String artistName;
//        int id;
//        String[] data = {MediaStore.Audio.Media.ARTIST,MediaStore.Audio.Media.ARTIST_ID};
//        Cursor cursor = context.getContentResolver().query(URI_SONG, data,
//                MediaStore.Audio.Media.IS_MUSIC + "=1", null, MediaStore.Audio.Media.ARTIST + " ASC");
//        while (cursor.moveToNext()) {
//            id= cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID));
//            artistName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
//            System.out.println(id+" "+ artistName);
//            db.execute("INSERT INTO Composers VALUES(null, '" + artistName + "',null,null,null,null)");
//        }
//    }
//
//    public ArrayList<Song> getSongs() {
//        Cursor cursor = db.rawQuery("SELECT * FROM Songs");
//        while (cursor.moveToNext()) {
//            int id = cursor.getInt(0);
//            String songName = cursor.getString(1);
//            int duration = cursor.getInt(5);
//            String path = cursor.getString(6);
//
//            Song song = new Song(id, songName, " ", " ", duration, path,false);
//            songs.add(song);
//        }
//        return songs;
//    }
//
//    public ArrayList<Album> getAlbums() {
//        Cursor cursor = db.rawQuery("SELECT * FROM Albums");
//        while (cursor.moveToNext()) {
//            int id = cursor.getInt(0);
//            String albumName = cursor.getString(1);
//
//            Album album = new Album(id, albumName, "", "");
//            albums.add(album);
//        }
//        return albums;
//    }
//
//    public ArrayList<Artist> getArtists() {
//        Cursor cursor = db.rawQuery("SELECT * FROM Albums");
//        while (cursor.moveToNext()) {
//            int id = cursor.getInt(0);
//            String artistName = cursor.getString(1);
//
//            Artist artist = new Artist(id, artistName, 0, false, "", "");
//            artists.add(artist);
//        }
//        return artists;
//    }
//
//    public ArrayList<Composer> getComposers() {
//        Cursor cursor = db.rawQuery("SELECT * FROM Composers");
//        while (cursor.moveToNext()) {
//            int id = cursor.getInt(0);
//            String composerName = cursor.getString(1);
//
//            Composer composer = new Composer(id, composerName, 0, false, "", "");
//            composers.add(composer);
//        }
//        return composers;
//    }
//
//    public ArrayList<SongType> getTypes() {
//        Cursor cursor = db.rawQuery("SELECT * FROM Types");
//        while (cursor.moveToNext()) {
//            int id = cursor.getInt(0);
//            String typeName = cursor.getString(1);
//
//            SongType type = new SongType(id, typeName, "");
//            types.add(type);
//        }
//        return types;
//    }
}
