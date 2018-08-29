package com.congzibank.allreader;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.congzibank.allreader.base.BaseCompatActivity;

import butterknife.BindView;

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


    @Override
    protected int initLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpViewAfterBind() {
        initTabLayout();
    }


    private void initTabLayout() {

    }
}
