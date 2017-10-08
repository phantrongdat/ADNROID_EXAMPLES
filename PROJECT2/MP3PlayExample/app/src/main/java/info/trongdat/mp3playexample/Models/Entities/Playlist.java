package info.trongdat.mp3playexample.Models.Entities;

/**
 * Created by Alone on 10/14/2016.
 */

public class Playlist extends SongList {
    public Playlist() {
        super();
    }

    public Playlist(int id, String name, String description, String image) {
        super(id, name, description, image);
    }
}

