package com.congzibank.allreader.router.regex;

import android.support.annotation.NonNull;

import com.congzibank.allreader.router.annotation.RouterRegex;
import com.congzibank.allreader.router.components.RouterComponents;
import com.congzibank.allreader.router.components.UriTargetTools;
import com.congzibank.allreader.router.core.ChainedHandler;
import com.congzibank.allreader.router.core.Debugger;
import com.congzibank.allreader.router.core.UriCallback;
import com.congzibank.allreader.router.core.UriHandler;
import com.congzibank.allreader.router.core.UriInterceptor;
import com.congzibank.allreader.router.core.UriRequest;
import com.congzibank.allreader.router.utils.LazyInitHelper;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 正则匹配跳转，由注解 {@link RouterRegex} 配置。
 * {@link RegexAnnotationHandler} 根据优先级从大到小，逐个匹配每个 {@link RouterRegex} 注解配置的节点，
 * 优先级相同的节点不保证先后顺序。
 *
 * Created by jzj on 2018/3/19.
 */

public class RegexAnnotationHandler extends ChainedHandler {

    private final LazyInitHelper mInitHelper = new LazyInitHelper("RegexAnnotationHandler") {
        @Override
        protected void doInit() {
            initAnnotationConfig();
        }
    };

    /**
     * @see LazyInitHelper#lazyInit()
     */
    public void lazyInit() {
        mInitHelper.lazyInit();
    }

    protected void initAnnotationConfig() {
        RouterComponents.loadAnnotation(this, IRegexAnnotationInit.class);
    }

    /**
     * 注册一个子节点
     *
     * @param regex        正则表达式
     * @param target       支持ActivityClassName、ActivityClass、UriHandler
     * @param exported     是否允许外部跳转
     * @param priority     优先级
     * @param interceptors 要添加的interceptor
     */
    public void register(String regex, Object target, boolean exported, int priority,
                         UriInterceptor... interceptors) {
        Pattern pattern = compile(regex);
        if (pattern != null) {
            UriHandler innerHandler = UriTargetTools.parse(target, exported, interceptors);
            if (innerHandler != null) {
                RegexWrapperHandler handler = new RegexWrapperHandler(pattern, priority,
                        innerHandler);
                addChildHandler(handler, priority);
            }
        }
    }

    @Override
    public void handle(@NonNull UriRequest request, @NonNull UriCallback callback) {
        mInitHelper.ensureInit();
        super.handle(request, callback);
    }

    private Pattern compile(String regex) {
        if (regex != null) {
            try {
                return Pattern.compile(regex);
            } catch (PatternSyntaxException e) {
                Debugger.fatal(e);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "RegexAnnotationHandler";
    }
}
