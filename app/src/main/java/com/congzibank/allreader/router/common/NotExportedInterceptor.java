package com.congzibank.allreader.router.common;

import android.support.annotation.NonNull;

import com.congzibank.allreader.router.components.UriSourceTools;
import com.congzibank.allreader.router.core.UriCallback;
import com.congzibank.allreader.router.core.UriInterceptor;
import com.congzibank.allreader.router.core.UriRequest;
import com.congzibank.allreader.router.core.UriResult;

/**
 * 节点的exported为false，不允许来自外部的跳转，拦截并返回 {@link UriResult#CODE_FORBIDDEN}
 *
 * Created by jzj on 2018/3/26.
 */

public class NotExportedInterceptor implements UriInterceptor {

    public static final NotExportedInterceptor INSTANCE = new NotExportedInterceptor();

    private NotExportedInterceptor() {
    }

    @Override
    public void intercept(@NonNull UriRequest request, @NonNull UriCallback callback) {
        if (UriSourceTools.shouldHandle(request, false)) {
            callback.onNext();
        } else {
            callback.onComplete(UriResult.CODE_FORBIDDEN);
        }
    }
}
