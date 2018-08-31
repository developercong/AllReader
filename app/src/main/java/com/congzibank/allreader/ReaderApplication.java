package com.congzibank.allreader;

import android.app.Application;
import android.support.v7.widget.AppCompatButton;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * self application init third library
 * @author cong_wang
 * Created by cong_wang on 2018/8/31.
 *
 */

public class ReaderApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, config);
    }
}
