package graphics;

import java.awt.image.BufferedImage;

import graphics.Spritesheet;

public class Sprite {

	public Spritesheet sheet;
	public BufferedImage image;

	public Sprite(Spritesheet sheet, int x, int y, int width, int height) {
		image = sheet.getSprite(x, y, width, height);
	}

	public BufferedImage getBufferedImage() {
		return image;
	}
}
