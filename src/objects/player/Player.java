package objects.player;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Sprite;
import input.Key;
import objects.GameObject;
import sun.java2d.pipe.RenderBuffer;

/**
 * Creator of the Player.
 * 
 * @author Alischa Fenn
 * @since 14.12.2018
 * @version 1.0
 */

public class Player extends GameObject {
	private int walkingSpeed = 5;
	private int jumpSpeed = -20;
	private int velX = 0;
	private int velY = 5;
	private boolean jumping = false;
	private boolean onGround = false;
	private boolean left, right;
	private int lastDirection = 0;
	private Sprite[] walkingSprites = new Sprite[10];
	private Sprite standingLeftSprite, standingRightSprite, jumpingRightSprite, jumpingLeftSprite, fallingRightSprite,
			fallingLeftSprite;
	private int timer = 0;

	/**
	 * Needed components for the player, that were initialized in the class
	 * GameObject.
	 */
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		for (int i = 0; i < walkingSprites.length; i++) {
			walkingSprites[i] = new Sprite(i, 0, 1, 1);
		}
		standingRightSprite = new Sprite(0, 0, 1, 1);
		standingLeftSprite = new Sprite(5, 0, 1, 1);
		jumpingRightSprite = new Sprite(11, 0, 1, 1);
		jumpingLeftSprite = new Sprite(12, 0, 1, 1);
		fallingRightSprite = new Sprite(13, 0, 1, 1);
		fallingLeftSprite = new Sprite(14, 0, 1, 1);
	}

	/**
	 * Draws either the left or right sprite depending on the direction the player
	 * facing
	 * 
	 * @param right the Sprite to draw when the player looks right
	 * @param left  the Sprite to draw when the player looks left
	 * @param g     where to draw the Sprite on
	 */
	public void renderSprite(Sprite right, Sprite left, Graphics g) {
		if (velX > 0) {
			g.drawImage(right.getBufferedImage(), x, y, width, height, null);
		} else {
			if (lastDirection != 1) {
				g.drawImage(left.getBufferedImage(), x, y, width, height, null);
			} else {
				g.drawImage(right.getBufferedImage(), x, y, width, height, null);
			}
		}
	}

	/**
	 * draws the Player
	 * 
	 * @param g Graphics object where everything will be drawn on
	 */
	@Override
	public void render(Graphics g) {
		int spriteIndex = (int) Math.floor(timer / 6);
		if (velY < 0) {
			renderSprite(jumpingRightSprite, jumpingLeftSprite, g);
		} else if (velY > 0 && !onGround) {
			renderSprite(fallingRightSprite, fallingLeftSprite, g);
		} else if (velX > 0) {
			g.drawImage(walkingSprites[spriteIndex].getBufferedImage(), x, y, width, height, null);
			lastDirection = 1;
		} else if (velX < 0) {
			g.drawImage(walkingSprites[spriteIndex + 5].getBufferedImage(), x, y, width, height, null);
			lastDirection = -1;
		} else {
			if (lastDirection == 1) {
				g.drawImage(standingRightSprite.getBufferedImage(), x, y, width, height, null);
			} else {
				g.drawImage(standingLeftSprite.getBufferedImage(), x, y, width, height, null);
			}
		}
//		renderCollision(g);
	}

	/**
	 * Method for the jump and the calculation of the gravity.
	 * 
	 * @param key the KeyListener responsible for the movement of the player
	 */
	public void calculateMovement(Key key) {
		if (key.isRight()) {
			setVelX(walkingSpeed);
		} else if (key.isLeft()) {
			setVelX(-walkingSpeed);
		} else {
			setVelX(0);
		}
		if (key.isUp()) {
			setVelY(jumpSpeed);
		}
	}

	/**
	 * changes x and y position depending on movement in vertical and horizontal
	 * directions
	 */
	public void tick() {
		timer++;
		int timerMax = 30;
		if (timer == timerMax) {
			timer = 0;
		}
		if (!right && !left) {
			velX = 0;
		}
		if (velY < -jumpSpeed) {
			velY += 1;
		}
		y += velY;
		x += velX;
	}

	/**
	 * Method for the collision with GameObject
	 * 
	 * @param object the GameObject to detect the collision with
	 * @return returns whether the player collides with the object or not
	 */
	public boolean checkCollision(GameObject object) {
		if (getBottom().intersects(object.getTop())) {
			y = object.getY() - (height);
			if (velY > 0)
				velY = 0;
			onGround = true;
			jumping = false;
			return true;
		} else if (getTop().intersects(object.getBottom())) {
			velY = 0;
			y = object.getY() + height;
			jumping = false;
			return true;
		} else if (getLeft().intersects(object.getRight())) {
			x = object.getX() + (width - 1);
			left = false;
			return true;
		} else if (getRight().intersects(object.getLeft())) {
			x = object.getX() - (width - 1);
			right = false;
			return true;
		}
		return false;
	}

	/**
	 * changes the movement in horizontal direction
	 * 
	 * @param velX the new movement speed in horizontal direction (xVel<0 --> left,
	 *             xVel>0 --> right)
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

	/**
	 * set method for boolean jumping
	 * 
	 * @param jumping the new value for this.jumping
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	/**
	 * changes the movement in vertical direction(used only when jumping)
	 * 
	 * @param velY the new movement speed in vertical direction
	 */
	public void setVelY(int velY) {
		if (velY < 0 && !jumping && onGround) {
			this.velY = velY;
			onGround = false;
		}
	}

}
