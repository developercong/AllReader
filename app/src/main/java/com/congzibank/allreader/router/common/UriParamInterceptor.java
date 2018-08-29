package com.congzibank.allreader.router.common;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.congzibank.allreader.router.core.UriCallback;
import com.congzibank.allreader.router.core.UriInterceptor;
import com.congzibank.allreader.router.core.UriRequest;
import com.congzibank.allreader.router.utils.RouterUtils;

import java.util.Map;

/**
 * 给uri添加参数。{@link UriRequest} 可设置 {@link UriParamInterceptor#FIELD_URI_APPEND_PARAMS}, 会被自动添加到uri中。
 * Created by jzj on 2018/1/29.
 */
public class UriParamInterceptor implements UriInterceptor {

    /**
     * {@link UriRequest} 的额外参数，Map&lt;String, String&gt;类型，跳转WebView附加额外参数
     */
    public static final String FIELD_URI_APPEND_PARAMS =
            "com.congzibank.allreader.router.UriParamInterceptor.uri_append_params";

    @Override
    public void intercept(@NonNull UriRequest request, @NonNull UriCallback callback) {
        appendParams(request);
        callback.onNext();
    }

    @SuppressWarnings("unchecked")
    protected void appendParams(@NonNull UriRequest request) {
        final Map<String, String> extra = request.getField(
                Map.class, UriParamInterceptor.FIELD_URI_APPEND_PARAMS);
        if (extra != null) {
            Uri uri = RouterUtils.appendParams(request.getUri(), extra);
            request.setUri(uri);
        }
    }
}
