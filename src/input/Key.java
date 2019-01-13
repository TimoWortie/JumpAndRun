package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Creator of the Key.
 * 
 * @author Carina Fenn
 * @since 14.12.2018
 * @version 1.0
 */

public class Key implements KeyListener {

	private boolean left;
	private boolean right;
	private boolean up;

	/**
	 * run method if key is pressed.
	 * 
	 */

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_D) {
			right = true;
		}
		if (key == KeyEvent.VK_A) {
			left = true;
		}
		if (key == KeyEvent.VK_W) {
			up = true;
		}
	}

	/**
	 * run method if key is released.
	 * 
	 */

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_D) {
			right = false;
		}
		if (key == KeyEvent.VK_A) {
			left = false;
		}
		if (key == KeyEvent.VK_W) {
			up = false;
		}
	}

	/**
	 * Returns whether the player should walk left
	 * 
	 * @return true while a is pressed
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * Returns whether the player should walk right
	 * 
	 * @return true while d is pressed
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * method from interface KeyListener. not used.
	 */
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Returns whether the player should jump
	 * 
	 * @return true while w is pressed
	 */
	public boolean isUp() {
		return this.up;
	}

}
