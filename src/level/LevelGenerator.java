package level;

import java.util.ArrayList;

import objects.GameObject;
import objects.blocks.*;

public class LevelGenerator {
	private int levelWidth, levelHeight, blockHeight, blockWidth;

	private ArrayList<GameObject> blocks = new ArrayList<GameObject>();

	public LevelGenerator(int levelWidth, int levelHeight, int blockHeight, int blockWidth) {
		this.levelWidth = levelWidth;
		this.levelHeight = levelHeight;
		this.blockHeight = blockHeight;
		this.blockWidth = blockWidth;
		createOuterBounds();
	}

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

	public void createStairsDown(int startX, int startY, int steps) {
		for (int i = 0; i * blockWidth + startX * blockWidth < levelWidth - blockWidth && i < steps; i++) {
			for (int j = 0; j * blockHeight + startY * blockHeight < levelHeight - blockHeight; j++) {
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

	public void addBlock(int x, int y) {
		if (x * blockWidth < levelWidth && x > 0 && y > 0 && y * blockHeight < levelHeight) {
			Stone toAdd = new Stone(x * blockWidth, y * blockHeight, blockWidth, blockHeight);
			if (!checkIfBlockExists(toAdd)) {
				blocks.add(toAdd);
			}else{
				System.out.println("not added");
			}
		}
	}

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

	public ArrayList<GameObject> getLevel() {
		return blocks;
	}

	public boolean checkIfBlockExists(GameObject block) {
		for (GameObject testFor : blocks) {
			if (testFor.getX() == block.getX() && testFor.getY() == block.getY()) {
				return true;
			}
		}
		return false;
	}

}
