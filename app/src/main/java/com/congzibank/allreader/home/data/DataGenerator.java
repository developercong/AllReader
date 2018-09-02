package com.congzibank.allreader.home.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.congzibank.allreader.R;
import com.congzibank.allreader.base.HandleIntentActivity;
import com.congzibank.allreader.home.base.BaseMainFragment;
import com.congzibank.allreader.booklist.BookListFragment;
import com.congzibank.allreader.home.fragment.CommunityFragment;
import com.congzibank.allreader.home.fragment.DiscoryFragment;
import com.congzibank.allreader.home.fragment.ProfileFragment;
import com.congzibank.allreader.view.textview.IconFontView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cong_wang
 * Created by cong_wang on 2018/8/30.
 */

public class DataGenerator {



    public static final String[] mBottomTitles = new String[]{"发现", "书架", "讨论", "我"};
    public static final int[] mBottomIcon = new int[]{R.string.icon_browse, R.string.icon_shujia, R.string.icon_message, R.string.icon_wode};


    /***
     * private constructor method
     */
    private DataGenerator() {
    }

    public DataGenerator instance() {
        return DataGeneratorHolder.instance;
    }
    private static class DataGeneratorHolder {
        public static DataGenerator instance = new DataGenerator();
    }
    private TabChangeListener listener;


    public static final TabItem[] mDefaultTabs = new TabItem[]{
            new TabItem("发现", R.string.icon_browse),
            new TabItem("-", R.string.icon_shujia),
            new TabItem("讨论", R.string.icon_message),
            new TabItem( "我", R.string.icon_wode)
    };

    /**
     * 这里传入的参数应该是一个数组结构，或者list结构
     */

    public void onBookSelected(List<SelectBook> books) {
        if(books == null || books.size() == 0) {
            listener.onTabChange();
            // oncallback empty selected
        } else {
            //callback selected book
        }
    }



    public static List<BaseMainFragment> initFragments() {
        List<BaseMainFragment> fragments = new ArrayList<>();
        fragments.add(new DiscoryFragment());
        fragments.add(new BookListFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new ProfileFragment());
        return fragments;
    }
    public static View initTabView(Context context, int position, HandleIntentActivity.TabStatus status) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tab_bootm, null);
        ((TextView)view.findViewById(R.id.icon_title)).setText(mBottomTitles[position]);
        ((IconFontView)view.findViewById(R.id.icon_tab)).setText(mBottomIcon[position]);
        return view;
    }

    public TabChangeListener getListener() {
        return listener;
    }

    public void setListener(TabChangeListener listener) {
        this.listener = listener;
    }
    /**
     *  observer change listener
     */
    public interface TabChangeListener {
        void onTabChange(TabItem[] items);
    }
}
