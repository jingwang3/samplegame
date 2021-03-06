/**
 * 
 */
package com.jing.framework;

/**
 * @author jwang523
 *
 */
public interface Music {
	public void play();
	
	public void stop();
	
	public void pause();
	
	public void setLooping(boolean looping);
	
	public void setVolume(float volume);
	
	public boolean isPlaying();
	
	public boolean isLooping();
	
	public boolean isStopped();
	
	public void dispose();
	
	void seekBegin();
	
}
