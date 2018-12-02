package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {

	private boolean shift;
	private boolean a;
	private boolean d;

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_D) {
			d = true;
		}
		if (key == KeyEvent.VK_A) {
			a = true;
		}
		if (key == KeyEvent.VK_W) {

		}

		if (key == KeyEvent.VK_ESCAPE) {
		}

		if (key == KeyEvent.VK_SHIFT) {
			shift = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_D) {
			d = false;
		}
		if (key == e.VK_A) {
			a = false;
		}
		if (key == KeyEvent.VK_SHIFT) {
			shift = false;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

}
