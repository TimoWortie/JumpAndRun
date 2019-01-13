package handler;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import graphics.Sprite;
import input.Key;
import level.LevelGenerator;
import objects.GameObject;
import objects.blocks.Stone;
import objects.player.Player;

/**
 * Handling of Player and Blocks for the Game.
 * 
 * @author Timo Wortmann
 * @since 12.01.2019
 * @version 1.3
 */
public class Handler {

	private ArrayList<GameObject> blocks = new ArrayList<>();
	private Player player;
	private Key key;
	private LevelGenerator gen;

	/**
	 * Constructor for the handler.
	 * 
	 * @param key
	 *            the KeyInput used for the player
	 */
	public Handler(Key key) {
		this.key = key;
	}

	/**
	 * Runs the tick method of the player and executes the collision and
	 * movement calculation methods of the player
	 * 
	 */
	public void tick() {
		player.calculateMovement(key);
		for (GameObject bl : blocks) {
			player.checkCollision(bl);
		}
		player.tick();
	}

	/**
	 * draws the Player and all Blocks
	 * 
	 * @param g
	 *            Graphics object where everything will be drawn on
	 */
	public void render(Graphics g) {
		for (GameObject bl : blocks) {
			bl.render(g);
		}

		player.render(g);
	}

	/**
	 * Initializes player, Spritesheet(per Sprite.init()) and level. This method
	 * is only executed once at the start of the game
	 * @param levelWidth	the width of the level
	 * @param levelHeight the height of the level
	 *
	 */
	public void init(int levelWidth, int levelHeight) {
		Sprite.init();
		gen = new LevelGenerator(levelWidth, levelHeight, 48, 48);
		player = new Player(100, 100, 48, 48);
		gen.createStairsDown(1, 5, 4);
		gen.createStairsUp(10, 10, 5);
		gen.addBlock(4, 10);
		gen.createPlattform(16, 11, 6, 3);
		//more blocks can be added here
		blocks = gen.getLevel();

	}

	/**
	 * Adds a block to the managed objects
	 *
	 * @param block
	 *            block to add
	 */
	public void addBlock(GameObject block) {
		blocks.add(block);
	}

	/**
	 * Removes a block from the managed objects
	 *
	 * @param block
	 *            block to remove
	 */
	public void removeBlock(GameObject block) {
		blocks.remove(block);
	}

	/**
	 * Gets the number of managed blocks
	 *
	 * @return the number of blocks in ArrayList blocks
	 */
	public int getBlocksCount() {
		return blocks.size();
	}
}
