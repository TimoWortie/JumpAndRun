package objects.blocks;

import java.awt.Graphics;

import graphics.Sprite;
import objects.GameObject;

/**
 * Creator of the stone.
 * 
 * @author Maximilian Ott
 * @since 02.12.2018
 * @version 1.0
 */
public class Stone extends GameObject {
	private Sprite sprite = new Sprite(15, 0, 1, 1);

	/**
	 * Needed components for the stone, that were initialized in the class
	 * GameObject.
	 */
	public Stone(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	/**
	 * draws the Block
	 * 
	 * @param g Graphics object where everything will be drawn on
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(sprite.getBufferedImage(), x, y, width, height, null);
//		renderCollision(g);
	}

}
