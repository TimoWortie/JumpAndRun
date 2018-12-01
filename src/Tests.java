
import ui.Game;

import org.junit.jupiter.api.Test;

import handler.Handler;
import objects.GameObject;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;

/**
 * Unit test for ...
 * 
 * @author
 * @since
 * @version
 */
class Tests {

	@Test
	void testShutdown() {
		Game game = new Game();
		game.start();
		game.shutdown();
	}

	@Test
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

	class TestBlock extends GameObject {

		public TestBlock(int x, int y, int width, int height) {
			super(x, y, width, height);
		}

		@Override
		public void render(Graphics g) {
			// do nothing
		}

	}

	@Test
	public void test() {
		Handler testHandler = new Handler();
		GameObject block = new TestBlock(0, 0, 0, 0);
		int blockCount = testHandler.getBlocksCount();
		testHandler.addBlock(block);
		assertEquals(blockCount, testHandler.getBlocksCount(),
				"The block count of " + testHandler.getBlocksCount() + " didnt match the expected " + blockCount + ".");
	}

}
