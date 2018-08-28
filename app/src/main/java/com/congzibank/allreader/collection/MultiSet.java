package com.congzibank.allreader.collection;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.LinkedHashMap;
import java.util.Map;

/** 可以存放多个相同值的set集合，
 * Created by cong_wang on 2018/8/28.
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public final class MultiSet<T>{
    private final Map<T, Integer> map = new LinkedHashMap<>();

    void add(T t) {
        int count = map.getOrDefault(t, 0);
        map.put(t, count + 1);
    }

    void remove(T t) {
        int count = map.getOrDefault(t, 0);
        if (count == 0) {
            throw new IllegalStateException(t + " is not in the multiset");
        }
        map.put(t, count - 1);

    }

    boolean contains(T t) {
        return map.getOrDefault(t, 0) > 0;
    }

}
