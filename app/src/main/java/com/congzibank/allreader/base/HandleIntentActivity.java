package com.congzibank.allreader.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class HandleIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    /**
     * 处理传递过来的intent
     * @param intent
     */
    private void handleIntent(Intent intent) {
        if (intent == null) return;
        realHandleIntent(intent);
    }

    public abstract void realHandleIntent(Intent intent);
}
