package com.congzibank.allreader.home.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.congzibank.allreader.R;
import com.congzibank.allreader.home.base.BaseMainFragment;

import butterknife.BindView;

/**
 * 书架界面
 * @author cong_wang
 * Created by cong_wang on 2018/8/30.
 */

public class BookListFragment extends BaseMainFragment{

    @BindView(R.id.book_list_recyclerview)
    public RecyclerView mBookListRecyclerView;
    private VirtualLayoutManager layoutManager;

    @Override
    protected void setUpView(View mRootView) {
        layoutManager = new VirtualLayoutManager(mContext);
        mBookListRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_booklist;
    }

    @Override
    protected void initPresenter() {

    }
}
