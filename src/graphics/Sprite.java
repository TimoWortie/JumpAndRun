package graphics;

import java.awt.image.BufferedImage;
import graphics.Spritesheet;

/**
 * Creator of the Spritesheet.
 * 
 * @author Carina Fenn
 * @since 14.12.2018
 * @version 1.0
 */

	/**
	 * @author Carina Fenn
	 * is needed for image processing.
	 * 
	 */

public class Sprite {

	private static Spritesheet sheet;
	private BufferedImage image;
	
	
	/**
	 * Constructor for Sprite
	 * @param x the x position of the Sprite in the Spritesheet
	 * @param y	the y position of the Sprite in the Spritesheet
	 * @param width	the width of the Sprite in the Spritesheet
	 * @param height	the height of the Sprite in the Spritesheet
	 */
	public Sprite(int x, int y, int width, int height) {
		image = sheet.getSprite(x, y, width, height);
	}
	
	
	/**
	 * Gets the image to draw
	 * @return the image of the Sprite as BufferedImage
	 */
	public BufferedImage getBufferedImage() {
		return image;
	}
	
	
	/**
	 * Initializes the same Spritesheet for all Sprites
	 */
	public static void init(){
		sheet=new Spritesheet("res/Spritesheet.png",32);
	}
}
