package info.trongdat.mp3playexample.Models.Entities;

/**
 * Created by Alone on 10/14/2016.
 */

public class Artist extends Person {
    public Artist() {
        super();
    }

    public Artist(int id, String name, int birthYear, boolean sex, String country, String avatar) {
        super(id, name, birthYear, sex, country, avatar);
    }
}
