package com.csj.fxt.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MainAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> list;
    ArrayList<String> title;

    public MainAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> list,ArrayList<String> tit) {
        super(fm);
        this.list = list;
        this.title = tit;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
