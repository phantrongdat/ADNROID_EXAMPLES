package info.trongdat.mp3playexample.Presenters.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.*;

import java.util.ArrayList;

import info.trongdat.mp3playexample.Models.Entities.Song;
import info.trongdat.mp3playexample.R;

/**
 * Created by Alone on 10/4/2016.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Song> mDataSet;

    public SongAdapter(Context context, ArrayList<Song> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item_1, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Picasso.with(mContext).load(R.drawable.ic_music).into(holder.imgCurrent);
        holder.txtTitle.setText(mDataSet.get(position).getSongName());
        holder.txtSinger.setText("");
//        holder.txtDuration.setText(mDataSet.get(position).getDuration());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void remove(int position) {
        mDataSet.remove(position);
        notifyItemRemoved(position);
    }

    public void add(Song song, int position) {
        mDataSet.add(position, song);
        notifyItemInserted(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView imgCurrent;
        public TextView txtTitle;
        public TextView txtSinger;
        public TextView txtDuration;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            imgCurrent = (ImageView) itemView.findViewById(R.id.imgCurrent);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTile);
            txtSinger = (TextView) itemView.findViewById(R.id.txtSinger);
            txtDuration = (TextView) itemView.findViewById(R.id.txtDuration);
        }
    }
//
//    extends ArrayAdapter<Song> {
//    private ArrayList<Song> songs;
//    private LayoutInflater inflater;
//
//    public SongAdapter(Context context, int resource, ArrayList<Song> data) {
//        super(context, resource, data);
//        songs = data;
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.song_item_1, parent, false);
//            TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTile);
//            TextView txtSinger = (TextView) convertView.findViewById(R.id.txtSinger);
//            TextView txtDuration = (TextView) convertView.findViewById(R.id.txtDuration);
//
//            txtTitle.setEnabled(true);
//            ViewHoder viewHoder = new ViewHoder();
//            viewHoder.txtTitle = txtTitle;
//            viewHoder.txtArtist = txtSinger;
//            viewHoder.txtDuration = txtDuration;
//
//            convertView.setTag(viewHoder);
//            viewHoder.txtTitle.setText(songs.get(position).getTitle());
//            viewHoder.txtArtist.setText(songs.get(position).getArtist());
//            viewHoder.txtDuration.setText(songs.get(position).getDuration());
//        }
//
//        return convertView;
//    }
}
