package objects.player;

import java.awt.Color;
import java.awt.Graphics;

import input.Key;
import objects.GameObject;

/**
 * Creator of the Player.
 * 
 * @author Alischa Fenn
 * @since 14.12.2018
 * @version 1.0
 */

public class Player extends GameObject {

	private int velX = 0;
	private int velY = 5;
	private boolean jumping = false;
	private boolean onGround = false;
	private boolean left, right;

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
	 * @param g
	 *            Graphics object where everything will be drawn on
	 */

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
		renderBounds(g);
		// graphic buffered image
	}

	/**
	 * Method for the jump and the calculation of the gravity.
	 */
	public void calculateMovement(Key key) {
		if (key.isRight()) {
			setVelX(5);
		} else if (key.isLeft()) {
			setVelX(-5);
		} else {
			setVelX(0);
		}
		if (key.isUp()) {
			setVelY(-20);
		}
	}

	public void tick() {
		if (!right && !left) {
			velX = 0;
		}
		if (velY < 20) {
			velY += 1;
		}
		y += velY;
		x += velX;
	}

	/**
	 * Method for the collision with GameObject
	 */
	public void checkCollision(GameObject object) {
		if (getBottom().intersects(object.getTop())) {
			y = object.getY() - (height - 1);
			onGround = true;
			jumping = false;
		} else if (getTop().intersects(object.getBottom())) {
			velY = 0;
			y = object.getY() + height;
			jumping = false;
		} else if (getLeft().intersects(object.getRight())) {
			x = object.getX() + (width - 1);
			left = false;
		} else if (getRight().intersects(object.getLeft())) {
			x = object.getX() - (width - 1);
			right = false;
		}

	}

	/**
	 * Method for the collision with GameObject
	 */
	public void setVelX(int velX) {
		if (velX < 0) {
			left = true;
			right = false;
		} else if (velX > 0) {
			left = false;
			right = true;
		}
		this.velX = velX;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public void setVelY(int gravity) {
		if (gravity < 0 && !jumping && onGround) {
			this.velY = gravity;
			onGround = false;
		}
	}

}
