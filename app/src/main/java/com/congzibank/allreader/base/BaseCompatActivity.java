package com.congzibank.allreader.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import com.congzibank.allreader.R;
import com.congzibank.allreader.view.textview.IconFontView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 用于实现mvp层级的基础界面
 * @author cong_wang
 */
public class BaseCompatActivity extends HandleIntentActivity{

    @Nullable
    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @Nullable
    @BindView(R.id.tv_toolbar_title)
    public TextView mToolbarTitle;

    @Nullable
    @BindView(R.id.icon_toolbar_right)
    public IconFontView mToolbarRightIcon;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBeforSetView();

        setUpContentView();
        //绑定View
        ButterKnife.bind(this);

        setUpViewAfterBind();

        setUpDate();
    }

    /**
     * 初始化intent的处理
     * @param intent
     */
    @Override
    public void realHandleIntent(Intent intent) {

    }


    /**
     * 在界面加载中设置的数据
     */
    protected void setUpDate() {
    }

    /**
     * 初始化布局的一些方法
     * 在绑定了butterknife之后使用
     */
    protected void setUpViewAfterBind() {
    }

    /**
     * 在设置界面之前的初始化方法
     */
    protected void initBeforSetView() {
    }

    /**
     * 初始化界面，如果子界面不返回则直接退出
     */
    private void setUpContentView() {
        if (initLayoutRes() > 0 ){
            setContentView(initLayoutRes());
        } else {
            finish();
        }
    }
    protected int initLayoutRes() {
        return 0;
    }
}
