package com.congzibank.allreader.booklist.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.congzibank.allreader.R;
import com.congzibank.allreader.booklist.base.BaseBookPartAdapter;
import com.congzibank.allreader.booklist.holder.BookListSearchHolder;

/**
 * delegate the book search
 * @author cong_wang
 * Created by cong_wang on 2018/8/31.
 */

public class BookListSearchAdapter extends BaseBookPartAdapter {
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(ViewGroup parent, int viewType) {
        return new BookListSearchHolder(inflater.inflate(R.layout.item_booklist_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
