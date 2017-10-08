package info.trongdat.camnangamthuc.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.trongdat.camnangamthuc.R;

/**
 * Created by Alone on 4/24/2017.
 */

public class DayNauAn extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sevedInstanceState) {
        View x = inflater.inflate(R.layout.fr_day_nau_an, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return x;
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FrgMonAn().newInstance("layDSMonAn",1);
                case 1:
                    return new FrgMonAn().newInstance("layDSMonAn",2);
                case 2:
                    return new FrgMonAn().newInstance("layDSMonAn",3);
            }
            return null;
        }

        public int getCount() {
            return int_items;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Miền Bắc";
                case 1:
                    return "Miền Trung";
                case 2:
                    return "Miền Nam";
            }
            return null;
        }
    }
}
