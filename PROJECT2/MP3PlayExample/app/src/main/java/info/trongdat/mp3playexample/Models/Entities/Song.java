package info.trongdat.mp3playexample.Models.Entities;

/**
 * Created by Alone on 10/4/2016.
 */

public class Song {

    private int songID;
    private String songName, lyrics, description;
    private int duration;
    private String path;
    private boolean isPlay;

    public Song() {
        super();
    }

    public Song(int songID, String songName, String lyrics, String description, int duration, String path, boolean isPlay) {
        this.songID = songID;
        this.songName = songName;
        this.lyrics = lyrics;
        this.description = description;
        this.duration = duration;
        this.path = path;
        this.isPlay = isPlay;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
