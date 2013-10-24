/**
 * 
 */
package com.jing.framework.implementation;

import java.util.List;

import android.view.View.OnTouchListener;

import com.jing.framework.Input.TouchEvent;

/**
 * @author jwang523
 *
 */
public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);
    
    public int getTouchX(int pointer);
    
    public int getTouchY(int pointer);
    
    public List<TouchEvent> getTouchEvents();
}
