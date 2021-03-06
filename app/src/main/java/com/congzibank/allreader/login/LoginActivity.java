package com.congzibank.allreader.login;

import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.congzibank.allreader.R;
import com.congzibank.allreader.base.BaseCompatActivity;
import com.congzibank.allreader.home.MainActivity;
import com.sankuai.waimai.router.Router;

import butterknife.BindView;
import butterknife.OnClick;

/** 登陆界面
 * 界面就
 *  图标
 *  文案
 *  按钮
 *  文字
 * @author Created by cong_wang on 2018/8/28.
 */

public class LoginActivity extends BaseCompatActivity{


    @BindView(R.id.btn_login)
    public AppCompatButton mLoginButton;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick(View view) {
            // 路由进入
        Router.startUri(this, "/main");
    }

    @Override
    protected void initBeforSetView() {
        super.initBeforSetView();

    }
}
