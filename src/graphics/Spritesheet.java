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
 * This class can either load an image file or it can load a sprite from a sprite sheet.
 * 
 */

public class Spritesheet {

	private BufferedImage sheet;

	public Spritesheet(String path) {
		try {
			sheet = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getSprite(int x, int y, int width, int height) {
		return sheet.getSubimage(x * 32 - 32, y * 32 - 32, 32 * width, 32 * height);
	}
}
