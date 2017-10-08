package info.trongdat.camnangamthuc.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import info.trongdat.camnangamthuc.R;
import info.trongdat.camnangamthuc.adapter.MonAnAdapter;
import info.trongdat.camnangamthuc.adapter.MonAnLoadListener;
import info.trongdat.camnangamthuc.adapter.MyAsyncTask;
import info.trongdat.camnangamthuc.model.MonAn;

/**
 * Created by Alone on 4/24/2017.
 */

public class FrgMonAn extends Fragment {

    ListView listView;
    View v;
    Activity activity;
    String method;
    int idTheLoai;

    public static final FrgMonAn newInstance(String method, int idTheLoai) {
        FrgMonAn f = new FrgMonAn();
        Bundle localBundle = new Bundle();
        localBundle.putString("method", method);
        localBundle.putInt("idTheLoai", idTheLoai);
        f.setArguments(localBundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        method = getArguments().getString("method");
        idTheLoai = getArguments().getInt("idTheLoai");
        activity = getActivity();
        v = inflater.inflate(R.layout.fr_mon_an, container, false);
        listView = (ListView) v.findViewById(R.id.lstMonAn);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        new MyAsyncTask(new MonAnLoadListener() {
            @Override
            public void monAnLoadListener(ArrayList<MonAn> list) {
                MonAnAdapter myAdap = new MonAnAdapter(getActivity(), R.layout.custom_item_mon_an, list);
                listView.setAdapter(myAdap);
            }
        }, method, idTheLoai).execute();

        return v;
    }

}
