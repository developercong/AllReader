package com.congzibank.allreader.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

/**
 * viewholder bind the libarary butterknife
 * @author cong_wang
 * Created by cong_wang on 2018/8/31.
 */

public class ButterKnifeViewHolder extends RecyclerView.ViewHolder {

    public ButterKnifeViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);

    }
}
