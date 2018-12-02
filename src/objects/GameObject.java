package objects;

import java.awt.Graphics;
/**
 * Creator for Objects(blocks/Stone).
 * 
 * @author Maximilian Ott
 * @since 02.12.2018
 * @version 1.0
 */
public abstract class GameObject {
	protected int height, width,x, y;
	/**
	 *initialization for needed components.
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
		
		
}
