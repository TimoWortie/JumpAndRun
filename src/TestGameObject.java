
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import objects.blocks.Stone;

class TestGameObject {
	/**
	 * Tests if setters and getters can function together.
	 */
	@Test
	public void test() {
		Stone gm = new Stone(0, 0, 0, 0);
		gm.setHeight(200);
		assertEquals(200, gm.getHeight());

	}

	/**
	 * Tests if the getter is able to use the input of the constructor.
	 */

	@Test
	public void test2() {
		Stone gm = new Stone(100, 100, 0, 0);
		assertEquals(100, gm.getY());

	}

	/**
	 * Tests if setters and getters can function together.
	 */
	@Test
	public void test3() {
		Stone gm = new Stone(0, 0, 0, 0);
		gm.setWidth(200);
		assertEquals(200, gm.getWidth());
	}

	/**
	 * Tests if setters and getters can function together.
	 */
	@Test
	public void test4() {
		Stone gm = new Stone(0, 0, 0, 0);
		gm.setX(200);
		assertEquals(200, gm.getX());
	}

	/**
	 * Tests if setters and getters can function together.
	 */
	@Test
	public void test5() {
		Stone gm = new Stone(0, 0, 0, 0);
		gm.setY(200);
		assertEquals(200, gm.getY());
	}

	/**
	 * Tests if the getter is able to use the input of the constructor.
	 */

	@Test
	public void test6() {
		Stone gm = new Stone(100, 100, 100, 100);
		assertEquals(100, gm.getX());
	}

	/**
	 * Tests if the getter is able to use the input of the constructor.
	 */

	@Test
	public void test7() {
		Stone gm = new Stone(100, 100, 100, 100);
		assertEquals(100, gm.getWidth());
	}

	/**
	 * Tests if the getter is able to use the input of the constructor.
	 */

	@Test
	public void test8() {
		Stone gm = new Stone(100, 100, 100, 100);
		assertEquals(100, gm.getHeight());
	}
}
