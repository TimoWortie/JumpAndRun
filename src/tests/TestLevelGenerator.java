package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import graphics.Sprite;
import level.LevelGenerator;
import objects.GameObject;

/**
 * Unit test for Game and Handler
 * 
 * @author Maximilian Ott
 * @since 12.01.2019
 * @version 1.0
 */
public class TestLevelGenerator {
	
	/**
	 * Tests if the bounds of the level are generated properly.
	 */
	@Test
	void testConstructor() {
		Sprite.init();
		LevelGenerator gen = new LevelGenerator(10, 10, 10, 10);
		assertEquals(1, gen.getLevel().size());
	}
	
	/**
	 * Tests whether the generator adds duplicate blocks.
	 */
	@Test
	void testAddDuplicate() {
		Sprite.init();
		LevelGenerator gen = new LevelGenerator(10, 10, 10, 10);
		gen.addBlock(0, 0);
		assertEquals(1, gen.getLevel().size());
	}
	
	/**
	 * Tests if generator adds the block at the right position and with the right width and height.
	 */
	@Test
	void testAddBlock() {
		Sprite.init();
		LevelGenerator gen = new LevelGenerator(20, 20, 1, 1);
		int previousLength = gen.getLevel().size();
		gen.addBlock(2, 3);
		assertEquals(2, gen.getLevel().get(gen.getLevel().size() - 1).getX());
		assertEquals(3, gen.getLevel().get(gen.getLevel().size() - 1).getY());
		assertEquals(1, gen.getLevel().get(gen.getLevel().size() - 1).getWidth());
		assertEquals(1, gen.getLevel().get(gen.getLevel().size() - 1).getHeight());
		assertEquals(previousLength + 1, gen.getLevel().size());
	}
	
	
	/**
	 * Tests if the generator adds a new plattform of blocks properly and checks the coordinates of every block added.
	 */
	@Test
	void testCreatePlattform() {
		Sprite.init();
		LevelGenerator gen = new LevelGenerator(20, 20, 1, 1);
		int previousLength = gen.getLevel().size();
		gen.createPlattform(5, 5, 6, 3);
		assertEquals(previousLength + 18, gen.getLevel().size());
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				GameObject block = gen.getLevel().get(previousLength + (j + 3 * i));
				assertEquals(5 + i, block.getX());
				assertEquals(5 + j, block.getY());
			}
		}
	}

}
