package info.trongdat.mp3play;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MusicService extends Service implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {

    private static final String TAG = "MusicService";
    private static final String ACTION_SET_TRACKS = "ACTION_SET_TRACKS";
    private static final String ACTION_PLAY_TRACKS = "ACTION_PLAY_TRACKS";
    private static final String ACTION_CHANGE_STATE = "ACTION_CHANGE_STATE";
    private static final String EXTRA_SELECT_TRACK = "EXTRA_SELECT_TRACK";
    private static final String EXTRA_CHANGE_STATE = "EXTRA_CHANGE_STATE";
    private static final String ACTION_PLAY_PAUSE = "ACTION_PLAY_PAUSE";
    private static final String ACTION_NEXT = "EXTRA_NEXT";
    private static final String ACTION_PREVIUS = "EXTRA_PREVIUS";
    private static final String ACTION_START_POSITION = "ACTION_START_POSITION";
    private static final long UPDATE_INTERVAL = 1000;
    private static ArrayList<SongItem> tracks;
    private final List<SongItem> items = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    private boolean preparing;
    private static int playingIndex = -1;
    private static boolean paused;
    private Timer timer;

    public static void setTracks(@NonNull Context context, @NonNull ArrayList<SongItem> tracks) {
        Intent intent = new Intent(ACTION_SET_TRACKS, null, context, MusicService.class);
        MusicService.tracks = tracks;
        Log.e("DATTTTTTTTTTTT", "set trackssssssssssssssssssssssssssssss");
        context.startService(intent);
    }

    public static void playTrack(@NonNull Context context, @NonNull int position) {
        Intent intent = new Intent(ACTION_PLAY_TRACKS, null, context, MusicService.class);

        Log.e("DATTTTTTTTTTTT", "PLAY trackssssssssssssssssssssssssssssss");
        intent.putExtra(EXTRA_SELECT_TRACK, position);
        context.startService(intent);
    }

    public static void setState(@NonNull Context context, boolean isShowing) {
        Intent intent = new Intent(ACTION_CHANGE_STATE, null, context, MusicService.class);
        intent.putExtra(EXTRA_CHANGE_STATE, isShowing);
        context.startService(intent);
    }

    public static boolean playPause(@NonNull Context context) {
        Intent intent = new Intent(ACTION_PLAY_PAUSE, null, context, MusicService.class);
        context.startService(intent);
        return paused;
    }

    public static void nextClick(@NonNull Context context) {
        Intent intent = new Intent(ACTION_NEXT, null, context, MusicService.class);
        context.startService(intent);
    }

    public static void previousClick(@NonNull Context context) {
        Intent intent = new Intent(ACTION_PREVIUS, null, context, MusicService.class);
        context.startService(intent);
    }

    public static void seekTo(@NonNull Context context, int position) {
        Intent intent = new Intent(ACTION_START_POSITION, null, context, MusicService.class);
        intent.putExtra("position", position);
        context.startService(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            switch (intent.getAction()) {
                case ACTION_SET_TRACKS: {
                    updateTracks();
                    break;
                }
                case ACTION_PLAY_TRACKS: {
                    selectNewTrack(intent);
                    break;
                }
                case ACTION_PLAY_PAUSE: {
                    playPauseClicked();
                    break;
                }
                case ACTION_NEXT: {
                    nextClicked();
                    break;
                }
                case ACTION_PREVIUS: {
                    previousClicked();
                    break;
                }
                case ACTION_START_POSITION: {
                    seekToPosition(intent);
                    break;
                }
                case ACTION_CHANGE_STATE: {

                    break;
                }
            }
        }
        return START_STICKY;
    }

    private void selectNewTrack(Intent intent) {
        if (preparing) {
            return;
        }
//        Song item = intent.getParcelableExtra(EXTRA_SELECT_TRACK);
        int position = intent.getExtras().getInt(EXTRA_SELECT_TRACK);
        SongItem item = items.get(position);

        if (item == null && playingIndex == -1 || playingIndex != -1 && items.get(playingIndex).equals(item)) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
            Toast.makeText(getApplication().getApplicationContext(), "Null Song", Toast.LENGTH_LONG).show();
            return;
        }

        Log.e("DATTTTTTTTTTTT", "SELECT trackssssssssssssssssssssssssssssss");
//        playingIndex = items.indexOf(item);
        playingIndex = position;
        Log.e("DATTTTTTTTTTTT", items.size() + "INDEXXXXXXXXXXXXXX " + playingIndex + " K" + items.indexOf(item));
        startCurrentTrack();
    }

    private void startCurrentTrack() {
        Log.e("DATTTTTTTTTTTT", "PLAY trackssssssssssssssssssssssssssssss");

        if (mediaPlayer.isPlaying() || paused) {
            mediaPlayer.stop();
            paused = false;
        }
        mediaPlayer.reset();
        if (playingIndex < 0) {

            Log.e("DATTTTTTTTTTTT", "PLAY <0 ? trackssssssssssssssssssssssssssssss");
            return;
        }
        try {

            Log.e("DATTTTTTTTTTTT", "PLAY " + items.get(playingIndex).getSource().getS128());
            mediaPlayer.setDataSource(this, Uri.parse(items.get(playingIndex).getSource().getS128()));
            mediaPlayer.prepareAsync();
            preparing = true;

            Log.e("DATTTTTTTTTTTT", "PLAY ABC trackssssssssssssssssssssssssssssss");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateTracks() {
        SongItem playingItem = null;
        if (playingIndex != -1) {
            playingItem = tracks.get(playingIndex);
        }
        items.clear();
        if (MusicService.tracks != null) {
            items.addAll(MusicService.tracks);
            Log.e("trACK", "NOT NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
            MusicService.tracks = null;
        }
        if (playingItem == null) {
            playingIndex = -1;
        } else {
            playingIndex = this.items.indexOf(playingItem);
        }
        if (playingIndex == -1 && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.reset();
        mediaPlayer.release();
        mediaPlayer = null;
        stopTrackingPosition();
        super.onDestroy();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        preparing = false;
        mediaPlayer.start();
        stopTrackingPosition();
        startTrackingPosition();

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if (playingIndex == -1) {
            return;
        }
        playingIndex++;
        if (playingIndex >= items.size()) {
            playingIndex = 0;
            if (items.size() == 0) {
                return;
            }
        }
        startCurrentTrack();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        preparing = true;
        return false;
    }


    public void previousClicked() {
        if (items.size() == 0)
            return;
        playingIndex--;
        if (playingIndex < 0) {
            playingIndex = items.size() - 1;
        }
        startCurrentTrack();
    }

    public boolean playPauseClicked() {
        if (playingIndex == -1) {
            Toast.makeText(this, "Song not selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (mediaPlayer.isPlaying()) {
            stopTrackingPosition();
            mediaPlayer.pause();
            paused = true;
        } else {
            startTrackingPosition();
            mediaPlayer.start();
            paused = false;
        }
        return false;
    }

    public void nextClicked() {
        if (items.size() == 0)
            return;
        playingIndex++;
        if (playingIndex >= items.size()) {
            playingIndex = 0;
        }
        startCurrentTrack();
    }

    public void seekToPosition(Intent intent) {
        int position = intent.getExtras().getInt("position");
        if (playingIndex == -1) {
            Toast.makeText(this, "Song not selected", Toast.LENGTH_SHORT).show();
        }
        mediaPlayer.seekTo(position);
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void startTrackingPosition() {
        timer = new Timer(TAG);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                MediaPlayer player = mediaPlayer;
            }
        }, UPDATE_INTERVAL, UPDATE_INTERVAL);
    }

    private void stopTrackingPosition() {
        if (timer == null)
            return;
        timer.cancel();
        timer.purge();
        timer = null;
    }


}
