package com.congzibank.allreader.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.congzibank.allreader.home.base.BaseMainFragment;
import com.congzibank.allreader.utils.util;

import java.util.List;

public class MainFragmentpagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseMainFragment> fragments;
    public MainFragmentpagerAdapter(FragmentManager fm, List<BaseMainFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return util.isEmpty(fragments) ? null: fragments.get(position);
    }

    @Override
    public int getCount() {
        return util.isEmpty(fragments) ? 0 : fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
