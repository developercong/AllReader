package com.congzibank.allreader.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.congzibank.allreader.R;
import com.congzibank.allreader.base.BaseCompatActivity;
import com.congzibank.allreader.home.adapter.MainFragmentpagerAdapter;
import com.congzibank.allreader.home.base.BaseMainFragment;
import com.congzibank.allreader.view.textview.IconFontView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * home activity show bookstore readhistoty me discuss tab
 */
public class MainActivity extends BaseCompatActivity {

    @BindView(R.id.tab_bottom)
    public TabLayout mBottomTab;

    @BindView(R.id.view_pager)
    public ViewPager mViewPager;

    @BindView(R.id.search_container)
    public LinearLayout mSearchContainer;

    private static final String[] mBottomTitles = new String[]{"发现", "书架", "讨论", "我"};
    private static final int[] mBottomIcon = new int[]{R.string.icon_browse, R.string.icon_shujia, R.string.icon_message, R.string.icon_wode};

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpViewAfterBind() {
        initViewPager();
        initTabLayout();
    }

    private void initViewPager() {
        mViewPager.setAdapter(new MainFragmentpagerAdapter(getSupportFragmentManager(), initFragments()));
    }

    private void initTabLayout() {
        for (int i = 0; i < 4; i++) {
            mBottomTab.addTab(initTabItem(i));
        }
        mBottomTab.setupWithViewPager(mViewPager);
    }

    private List<BaseMainFragment> initFragments() {
        List<BaseMainFragment> fragments = new ArrayList<>();
        //TODO 添加不同类型的fragment
        fragments.add(null);
        fragments.add(null);
        fragments.add(null);
        fragments.add(null);
        return fragments;
    }

    @BindView(R.id.icon_tab)
    public IconFontView fontView;
    @BindView(R.id.icon_title)
    public TextView fontTitle;

    private TabLayout.Tab initTabItem(int i) {
        TabLayout.Tab tab = mBottomTab.newTab();
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab_bootm, null);
        ButterKnife.bind(this, view);
        tab.setCustomView(view);
        fontTitle.setText(mBottomTitles[i]);
        fontView.setText(getResources().getText(mBottomIcon[i]));
        return tab;
    }
}
