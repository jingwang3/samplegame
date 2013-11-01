/**
 * 
 */
package com.triplesun.jing;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.jing.framework.Graphics;

import android.graphics.Rect;

/**
 * @author jwang523
 * 
 */
public class TileMap {
	private static int mapWidth, mapHeight, mapPosX, mapPosY, numTiles;
	private int mapRowNum, mapColNum;
	private ArrayList<Tile> tilearray = new ArrayList<Tile>();
	private Rect r;

	public TileMap(JSONObject jObj) {

		try {
			int width = jObj.getInt("width");
			int height = jObj.getInt("height");

			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					Tile t = new Tile(i, j, jObj.getJSONArray("layers")
							.getJSONObject(0).getJSONArray("data")
							.getInt(j * width + i), jObj.getInt("tilewidth"),
							jObj.getInt("tileheight"));
					tilearray.add(t);
					mapColNum = i + 1;
					mapRowNum = j + 1;
				}
			}
			mapWidth = mapColNum * width;
			mapHeight = mapRowNum * height;
			numTiles = tilearray.size();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Tile> getTileArray() {
		return tilearray;
	}

	public int getTileArraySize() {
		return numTiles;
	}

	public int getPosX() {
		return mapPosX;
	}

	public int getPosY() {
		return mapPosY;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void update() {
		for (int i = 0; i < numTiles; i++) {
			Tile t = (Tile) tilearray.get(i);
			t.update();
		}
		mapPosX = tilearray.get(0).getTileX();
		mapPosY = tilearray.get(0).getTileY();
	}

	public void moveMap(int deltaX, int deltaY) {
		for (int i = 0; i < numTiles; i++) {
			Tile t = (Tile) tilearray.get(i);
			t.setTileX(t.getTileX() + deltaX);
			t.setTileY(t.getTileY() + deltaY);
		}
	}

	public void moveMapTo(int destX, int destY) {
		for (int i = 0; i < numTiles; i++) {
			Tile t = (Tile) tilearray.get(i);
			t.setTileX(t.getTileIdX() * t.getTileWidth() + destX);
			t.setTileY(t.getTileIdY() * t.getTileHeight() + destY);
		}
	}

	public void paintTiles(Graphics g) {
		for (int i = 0; i < numTiles; i++) {
			Tile t = (Tile) tilearray.get(i);
			if (t.getTileDisplay()) {
				g.drawImage(Assets.tileSet, t.getTileX(), t.getTileY(),
						t.getTileSrcX(), t.getTileSrcY(), t.getTileWidth(),
						t.getTileHeight());
			}
		}
		// g.drawImage(Assets.tileSet, 0, 0);
	}

}
