package com.congzibank.allreader.booklist;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.congzibank.allreader.R;
import com.congzibank.allreader.booklist.adapter.BookListSearchAdapter;
import com.congzibank.allreader.booklist.base.BaseBookPartAdapter;
import com.congzibank.allreader.booklist.base.BookListDelegateAdapter;
import com.congzibank.allreader.home.base.BaseMainFragment;

import java.util.ArrayList;
import java.util.List;

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
    private BookListDelegateAdapter delegateAdapter;

    @Override
    protected void setUpView(View mRootView) {
        //初始化recyclerview
        layoutManager = new VirtualLayoutManager(mContext);
        mBookListRecyclerView.setLayoutManager(layoutManager);
        delegateAdapter = new BookListDelegateAdapter(layoutManager);
        initAdapters();
        delegateAdapter.setAdapters(bookListAdapter);
        mBookListRecyclerView.setAdapter(delegateAdapter);
    }

    private List<DelegateAdapter.Adapter> bookListAdapter;
    private void initAdapters() {
        bookListAdapter = new ArrayList<>();
        bookListAdapter.add(new BookListSearchAdapter());
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_booklist;
    }


    @Override
    protected void initPresenter() {

    }
}
