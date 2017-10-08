package info.trongdat.mp3play;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alone on 11/12/2016.
 */

public class SongItem {
    @SerializedName("song_id_encode")
    private String songID;

    @SerializedName("title")
    private String songName;

    @SerializedName("artist")
    private String artistName;

    @SerializedName("thumbnail")
    private String image;

    @SerializedName("link")
    private String url;

    // 128 | 320 | lossless

    @SerializedName("source")
    private Source source;

    public SongItem() {
    }

    public String getSongID() {
//        String[] tmps = url.split("/");
//        songID = tmps[tmps.length - 1].replace(".html", "");
        return songID;
    }

    public SongItem setSongID(String songID) {
        this.songID = songID;
        return this;
    }

    public String getSongName() {
        return songName;
    }

    public SongItem setSongName(String songName) {
        this.songName = songName;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public SongItem setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }


    public String getImage() {
        return image;
    }

    public SongItem setImage(String image) {
        this.image = image;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SongItem setUrl(String url) {
        this.url = url;
        return this;
    }

    public Source getSource() {
        return source;
    }

    public SongItem setSource(Source source) {
        this.source = source;
        return this;
    }

    public void update(SongItem item) {
        this.songID = item.getSongID();
        this.songName = item.songName;
        this.artistName = item.artistName;
        this.image = item.getImage();
        this.url = item.getUrl();
        this.source = item.getSource();
    }

    public class Source
    {

        @SerializedName("128")
        private String s128;

        @SerializedName("320")
        private String s320;

        @SerializedName("lossless")
        private String lossless;

        public String getS128() {
            return s128;
        }

        public Source setS128(String s128) {
            this.s128 = s128;
            return  this;
        }

        public String getS320() {
            return s320;
        }

        public Source setS320(String s320) {
            this.s320 = s320;
            return  this;
        }

        public String getLossless() {
            return lossless;
        }

        public Source setLossless(String lossless) {
            this.lossless = lossless;
            return  this;
        }
    }
}
