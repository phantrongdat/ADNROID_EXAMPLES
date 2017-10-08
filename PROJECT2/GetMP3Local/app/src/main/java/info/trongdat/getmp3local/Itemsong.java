package info.trongdat.getmp3local;

/**
 * Created by Qui96hy on 8/22/2016.
 */
public class Itemsong {
    private String title;
    private String artist;
    private String data;
    private String album;
    private int duration;
    private boolean isSelect;

    public Itemsong(String title, String artist, String data, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.data = data;
        this.album = album;
        this.duration = duration;
        isSelect = false;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getData() {
        return data;
    }

    public String getAlbum() {
        return album;
    }

    public String getDuration() {
        String durationText = null;
        if (((duration/1000)%60) >= 10){
            durationText = (duration/60000) + ":" + ((duration/1000)%60);
        }
        else {
            durationText = (duration/60000) + ":0" + ((duration/1000)%60);
        }
        return durationText;
    }

    public int getDurationInt(){
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

}
