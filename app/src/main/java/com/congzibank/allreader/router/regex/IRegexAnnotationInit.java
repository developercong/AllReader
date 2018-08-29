package com.congzibank.allreader.router.regex;

import com.congzibank.allreader.router.annotation.RouterRegex;
import com.congzibank.allreader.router.components.AnnotationInit;

/**
 * 用于加载 {@link RouterRegex} 注解配置的节点。
 * 每个配置了 {@link RouterRegex} 注解和注解生成器(annotationProcessor)的Application/Library模块，
 * 都会生成一个此接口的实现类，并在 {@link RegexAnnotationHandler} 初始化时被加载。
 *
 * Created by jzj on 2018/3/29.
 */

public interface IRegexAnnotationInit extends AnnotationInit<RegexAnnotationHandler> {

    @Override
    void init(RegexAnnotationHandler handler);
}
