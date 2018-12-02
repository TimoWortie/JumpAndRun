
import ui.Game;

import org.junit.jupiter.api.Test;

import handler.Handler;
import objects.GameObject;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;

/**
 * Unit test for Game and Handler
 * 
 * @author Timo Wortmann
 * @since 01.12.2018
 * @version 1.0
 */
class GameTest {

	@Test
	/**
	 * Tests if the game stops properly and if the Thread is closed on shutdown
	 */
	void testShutdown() {
		Game game = new Game();
		game.start();
		game.shutdown();
	}

	@Test
	/**
	 * Replication of the game loop Tests if the game runs 60 times per second
	 */
	void testFps() {
		boolean running = true;
		double tickCount = 60.0;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double nanosecounds = 1000000000.0 / tickCount;
		int ticks = 0;
		int seconds = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nanosecounds;
			lastTime = now;
			while (delta >= 1) {
				ticks++;
				delta--;
			}
			if (System.currentTimeMillis() - timer > 1000) {
				seconds++;
				if (seconds > 5) {
					return;
				}
				assertTrue(ticks < (tickCount + 2) && ticks > (tickCount - 2), "Tick count is not in range of "
						+ (tickCount - 1) + "-" + (tickCount + 1) + " at " + seconds + " seconds.");
				timer += 1000;
				ticks = 0;
			}
		}
	}

	/**
	 * Test block that extends GameObject Used for Tests only
	 * 
	 * @author Timo Wortmann
	 * @since 01.12.2018
	 * @version 1.0
	 */
	class TestBlock extends GameObject {

		public TestBlock(int x, int y, int width, int height) {
			super(x, y, width, height);
		}

		@Override
		public void render(Graphics g) {
		}

	}

	@Test
	/**
	 * Tests if the game adds and removes an Object properly
	 */
	void testHandleObject() {
		Handler testHandler = new Handler();
		GameObject block = new TestBlock(0, 0, 0, 0);
		int blockCount = testHandler.getBlocksCount();
		testHandler.addBlock(block);
		assertEquals(blockCount + 1, testHandler.getBlocksCount(),
				"The block count of " + testHandler.getBlocksCount() + " didnt match the expected " + blockCount + ".");
		testHandler.removeBlock(block);
		assertEquals(blockCount, testHandler.getBlocksCount(),
				"The block count of " + testHandler.getBlocksCount() + " didnt match the expected " + blockCount + ".");
	}

	@Test
	/**
	 * Tests for an error when trying to remove a block that is not there
	 */
	void testRemoveBlockOnEmptyHandler() {
		Handler testHandler = new Handler();
		GameObject block = new TestBlock(0, 0, 0, 0);
		testHandler.removeBlock(block);
	}

	@Test
	/**
	 * Tests if the handler removes a block with the same constructor as another one
	 */
	void testDuplicateBlock() {
		Handler testHandler = new Handler();
		GameObject block = new TestBlock(0, 0, 0, 0);
		GameObject blockDuplicate = new TestBlock(0, 0, 0, 0);
		int counter = testHandler.getBlocksCount();
		testHandler.addBlock(block);
		testHandler.removeBlock(blockDuplicate);
		assertEquals(counter + 1, testHandler.getBlocksCount(),
				"The bock count of " + testHandler.getBlocksCount() + " didnt match expected " + (counter + 1) + ".");
	}

}
