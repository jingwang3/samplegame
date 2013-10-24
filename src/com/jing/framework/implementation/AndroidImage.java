/**
 * 
 */
package com.jing.framework.implementation;

import android.graphics.Bitmap;

import com.jing.framework.Graphics.ImageFormat;
import com.jing.framework.Image;

/**
 * @author jwang523
 *
 */
public class AndroidImage implements Image {
    Bitmap bitmap;
    ImageFormat format;
    
    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }      
}
