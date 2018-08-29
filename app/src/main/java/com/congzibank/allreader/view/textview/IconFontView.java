package com.congzibank.allreader.view.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * 用于字体图标的TextView
 */
public class IconFontView extends AppCompatTextView{
    public IconFontView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        //设置字体图标
        Typeface font = Typeface.createFromAsset(context.getAssets(), "iconfont.ttf");
        this.setTypeface(font);
    }

    public IconFontView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IconFontView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
}
