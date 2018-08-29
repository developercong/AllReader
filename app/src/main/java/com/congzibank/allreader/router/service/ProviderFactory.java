package com.congzibank.allreader.router.service;

import android.support.annotation.NonNull;

import com.congzibank.allreader.router.utils.ProviderPool;

public class ProviderFactory implements IFactory {

    public static final IFactory INSTANCE = new ProviderFactory();

    private ProviderFactory() {

    }

    @NonNull
    @Override
    public <T> T create(@NonNull Class<T> clazz) throws Exception {
        return ProviderPool.create(clazz);
    }
}
