package com.congzibank.allreader.view.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Type;

/**
 * gauss blur util
 * @author wangcong
 */
public class RenderScriptGaussBlur {

    private RenderScript renderScript;

    public RenderScriptGaussBlur(Context context) {
        renderScript = RenderScript.create(context);
    }

    /**
     * main blur utils
     * @param originalBitmap
     * @param radius
     * @return
     */
    public Bitmap blur(Bitmap originalBitmap, float radius) {
        Bitmap bmp = Bitmap.createBitmap(originalBitmap);
        // allocation the memory
        final Allocation input = Allocation.createFromBitmap(renderScript, bmp);
        Type type = input.getType(); // type contains elements and dimensis
        final Allocation output = Allocation.createTyped(renderScript, type);
        //create blur object to do the transform
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        script.setRadius(radius);
        script.setInput(input); //set thr original memory
        script.forEach(output); //foreach to store the output memory
        output.copyTo(bmp);// copy the memory to bitmap and we get the result bitmap than

        //free memory
        input.destroy();
        output.destroy();
        script.destroy();
        type.destroy();
        return bmp;

    }

}

