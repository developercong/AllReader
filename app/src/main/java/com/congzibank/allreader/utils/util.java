package com.congzibank.allreader.utils;

import java.util.Collection;

/**
 * Common Utils
 */
public class util {

    public static<T> boolean isEmpty(T... datas) {
        return datas == null || datas.length == 0;
    }

    public static<T> boolean isEmpty(Collection<T> datas) {
        return datas == null || datas.size() == 0;
    }
}
