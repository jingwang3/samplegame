/**
 * 
 */
package com.triplesun.jing;

import android.graphics.Rect;

import com.jing.framework.Image;

/**
 * @author jwang523
 * 
 */
public class Tile {

	private int tileX, tileY, speedX;
	private int tileWidth, tileHeight;
	private int tileImgSrcX, tileImgSrcY;
	private boolean display = true;
	private int xIndexOnMap, yIndexOnMap, indexOnTileSet;
	public Image tileImage;

	private Robot robot = GameScreen.getRobot();
	private Background bg = GameScreen.getBg1();

	private Rect r;

	public Tile(int x, int y, int tId, int tWidth, int tHeight) {
		tileWidth = tWidth;
		tileHeight = tHeight;
		xIndexOnMap = x;
		yIndexOnMap = y;
		tileX = x * tileWidth;
		tileY = y * tileHeight;

		indexOnTileSet = tId;
		tileImgSrcX = (indexOnTileSet - 1) % 8 * tileWidth;
		tileImgSrcY = (indexOnTileSet - 1) / 8 * tileHeight;

		r = new Rect();

	}

	public void update() {
		speedX = bg.getSpeedX() * 5;
		tileX += speedX;
		r.set(tileX, tileY, tileX + tileWidth, tileY + tileHeight);
		if (Rect.intersects(r, Robot.yellowRed) && indexOnTileSet != 0) {
			checkVerticalCollision(Robot.rect, Robot.rect2);
			checkSideCollision(Robot.rect3, Robot.rect4, Robot.footleft,
					Robot.footright);
		}
	}

	public int getTileX() {
		return tileX;
	}

	public void setTileX(int tileX) {
		this.tileX = tileX;
	}
	
	public int getTileY() {
		return tileY;
	}

	public void setTileY(int tileY) {
		this.tileY = tileY;
	}

	public int getTileSrcX() {
		return tileImgSrcX;
	}

	public int getTileSrcY() {
		return tileImgSrcY;
	}
	public int getTileIdX(){
		return xIndexOnMap;
	}
	public int getTileIdY(){
		return yIndexOnMap;
	}
	public Image getTileImage() {
		return tileImage;
	}

	public void setTileDisplay(boolean b) {
		this.display = b;
	}

	public boolean getTileDisplay() {
		return display;
	}

	public void setTileImage(Image tileImage) {
		this.tileImage = tileImage;
	}

	public void checkVerticalCollision(Rect rtop, Rect rbot) {
		if (Rect.intersects(rtop, r)) {

		}

		if (Rect.intersects(rbot, r) && indexOnTileSet == 8) {
			robot.setJumped(false);
			robot.setSpeedY(0);
			robot.setCenterY(tileY - 63);
		}
	}

	public void checkSideCollision(Rect rleft, Rect rright, Rect leftfoot,
			Rect rightfoot) {
		if (indexOnTileSet != 5 && indexOnTileSet != 2 && indexOnTileSet != 0) {
			if (Rect.intersects(rleft, r)) {
				robot.setCenterX(tileX + 102);

				robot.setSpeedX(0);

			} else if (Rect.intersects(leftfoot, r)) {

				robot.setCenterX(tileX + 85);
				robot.setSpeedX(0);
			}

			if (Rect.intersects(rright, r)) {
				robot.setCenterX(tileX - 62);

				robot.setSpeedX(0);
			}

			else if (Rect.intersects(rightfoot, r)) {
				robot.setCenterX(tileX - 45);
				robot.setSpeedX(0);
			}
		}
	}

	public int getTileWidth() {
		// TODO Auto-generated method stub
		return tileWidth;
	}

	public int getTileHeight() {
		// TODO Auto-generated method stub
		return tileHeight;
	}

}
