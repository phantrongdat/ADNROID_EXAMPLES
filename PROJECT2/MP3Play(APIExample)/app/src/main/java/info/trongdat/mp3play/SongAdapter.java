package info.trongdat.mp3play;

import android.app.ActivityManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private ArrayList<SongItem> mList = new ArrayList<>();
    private static String ma = "gsjtg7m1MMM";
    private LayoutInflater mInflater;
    private Context mContext;
    View view;

    public SongAdapter(Context context, ArrayList<SongItem> list) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = mInflater.inflate(R.layout.song_item_1, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final SongItem current = mList.get(position);

        // gán các thông tin của bài hát lên mỗi item trong danh sách.
        holder.txtTitle.setText(current.getSongName());
        Picasso.with(mContext).load("http://image.mp3.zdn.vn/thumb/240_240/" + current.getImage()).into(holder.imaAlbum);

//        Picasso.with(mContext).load(current.getImage()).into(holder.imaAlbum);
        holder.txtArtist.setText(current.getArtistName());
        switch (position) {
            case 1:
                holder.txtTop.setText("TOP 1");
                break;
            case 2:
                holder.txtTop.setText("TOP 2");
                break;
            case 3:
                holder.txtTop.setText("TOP 3");
                break;
        }

        // Xử lý sự kiện khi chọn bài hát từ danh sách ( item click).
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isServiceRunning(MusicService.class)) {
                    // Thiết lập( khởi tạo) danh sách bài hát nếu chưa chạy service.
                    MusicService.setTracks(mContext, mList);
                }
                // Phát bài hát trong danh sách.
                MusicService.playTrack(mContext, position);
            }
        });
    }


    // Phương thức kiểm tra xem service có đang tồn tại không.
    private boolean isServiceRunning(@NonNull Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }

        return false;
    }

    public SongItem getItem(int position) {
        return mList.get(position);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imaAlbum;
        TextView txtTitle;
        TextView txtArtist;
        TextView txtTop;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imaAlbum = (ImageView) itemView.findViewById(R.id.imgAlbum);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtArtist = (TextView) itemView.findViewById(R.id.txtArtist);
            txtTop = (TextView) itemView.findViewById(R.id.txtDuration);
//                                                        R.id.txtTop
        }
    }

}

