//package info.trongdat.mp3playexample.Views.Tabs;
//
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//import info.trongdat.mp3playexample.R;
//
///**
// * Created by Alone on 9/29/2016.
// */
//
//public class OnlineMusic extends Fragment {
//    LinearLayout linearLayout;
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view =inflater.inflate(R.layout.online_music_main,container,false);
//        linearLayout=(LinearLayout)view.findViewById(R.id.layput_online);
//        linearLayout.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY<0)
//                {
//                    Toast.makeText(getContext(),"Scroll up",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//        return view;
//
//    }
//}
