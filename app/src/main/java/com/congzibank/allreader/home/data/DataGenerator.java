package com.congzibank.allreader.home.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.congzibank.allreader.R;
import com.congzibank.allreader.home.base.BaseMainFragment;
import com.congzibank.allreader.booklist.BookListFragment;
import com.congzibank.allreader.home.fragment.CommunityFragment;
import com.congzibank.allreader.home.fragment.DiscoryFragment;
import com.congzibank.allreader.home.fragment.ProfileFragment;
import com.congzibank.allreader.view.textview.IconFontView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong_wang on 2018/8/30.
 */

public class DataGenerator {

    public static final String[] mBottomTitles = new String[]{"发现", "书架", "讨论", "我"};
    public static final int[] mBottomIcon = new int[]{R.string.icon_browse, R.string.icon_shujia, R.string.icon_message, R.string.icon_wode};

    public static List<BaseMainFragment> initFragments() {
        List<BaseMainFragment> fragments = new ArrayList<>();
        fragments.add(new DiscoryFragment());
        fragments.add(new BookListFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new ProfileFragment());
        return fragments;
    }
    public static View initTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tab_bootm, null);
        ((TextView)view.findViewById(R.id.icon_title)).setText(mBottomTitles[position]);
        ((IconFontView)view.findViewById(R.id.icon_tab)).setText(mBottomIcon[position]);
        return view;
    }
}
