package objects.blocks;

import java.awt.Color;
import java.awt.Graphics;

import objects.GameObject;

public class Stone extends GameObject{

	public Stone(int height, int width, int x, int y) {
		super(height, width, x, y);
		
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
	
	
	
}
