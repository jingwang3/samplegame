/**
 * 
 */
package com.jing.framework;

import com.jing.framework.Graphics.ImageFormat;

/**
 * @author jwang523
 *
 */
public interface Image {
	public int getWidth();
	
	public int getHeight();
	
	public ImageFormat getFormat();
	
	public void dispose();
}
