package com.congzibank.allreader.router.components;


import com.congzibank.allreader.router.core.UriHandler;

/**
 * Created by jzj on 2018/4/28.
 */

public interface AnnotationInit<T extends UriHandler> {

    void init(T handler);
}
