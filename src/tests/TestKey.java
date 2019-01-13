package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Button;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

import input.Key;

/**
 * Unit test for Key
 * 
 * @author Carina Fenn
 */
public class TestKey {
	/**
	 * tests the key input for the key "d"
	 */
	@Test
	void testKeyInputD() {
		Key key = new Key();
		Button button = new Button("click");
		KeyEvent event = new KeyEvent(button, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 68, 'd');
		key.keyPressed(event);
		assertEquals(true, key.isRight());
		event = new KeyEvent(button, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, 68, 'a');
		key.keyReleased(event);
		assertEquals(false, key.isRight());
	}

	/**
	 * tests the key input for the key "w"
	 */
	@Test
	void testKeyInputW() {
		Key key = new Key();
		Button button = new Button("click");
		KeyEvent event = new KeyEvent(button, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 87, 'w');
		key.keyPressed(event);
		assertEquals(true, key.isUp());
		event = new KeyEvent(button, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, 87, 'w');
		key.keyReleased(event);
		assertEquals(false, key.isUp());
	}

	/**
	 * tests the key input for the key "a"
	 */
	@Test
	void testKeyInputA() {
		Key key = new Key();
		Button button = new Button("click");
		KeyEvent event = new KeyEvent(button, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 65, 'a');
		key.keyPressed(event);
		assertEquals(true, key.isLeft());
		event = new KeyEvent(button, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, 65, 'a');
		key.keyReleased(event);
		assertEquals(false, key.isLeft());
	}

}
