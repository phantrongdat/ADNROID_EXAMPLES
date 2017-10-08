package info.trongdat.getmp3local;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by Qui96hy on 8/25/2016.
 */
public class SongActivity implements MediaPlayer.OnCompletionListener {
    private Context context;
    private ArrayList<Itemsong>arrsongs;
    private MediaPlayer mediaPlayer;
    private int cunrentIndext=0;
   static String lstviewtitle;

    public SongActivity(Context context, ArrayList<Itemsong> arrayList){
        this.context=context;
        this.arrsongs=arrayList;
    }
    public void loadSong(Uri uri){
      resetSongs();
        mediaPlayer = MediaPlayer.create(context, uri);
        mediaPlayer.setOnCompletionListener(this);
    }

    public  void startSong(){
        if (mediaPlayer!=null){
            mediaPlayer.start();
        }
    }

    public void stopSong(){
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
    }
    public void seekMedia(int postions){
        if(mediaPlayer!=null){
            mediaPlayer.seekTo(postions);
        }
    }
    public void Pause(){
        if(mediaPlayer !=null){
            mediaPlayer.pause();
        }
    }
    public void resetSongs(){
        if(mediaPlayer !=null){
            mediaPlayer.reset();
        }
    }
    public void changeSong(int state){
        cunrentIndext+=state;
        if(cunrentIndext<0){
         cunrentIndext=arrsongs.size()-1;
        }
        if(cunrentIndext>arrsongs.size()-1){
            cunrentIndext=0;
        }
        String data=arrsongs.get(cunrentIndext).getData();
        lstviewtitle=arrsongs.get(cunrentIndext).getTitle();
        Uri uri=Uri.parse(data);
        loadSong(uri);
        startSong();
    }
    public String getTitleActivity(){
        return lstviewtitle;
    }


    public void setCurrentIndex(int currentIndex) {

        this.cunrentIndext= currentIndex;
    }
    @Override
    public void onCompletion(MediaPlayer mp) {
        for( Itemsong itemsong:arrsongs){
            itemsong.setSelect(false);
        }
        changeSong(1);
        arrsongs.get(cunrentIndext).setSelect(true);
    }
    //test
    public boolean CheckActivity(){
    if(mediaPlayer==null){
        return  false;
    }
        return mediaPlayer.isPlaying();
    }
    public int getRunTime(){
        if(mediaPlayer!=null){
            return mediaPlayer.getCurrentPosition();
        }
        return  0;
    }
    public String getDurations(){
        return arrsongs.get(cunrentIndext).getDuration();
    }
    public int getDuarationInt(){
        return  arrsongs.get(cunrentIndext).getDurationInt();
    }
    public String Title(){
        return  arrsongs.get(cunrentIndext).getTitle();
    }
}
