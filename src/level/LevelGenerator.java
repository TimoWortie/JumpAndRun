package level;

import java.util.ArrayList;

import objects.GameObject;
import objects.blocks.*;

/**
 * Creator of the LevelGenerator.
 * 
 * @author Maximilian Ott
 * @since 11.01.2019
 * @version 1.0
 */
public class LevelGenerator {
	private int levelWidth, levelHeight, blockHeight, blockWidth;

	private ArrayList<GameObject> blocks = new ArrayList<GameObject>();

	/**
	 * Constructor for the LevelGenerator
	 * 
	 * @param levelWidth
	 *            the height of the entire level
	 * @param levelHeight
	 *            the width of the entire level
	 * @param blockHeight
	 *            the height of a single block
	 * @param blockWidth
	 *            the width of a single block
	 */
	public LevelGenerator(int levelWidth, int levelHeight, int blockHeight, int blockWidth) {
		this.levelWidth = levelWidth;
		this.levelHeight = levelHeight;
		this.blockHeight = blockHeight;
		this.blockWidth = blockWidth;
		createOuterBounds();
	}

	/**
	 * creates a box of stones around the current level so that the player can
	 * not walk out of bounds.
	 * 
	 */
	private void createOuterBounds() {
		for (int i = 0; i * blockWidth < levelWidth; i++) {
			for (int j = 0; j * blockHeight < levelHeight; j++) {
				if (i == 0 || levelWidth <= blockWidth * i + blockWidth)
					blocks.add(new Stone(i * blockWidth, j * blockHeight, blockWidth, blockHeight));
			}
		}
		for (int i = 1; i * blockWidth + blockWidth < levelWidth; i++) {
			blocks.add(new Stone(i * blockWidth, 0, blockWidth, blockHeight));
			blocks.add(new Stone(i * blockWidth, levelHeight - blockHeight, blockWidth, blockHeight));
		}
	}
	
	
	/**
	 * Creates stairs of blocks leading downwards
	 * @param startX the x coordinate of the upper left block
	 * @param startY the y coordinate of the upper left block
	 * @param steps	number of steps
	 */
	public void createStairsDown(int startX, int startY, int steps) {
		for (int i = 0; i * blockWidth + startX * blockWidth < levelWidth && i < steps; i++) {
			for (int j = 0; j * blockHeight + startY * blockHeight < levelHeight; j++) {
				if (i == j) {
					Stone toAdd = new Stone(i * blockWidth + startX * blockWidth,
							j * blockHeight + startY * blockHeight, blockWidth, blockHeight);
					if (!checkIfBlockExists(toAdd)) {
						blocks.add(toAdd);
					}
				}
			}
		}
	}
	
	/**
	 * Creates stairs of blocks leading upwards.
	 * @param startX the x coordinate of the lower left block
	 * @param startY the y coordinate of the lower left block
	 * @param steps	number of steps
	 */
	public void createStairsUp(int x, int y, int steps) {
		for (int i = 0; i * blockWidth + x * blockWidth < levelWidth && i < steps; i++) {
			for (int j = 0; y * blockHeight - j * blockHeight < levelHeight; j++) {
				if (i == j) {
					Stone toAdd = new Stone(i * blockWidth + x * blockWidth, y * blockHeight - j * blockHeight,
							blockWidth, blockHeight);
					if (!checkIfBlockExists(toAdd)) {
						blocks.add(toAdd);
					}
				}
			}
		}
	}
	
	/**
	 * Adds a single block to the level
	 * @param x the x coordinate of the block
	 * @param y the y coordinate of the block
	 */
	public void addBlock(int x, int y) {
		if (x * blockWidth < levelWidth && x > 0 && y > 0 && y * blockHeight < levelHeight) {
			Stone toAdd = new Stone(x * blockWidth, y * blockHeight, blockWidth, blockHeight);
			if (!checkIfBlockExists(toAdd)) {
				blocks.add(toAdd);
			}
		}
	}
	
	
	/**
	 * Creates a platform in the shape of a rectangle made out of blocks
	 * @param x the x coordinate of the upper left block
	 * @param y	the y coordinate of the upper left block
	 * @param width	the amount of block the platform is wide
	 * @param height	the amount of block the platform is high
	 */
	public void createPlattform(int x, int y, int width, int height) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Stone toAdd = new Stone(x * blockWidth + i * blockWidth, y * blockHeight + j * blockHeight, blockWidth,
						blockHeight);
				if (!checkIfBlockExists(toAdd)) {
					blocks.add(toAdd);
				}
			}
		}
	}
	
	
	/**
	 * returns the blocks for use in the Handler
	 * @return the ArrayList of stored GameObjects
	 */
	public ArrayList<GameObject> getLevel() {
		return blocks;
	}

	
	/**
	 * Tests whether a block is already added to the level
	 * @param block the block to test for
	 * @return true if the block is already added; false if not
	 */
	public boolean checkIfBlockExists(GameObject block) {
		for (GameObject testFor : blocks) {
			if (testFor.getX() == block.getX() && testFor.getY() == block.getY()) {
				return true;
			}
		}
		return false;
	}

}
