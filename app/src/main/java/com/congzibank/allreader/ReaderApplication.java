package com.congzibank.allreader;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.sankuai.waimai.router.Router;
import com.sankuai.waimai.router.common.DefaultRootUriHandler;
import com.sankuai.waimai.router.components.DefaultLogger;
import com.sankuai.waimai.router.components.DefaultOnCompleteListener;
import com.sankuai.waimai.router.core.Debugger;

/**
 * self application init third library
 * @author cong_wang
 * Created by cong_wang on 2018/8/31.
 *
 */

public class ReaderApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, config);

        //初始化 WMRouter
        initRouter(this);
    }

    private void initRouter(Context context) {
        // 自定义Logger
        DefaultLogger logger = new DefaultLogger() {
            @Override
            protected void handleError(Throwable t) {
                super.handleError(t);
                // 此处上报Fatal级别的异常
            }
        };

        // 设置Logger
        Debugger.setLogger(logger);

        // Log开关，建议测试环境下开启，方便排查问题。
        Debugger.setEnableLog(true);

        // 调试开关，建议测试环境下开启。调试模式下，严重问题直接抛异常，及时暴漏出来。
        Debugger.setEnableDebug(true);

        // 创建RootHandler
        DefaultRootUriHandler rootHandler = new DefaultRootUriHandler(context);

        // 设置全局跳转完成监听器，可用于跳转失败时统一弹Toast提示，做埋点统计等。
        rootHandler.setGlobalOnCompleteListener(DefaultOnCompleteListener.INSTANCE);

        // 初始化
        Router.init(rootHandler);

        // 懒加载后台初始化（可选）
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Router.lazyInit();
                return null;
            }
        }.execute();
    }
}
