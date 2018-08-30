package com.congzibank.allreader.home.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * fragment in MainActivity
 * @author cong_wang
 */
public abstract class BaseMainFragment extends Fragment{

    protected Context mContext;

    protected View mRootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        initPresenter();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(attachLayoutRes(), null);
            ButterKnife.bind(this, mRootView);
            setUpView(mRootView);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }


    /**
     * subfragment implements this method to init view
     * @param mRootView
     */
    protected abstract void setUpView(View mRootView);


    /**
     * sub fragment inplements this method to provide self view
     * @return
     */
    protected abstract int attachLayoutRes();


    /**
     *sub fragment implements this method to provide data and logical
     */
    protected abstract void initPresenter();

}
