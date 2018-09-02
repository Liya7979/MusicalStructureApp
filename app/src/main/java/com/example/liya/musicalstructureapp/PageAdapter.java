package com.example.liya.musicalstructureapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    public static final int VIEWS = 2;
    private String[] pageTitles;

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return VIEWS;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ArtistFragment.newInstance();
            case 1:
                return AlbumFragment.newInstance();
        }
        return null;
    }

    public void setPageTitles(String[] pageTitles) {
        this.pageTitles = pageTitles;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position < VIEWS) {
            return pageTitles[position];
        }
        return null;
    }
}
