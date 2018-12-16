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

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public void keyTyped(KeyEvent e) {

	}

	public boolean isUp() {
		return this.up;
	}

}
