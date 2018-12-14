package objects.player;

import java.awt.Color;
import java.awt.Graphics;
import objects.GameObject;

/**
 * Creator of the Player.
 * 
 * @author Alischa Fenn
 * @since 14.12.2018
 * @version 1.0
 */

public class Player extends GameObject {
	/**
	 * Needed components for the player, that were initialized in the class
	 * GameObject.
	 */
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * draws the Player
	 * 
	 * @param g Graphics object where everything will be drawn on
	 */

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
		// graphic buffered image
	}
}
