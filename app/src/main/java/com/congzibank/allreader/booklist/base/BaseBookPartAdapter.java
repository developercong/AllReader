package com.congzibank.allreader.booklist.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;

/**
 * booklist parent adapter
 * now is nothing to do
 * place it for future use
 * @author cong_wang
 * Created by cong_wang on 2018/8/31.
 */

public abstract class BaseBookPartAdapter extends DelegateAdapter.Adapter {

    protected static LayoutInflater inflater;
    public BaseBookPartAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return onCreateItemHolder(parent, viewType);
    }

    protected abstract RecyclerView.ViewHolder onCreateItemHolder(ViewGroup parent, int viewType);
}
