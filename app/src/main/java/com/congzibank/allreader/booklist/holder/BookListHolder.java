package com.congzibank.allreader.booklist.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.congzibank.allreader.R;
import com.congzibank.allreader.base.ButterKnifeViewHolder;

import butterknife.BindView;

/**
 * Created by cong_wang on 2018/8/31.
 */

public class BookListHolder extends ButterKnifeViewHolder {

    @BindView(R.id.image_book)
    public ImageView mBookImage;

    @BindView(R.id.tv_book_name)
    public TextView mBookName;

    public BookListHolder(View view) {
        super(view);
    }

    public void bindBookInfo() {
       
    }
}
