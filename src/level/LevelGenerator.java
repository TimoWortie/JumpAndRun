package level;

import java.util.ArrayList;

import objects.GameObject;

public class LevelGenerator {
	private LevelList list;
	
	public LevelGenerator(int startX, int startY,int levelWidth, int levelHeight,int blockHeight, int blockWidth){
		list=new LevelList(startX, startY, levelWidth, levelHeight, blockHeight, blockWidth);
		
	}
	
	public ArrayList<GameObject> getLevel() {
		return list.getBlocks();
	}

}
