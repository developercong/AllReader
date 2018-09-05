package com.congzibank.allreader.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by cong_wang on 2018/9/3.
 */

public class BlurFrameLayout extends FrameLayout {
    public BlurFrameLayout(@NonNull Context context) {
        super(context);
        init();
    }



    public BlurFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BlurFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BlurFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private Paint paint;
    private void init() {
        paint = new Paint();
        paint.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.INNER));
        this.setLayerType(1, paint);
        this.setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(getLeft(),getTop(), getRight(), getBottom(), paint);
    }
}
