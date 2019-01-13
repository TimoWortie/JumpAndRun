package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Button;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

import graphics.Sprite;
import input.Key;
import objects.blocks.Stone;
import objects.player.Player;

/**
 * Unit test for Key
 * 
 * @author Alischa Fenn
 */
public class TestPlayer {
	/**
	 * tests if the Collision is working when the block and player are in the same
	 * place
	 */
	@Test
	void testCollisionGeneral() {
		Sprite.init();
		Player player = new Player(0, 0, 10, 10);
		Stone stone = new Stone(0, 0, 10, 10);
		assertEquals(true, player.checkCollision(stone));
	}

	/**
	 * tests if the collision is working, when the player stans on top of a block
	 */
	@Test
	void testCollisionDown() {
		Sprite.init();
		Player player = new Player(0, 0, 10, 10);
		Stone stone = new Stone(0, 10, 10, 10);
		assertEquals(true, player.checkCollision(stone));
		assertEquals(true, player.getBottom().intersects(stone.getTop()));
		assertEquals(false, player.getTop().intersects(stone.getBottom()));
	}

	/**
	 * tests if the player reacts to KeyEvents from the KeyInput
	 */
	@Test
	void testMovement() {
		Sprite.init();
		Player player = new Player(0, 0, 10, 10);
		Key key = new Key();
		Button button = new Button("click");
		KeyEvent event = new KeyEvent(button, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 68, 'd');
		key.keyPressed(event);
		player.calculateMovement(key);
		player.tick();
		assertEquals(5, player.getX());
		player.tick();
		assertEquals(10, player.getX());
	}

}
