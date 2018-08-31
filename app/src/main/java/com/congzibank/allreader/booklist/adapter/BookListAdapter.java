package com.congzibank.allreader.booklist.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.blankj.utilcode.util.ConvertUtils;
import com.congzibank.allreader.R;
import com.congzibank.allreader.booklist.base.BaseBookPartAdapter;
import com.congzibank.allreader.booklist.holder.BookListHolder;

/**
 * main booklist adapter
 * @author cong_wang
 * Created by cong_wang on 2018/8/31.
 */

public class BookListAdapter extends BaseBookPartAdapter {

    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(ViewGroup parent, int viewType) {
        return new BookListHolder(inflater.inflate(R.layout.item_book_list, parent, false));
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        GridLayoutHelper helper = new GridLayoutHelper(3);
        helper.setWeights(new float[]{33.3f, 33.3f, 33.3f});
        helper.setPaddingLeft(ConvertUtils.dp2px(20));
        helper.setPaddingRight(ConvertUtils.dp2px(20));
        helper.setPaddingTop(ConvertUtils.dp2px(10));
        return helper;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BookListHolder) {
            ((BookListHolder)holder).bindBookInfo();
        }
    }

    @Override
    public int getItemCount() {
        return 40;
    }
}
