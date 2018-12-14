package graphics;

import java.awt.image.BufferedImage;

import graphics.Spritesheet;


public class Sprite {
	
	public Spritesheet sheet;
	public BufferedImage image;
	
	public Sprite(Spritesheet sheet, int x,int y, int a,int b){
		image = sheet.getSprite(x,y,a,b);
	}
	
	public BufferedImage getBufferedImage(){
		return image;
	}
}
