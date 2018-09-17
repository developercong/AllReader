package com.congzibank.allreader.utils;

import java.lang.reflect.Array;

/**
 * 用数组实现栈
 * @author wangcong
 * push peek pop
 */
public class GeneralArrayStack<T> {

    public static final int DEFAULT_SIZE = 12;
    private T[] arrays;
    private int count;

    public GeneralArrayStack(Class<T> type) {
        this(type, DEFAULT_SIZE);
    }

    public GeneralArrayStack(Class<T> type, int capacity) {
        arrays = (T[]) Array.newInstance(type, capacity);
        count = 0;
    }

    public void push(T value){
        arrays[count++] = value;
    }

    public T peek(){
        if (count > 0){
            return arrays[count - 1];
        }else {
            return null;
        }
    }

    public T pop() {
        if (count == 0) return null;
        T value = arrays[count - 1];
        count--;
        return value;
    }
}
