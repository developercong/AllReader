package com.congzibank.allreader.booklist.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.congzibank.allreader.R;
import com.congzibank.allreader.base.ButterKnifeViewHolder;
import com.congzibank.allreader.view.textview.IconFontView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * holder the view of search
 * @author cong_wang
 * Created by cong_wang on 2018/8/31.
 */

public class BookListSearchHolder extends ButterKnifeViewHolder {

    @BindView(R.id.search_container)
    public LinearLayout mSearchContainer;

    @BindView(R.id.icon_history)
    public IconFontView mHistoryIcon;


    public BookListSearchHolder(View view) {
        super(view);
    }



    @OnClick(R.id.search_container)
    public void clickSearch(View view) {
        //使用路由
    }

    @OnClick(R.id.icon_history)
    public void clickHistory(View view) {
        //使用路由
    }
}
