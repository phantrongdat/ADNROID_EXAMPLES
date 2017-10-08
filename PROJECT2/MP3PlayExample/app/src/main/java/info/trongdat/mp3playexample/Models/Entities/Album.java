package info.trongdat.mp3playexample.Models.Entities;

/**
 * Created by Alone on 10/14/2016.
 */

public class Album extends SongList {
    public Album(){}

    public Album(int id, String name, String description, String image) {
        super(id, name, description, image);
    }
}
