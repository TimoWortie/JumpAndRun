package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Creator of the Spritesheet.
 * 
 * @author Carina Fenn
 * @since 14.12.2018
 * @version 1.0
 */

/**
 * This class can either load an image file or it can load a sprite from a
 * sprite sheet.
 * 
 */

public class Spritesheet {
	private int dimension;
	private BufferedImage sheet;

	/**
	 * Constructor for Spritesheet
	 * 
	 * @param path      the path to an image file
	 * @param dimension the size of a single Sprite in the Spritesheet
	 */
	public Spritesheet(String path, int dimension) {
		this.dimension = dimension;
		try {
			sheet = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets a Sprite from the Spritesheet
	 * 
	 * @param x      the x coordinate of the Sprite
	 * @param y      the y coordinate of the Sprite
	 * @param width  the width of the Sprite
	 * @param height the height of the Sprite
	 * @return the Subimage of the Spritesheet
	 */
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return sheet.getSubimage(x * dimension, y * dimension, dimension * width, dimension * height);
	}
}
