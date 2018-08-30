package com.congzibank.allreader.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.congzibank.allreader.R;
import com.congzibank.allreader.base.BaseCompatActivity;
import com.congzibank.allreader.home.adapter.MainFragmentpagerAdapter;
import com.congzibank.allreader.home.data.DataGenerator;
import com.congzibank.allreader.view.textview.IconFontView;

import butterknife.BindView;

/**
 * @author cong_wang
 * home activity show bookstore readhistoty me discuss tab
 */
public class MainActivity extends BaseCompatActivity {

    @BindView(R.id.tab_bottom)
    public TabLayout mBottomTab;

    @BindView(R.id.view_pager)
    public ViewPager mViewPager;
    private MainFragmentpagerAdapter adapter;

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
        adapter = new MainFragmentpagerAdapter(getSupportFragmentManager(), DataGenerator.initFragments());
        mViewPager.setAdapter(adapter);
    }

    private void initTabLayout() {
        TabSelectListener listener = new TabSelectListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                selectTab(tab);
            }
        };
        mBottomTab.addOnTabSelectedListener(listener);
//        mBottomTab.setupWithViewPager(mViewPager);
        //setUpVithViewPager时会删除我们的自定义view,导致tab不显示
        for (int i = 0; i < adapter.getCount(); i++) {
            mBottomTab.addTab(mBottomTab.newTab().setCustomView(DataGenerator.initTabView(this, i)));
        }
        mBottomTab.getTabAt(0).select();
    }

    private void selectTab(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
        for (int i = 0 ; i < mBottomTab.getTabCount(); i++) {
            View view = mBottomTab.getTabAt(i).getCustomView();
            if (view == null) return;
            IconFontView icon = view.findViewById(R.id.icon_tab);
            TextView title = view.findViewById(R.id.icon_title);
            if (i == tab.getPosition()) {
                //设置颜色
                icon.setTextColor(getResources().getColor(R.color.colorPrimary));
                title.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                icon.setTextColor(getResources().getColor(R.color.text_color_half_black));
                title.setTextColor(getResources().getColor(R.color.text_color_half_black));
            }
        }
    }


    public static class TabSelectListener implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }


}
