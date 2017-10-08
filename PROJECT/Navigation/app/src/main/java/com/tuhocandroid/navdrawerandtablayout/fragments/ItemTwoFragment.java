package com.tuhocandroid.navdrawerandtablayout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuhocandroid.navdrawerandtablayout.R;

/**
 * Created by minhpq on 3/29/16.
 */
public class ItemTwoFragment extends Fragment {

    public ItemTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_two, container, false);
    }

}

