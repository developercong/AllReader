package com.congzibank.allreader.booklist.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;

import java.util.List;

/**
 * @author cong_wang
 * Created by cong_wang on 2018/8/31.
 */

public class BookListDelegateAdapter extends DelegateAdapter {
    private List<BaseBookPartAdapter> bookListAdapter;

    public BookListDelegateAdapter(VirtualLayoutManager layoutManager) {
        super(layoutManager);
    }

    public BookListDelegateAdapter(VirtualLayoutManager layoutManager, boolean hasConsistItemType) {
        super(layoutManager, hasConsistItemType);
    }

}
