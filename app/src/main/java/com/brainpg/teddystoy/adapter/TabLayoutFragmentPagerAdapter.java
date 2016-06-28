package com.brainpg.teddystoy.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.brainpg.teddystoy.fragment.FirstBlankFragment;
import com.brainpg.teddystoy.fragment.SecondListFragment;

public class TabLayoutFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String tabTitles[] = new String[]{
            "First\ntab"
            , "Second\ntab"
            , "3"
            , "4"
            , "5"
            , "6"
            , "Second"
            , "Second"
            , "Second"
            , "Second"
            , "Second"
            , "Second"
            , "Second"
    };

    public TabLayoutFragmentPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }

    @Override public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return FirstBlankFragment.newInstance("param1", "param2");
            case 1:
                return SecondListFragment.newInstance("param1", "param2");
            default:
                return SecondListFragment.newInstance("param1", "param2");

        }
    }

    @Override public int getCount() {
        return tabTitles.length;
    }

    @Override public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
