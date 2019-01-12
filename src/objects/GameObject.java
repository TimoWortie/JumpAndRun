package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Creator for Objects(blocks/Stone).
 * 
 * @author Maximilian Ott
 * @since 02.12.2018
 * @version 1.0
 */
public abstract class GameObject {
	protected int height, width, x, y;
	private static int collisionFactor=4;

	/**
	 * initialization for needed components.
	 */
	public GameObject(int x, int y, int width, int height) {
		super();
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the number of height.
	 *
	 * @return the number of height in ArrayList blocks.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height for GameObjects.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the number of the width.
	 *
	 * @return the number of width in ArrayList blocks.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width for GameObjects.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the number of coordinate x.
	 *
	 * @return the number of x in ArrayList blocks.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the coordinate x for GameObjects.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the number of coordinate y.
	 *
	 * @return the number of y in ArrayList blocks.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the coordinate y for GameObjects.
	 */
	public void setY(int y) {
		this.y = y;
	}

	public abstract void render(Graphics g);

	/**
	 * Gets the entire bounds of object(used in collision detection)
	 * 
	 * @return a rectangle of the current bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	/**
	 * Gets the right bounds of object(used in collision detection)
	 * 
	 * @return a rectangle of the current right bounds
	 */
	public Rectangle getRight() {
		return new Rectangle(x + width - collisionFactor*3, y + collisionFactor, collisionFactor*3, height - collisionFactor*2);
	}

	/**
	 * Gets the left bounds of object(used in collision detection)
	 * 
	 * @return a rectangle of the current left bounds
	 */
	public Rectangle getLeft() {
		return new Rectangle(x, y + collisionFactor, collisionFactor*3, height - collisionFactor*2);
	}

	/**
	 * Gets the lower bounds of object(used in collision detection)
	 * 
	 * @return a rectangle of the current lower bounds
	 */
	public Rectangle getBottom() {
		return new Rectangle(x, y + height -collisionFactor*3, width, collisionFactor*3);
	}

	/**
	 * Gets the upper bounds of object(used in collision detection)
	 * 
	 * @return a rectangle of the current upper bounds
	 */
	public Rectangle getTop() {
		return new Rectangle(x + collisionFactor, y, width - collisionFactor*2, collisionFactor*3);
	}
	
	
	public void renderCollision(Graphics g){
		g.setColor(Color.red);
		g.fillRect(x+collisionFactor, y, width-collisionFactor*2, collisionFactor*3);
		g.fillRect(x, y+height-collisionFactor*3, width-collisionFactor*2, collisionFactor*3);
		g.fillRect(x, y+collisionFactor, collisionFactor*3, height-collisionFactor*2);
		g.fillRect(x+width-collisionFactor*3, y+collisionFactor, collisionFactor*3, height-collisionFactor*2);
	}

}
