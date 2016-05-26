package com.parallelyk.birthdayreminder.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by YK on 2016/5/26.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mLists;
    public MainFragmentPagerAdapter(FragmentManager fm ,ArrayList<Fragment> lists) {
        super(fm);
        mLists = lists;
    }

    @Override
    public Fragment getItem(int position) {
        return mLists.get(position);
    }

    @Override
    public int getCount() {
        return mLists.size();
    }
}
