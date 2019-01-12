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
 * @since 27.11.2018
 * @version 1.0
 */
public class Handler {

	private ArrayList<GameObject> blocks = new ArrayList<>();
	private Player player;
	private Key key;
	private LevelGenerator gen;

	public Handler(Key key) {
		this.key = key;
	}

	/**
	 * Runs the tick() method of the generated Player In the future: Runs tick()
	 * method of other entities(e.g enemies) as well
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
	 * Initializes player and blocks. This method is only executed once at the
	 * start of the game
	 *
	 */
	public void init() {
		Sprite.init();
		gen=new LevelGenerator(0, 0, 1280, 790, 48, 48);
		blocks=gen.getLevel();
		player = new Player(100, 250, 48, 48);
		blocks.add(new Stone(100, 100, 48, 48));
		blocks.add(new Stone(100, 400, 48, 48));
		blocks.add(new Stone(250, 300, 48, 48));

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
