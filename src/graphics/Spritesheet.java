package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {

	private BufferedImage sheet;
	private int height, width;

	public Spritesheet(String path) {
		try {
			sheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
		}
	}

	public BufferedImage getSprite(int x, int y, int width, int height) {
		this.height = height;
		this.width = width;
		return sheet.getSubimage(x * 32 - 32, y * 32 - 32, 32 * width, 32 * height);
	}
}
