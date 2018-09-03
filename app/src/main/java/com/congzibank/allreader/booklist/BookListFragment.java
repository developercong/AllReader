package com.congzibank.allreader.booklist;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.blankj.utilcode.util.ConvertUtils;
import com.congzibank.allreader.R;
import com.congzibank.allreader.booklist.adapter.BookListAdapter;
import com.congzibank.allreader.booklist.adapter.BookListSearchAdapter;
import com.congzibank.allreader.booklist.base.BaseBookPartAdapter;
import com.congzibank.allreader.booklist.base.BookListDelegateAdapter;
import com.congzibank.allreader.home.MainActivity;
import com.congzibank.allreader.home.base.BaseMainFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 书架界面
 *
 * @author cong_wang
 * Created by cong_wang on 2018/8/30.
 */

public class BookListFragment extends BaseMainFragment {

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
        delegateAdapter.setAdapters(initAdapters());
        mBookListRecyclerView.setAdapter(delegateAdapter);
        mBookListRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING){
                    mToolbar.setElevation(ConvertUtils.dp2px(5));
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish自己的界面
            }
        });

        mToolbarRightIcon.setText(R.string.edit);
    }

    @OnClick(R.id.icon_toolbar_right)
    public void onEditClick(View view) {
        changeToolBar(view.isSelected());
        changeRecyclerView(view.isSelected());
        changeTabLayout(view.isSelected());
    }

    //3 修改了tabLayout
    private void changeTabLayout(boolean selected) {
        //现在可以使用强引用，后期改为事件通知---rxbus
        if (mContext instanceof MainActivity) {
            ((MainActivity) mContext).changeTabLayout(selected);
        }

    }

    //2 修改recyclerView
    private void changeRecyclerView(boolean selected) {
        //修改某一个状态值，然后进行绘制
    }

    //1 修改toolbar
    private void changeToolBar(boolean selected) {
        mToolbarTitle.setText(selected ? R.string.select_book : R.string.book_list);
    }

    private List<DelegateAdapter.Adapter> initAdapters() {
        List<DelegateAdapter.Adapter> bookListAdapter = new ArrayList<>();
        bookListAdapter.add(new BookListSearchAdapter());
        bookListAdapter.add(new BookListAdapter());
        return bookListAdapter;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_booklist;
    }

    @Override
    protected void initPresenter() {

    }
}
