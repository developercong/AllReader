package com.congzibank.allreader.login;

import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

import com.congzibank.allreader.R;
import com.congzibank.allreader.base.BaseCompatActivity;

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
    private AppCompatButton mLoginButton;

    @Override
    protected int initLayoutRes() {
        return R.layout.activity_login;
    }


    @OnClick(R.id.btn_login)
    public void onLoginClick(View view) {
        //使用路由进行跳转
    }


}
