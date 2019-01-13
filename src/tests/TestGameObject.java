package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphics.Sprite;
import objects.blocks.Stone;

/**
 * Unit test for Game and Handler
 * 
 * @author Maximilian Ott
 * @since 01.12.2018
 * @version 1.0
 */
class TestGameObject {
	/**
	 * Tests if setters and getters can function together.
	 */
	@Test
	public void testHeightSetter() {
		Sprite.init();
		Stone gm = new Stone(0, 0, 0, 0);
		gm.setHeight(200);
		assertEquals(200, gm.getHeight());

	}

	/**
	 * Tests if the getter is able to use the input of the constructor.
	 */

	@Test
	public void testConstructorWithY() {
		Sprite.init();
		Stone gm = new Stone(100, 100, 0, 0);
		assertEquals(100, gm.getY());

	}

	/**
	 * Tests if setters and getters can function together.
	 */
	@Test
	public void testWidthSetter() {
		Sprite.init();
		Stone gm = new Stone(0, 0, 0, 0);
		gm.setWidth(200);
		assertEquals(200, gm.getWidth());
	}

	/**
	 * Tests if setters and getters can function together.
	 */
	@Test
	public void testXSetter() {
		Sprite.init();
		Stone gm = new Stone(0, 0, 0, 0);
		gm.setX(200);
		assertEquals(200, gm.getX());
	}

	/**
	 * Tests if setters and getters can function together.
	 */
	@Test
	public void testYSetter() {
		Sprite.init();
		Stone gm = new Stone(0, 0, 0, 0);
		gm.setY(200);
		assertEquals(200, gm.getY());
	}

	/**
	 * Tests if the getter is able to use the input of the constructor.
	 */

	@Test
	public void testConstructorWithX() {
		Sprite.init();
		Stone gm = new Stone(100, 100, 100, 100);
		assertEquals(100, gm.getX());
	}

	/**
	 * Tests if the getter is able to use the input of the constructor.
	 */

	@Test
	public void testConstructorWithWidth() {
		Sprite.init();
		Stone gm = new Stone(100, 100, 100, 100);
		assertEquals(100, gm.getWidth());
	}

	/**
	 * Tests if the getter is able to use the input of the constructor.
	 */

	@Test
	public void testConstructorWithHeight() {
		Sprite.init();
		Stone gm = new Stone(100, 100, 100, 100);
		assertEquals(100, gm.getHeight());
	}
}
