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
	
	private int velX;

	private int gravity = 3;
	private boolean falling = false;
	private boolean jumping = false;
	private boolean left, right;

	/**
	 * Needed components for the player, that were initialized in the class
	 * GameObject.
	 */
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		right=true;
	}

	/**
	 * draws the Player
	 * 
	 * @param g
	 *            Graphics object where everything will be drawn on
	 */

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
		renderBounds(g);
		// graphic buffered image
	}

	public void tick() {
		if (jumping) {
			y-=gravity;
			// springe nach oben key space
		}
		x+=velX;
//		if (left) {
//			x -= 5;
//		}
//		// gehe nach links mit key a
//		else if (right) {
//			x += 5;
//			// gehe nach rechts key d
//		}
		if(falling){
			y+=gravity;
		}

	}

	public void fall() {
		if (falling)
			y += gravity;
		// fall wert nach jump
	}

	/**
	 * Method for the jump and the calculation of the gravity.
	 */
	public void checkCollision(GameObject object) {
		if(getLeft().intersects(object.getRight())){
			x = object.getX() + 40;
			System.out.println("right");
			velX=0;
		}else if(getRight().intersects(object.getLeft())){
			x = object.getX() - 65;
			System.out.println("left");
			velX=0;
		}else if(getTop().intersects(object.getBottom())){
			y = object.getY() + 65;
			System.out.println("bottom");
			jumping = false;
			falling = true;
		}
		if(getBottom().intersects(object.getTop())){
			y = object.getY() - 100;
			falling=false;
			jumping=false;
		}
		
	}
	/**
	 * Method for the collision with GameObject
	 */

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setJumping(boolean jumping){
		this.jumping=jumping;
	}
	
}
