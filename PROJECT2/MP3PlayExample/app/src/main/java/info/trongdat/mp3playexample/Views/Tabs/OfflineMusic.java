//package info.trongdat.mp3playexample.Views.Tabs;
//
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.view.ViewPager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.gigamole.navigationtabbar.ntb.NavigationTabBar;
//
//import java.util.ArrayList;
//
//import info.trongdat.mp3playexample.Presenters.Adapters.ViewPagerAdapter;
//import info.trongdat.mp3playexample.R;
//
//
///**
// * Created by Alone on 9/29/2016.
// */
//
//public class OfflineMusic extends Fragment {
//
//    private NavigationTabBar navigationTabBar;
//    private ViewPager viewPager;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view =inflater.inflate(R.layout.offline_music_main,container,false);
//
//        viewPager = (ViewPager) view.findViewById(R.id.vp_vertical_ntb);
//        navigationTabBar = (NavigationTabBar) view.findViewById(R.id.ntb_vertical);
//        setup();
//        return view;
//    }
//
//    public void setup()
//    {
//
//        setupViewPager(viewPager);
//        final String[] colors = getResources().getStringArray(R.array.vertical_ntb);
//
//        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_song),
//                        Color.parseColor(colors[0]))
//                        .badgeTitle("Songs")
//                        .title("Songs")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_album2),
//                        Color.parseColor(colors[1]))
//                        .badgeTitle("Albums")
//                        .title("Albums")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_playlist2),
//                        Color.parseColor(colors[2]))
//                        .badgeTitle("Artists")
//                        .title("Artists")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_playlist3),
//                        Color.parseColor(colors[3]))
//                        .badgeTitle("Playlists")
//                        .title("Playlists")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_favorite),
//                        Color.parseColor(colors[4]))
//                        .badgeTitle("Favorite")
//                        .title("Favorite")
//                        .build()
//        );
//        models.add(
//                new NavigationTabBar.Model.Builder(
//                        getResources().getDrawable(R.drawable.ic_download),
//                        Color.parseColor(colors[5]))
//                        .badgeTitle("Download")
//                        .title("Download")
//                        .build()
//        );
//
//        navigationTabBar.setModels(models);
//        navigationTabBar.setViewPager(viewPager, 0);
//    }
//
//
//    public void setupViewPager(ViewPager viewPager)
//    {
//        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getFragmentManager());
//        pagerAdapter.addFragment(new SongView(),"Songs");
//        pagerAdapter.addFragment(new AlbumView(),"Albums");
//        pagerAdapter.addFragment(new ArtistView(),"Artists");
//        pagerAdapter.addFragment(new PlaylistView(),"Playlist");
//        pagerAdapter.addFragment(new FavoriteView(), "Favorite");
//        pagerAdapter.addFragment(new DownloadView(),"Download");
//        viewPager.setAdapter(pagerAdapter);
////        viewPager.setPageTransformer(true, new AccordionTransformer());
//    }
//
//}
