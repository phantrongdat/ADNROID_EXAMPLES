//package info.trongdat.mp3playexample.Views.Tabs;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//import info.trongdat.mp3playexample.Models.Entities.Song;
//import info.trongdat.mp3playexample.Presenters.Adapters.SongAdapter;
//import info.trongdat.mp3playexample.Presenters.SongPresenter;
//import info.trongdat.mp3playexample.R;
//
//public class SongView extends Fragment implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, View.OnClickListener {
//    RecyclerView recyclerView;
//    CardView cardSong;
//    TextView txtSong;
//    ArrayList<Song> songs = new ArrayList<>();
//    LinearLayout linearLayout;
//    SongAdapter songAdapter;
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_song, container, false);
//        recyclerView = (RecyclerView) view.findViewById(R.id.recSong);
//        recyclerView.setHasFixedSize(true);
//        linearLayout = (LinearLayout) view.findViewById(R.id.fragment_song);
//
//        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        cardSong = (CardView) view.findViewById(R.id.cardSong);
//        txtSong = (TextView) view.findViewById(R.id.txtSong);
//
//        songs = new SongPresenter(getActivity().getApplication()).getSongs();
//        txtSong.setText("ALL SONG: " + songs.size());
//        songAdapter = new SongAdapter(getActivity().getApplication(), songs);
//
//        recyclerView.setAdapter(songAdapter);
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if (dy > 0) {
////                    cardSong.setVisibility(View.INVISIBLE);
//                    linearLayout.removeView(cardSong);
//                }
//            }
//        });
//        return view;
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        recyclerView.removeAllViews();
//        recyclerView.destroyDrawingCache();
//        recyclerView.clearFocus();
//        recyclerView.clearAnimation();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        recyclerView.setAdapter(songAdapter);
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        recyclerView.removeAllViews();
//        recyclerView.destroyDrawingCache();
//        recyclerView.clearFocus();
//        recyclerView.clearAnimation();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        recyclerView.removeAllViews();
//        recyclerView.destroyDrawingCache();
//        recyclerView.clearFocus();
//        recyclerView.clearAnimation();
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//
//    @Override
//    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//        return false;
//    }
//}
