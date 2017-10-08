package net.trongdat.restart.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.trongdat.restart.R;
import net.trongdat.restart.databinding.FragmentSeBinding;

/**
 * Created by Alone on 8/10/2016.
 */
public class SE extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSeBinding seBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_se,container,false);
        View view= seBinding.getRoot();
        Toast.makeText(getActivity().getApplicationContext(),seBinding.btnLogin.getText(),Toast.LENGTH_LONG).show();

        return view;
    }
}
