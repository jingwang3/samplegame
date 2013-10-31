/**
 * 
 */
package com.triplesun.jing;

import com.jing.framework.Image;
import com.jing.framework.Music;
import com.jing.framework.Sound;

/**
 * @author jwang523
 *
 */
public class Assets {
    
    public static Image menu, splash, background, character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown;
    public static Image button;
    public static Image tileSet;
    public static Sound click;
    public static Music theme;
    
    public static void load(SampleGame sampleGame) {
        // TODO Auto-generated method stub
        theme = sampleGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.0f);
        theme.play();
    }
    
}
