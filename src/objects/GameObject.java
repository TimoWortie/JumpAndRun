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

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public Rectangle getRight() {
		return new Rectangle(x + width - 15, y + 5, 15, height - 10);
	}

	public Rectangle getLeft() {
		return new Rectangle(x, y + 5, 15, height - 10);
	}

	public Rectangle getBottom() {
		return new Rectangle(x, y + height - 15, width, 15);
	}

	public Rectangle getTop() {
		return new Rectangle(x + 5, y, width - 10, 15);
	}

	public void renderBounds(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x + 5, y, width - 10, 15);
		g.fillRect(x, y + height - 15, width, 15);
	}

}
